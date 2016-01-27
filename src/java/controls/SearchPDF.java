/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import myObjects.PDF_Cortical;
import myObjects.PDF_Semantics_DB;
import io.cortical.rest.model.Fingerprint;
import io.cortical.services.api.client.ApiException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import myObjects.Search_Params;
import myObjects.Search_Result;

/**
 *
 * @author Roman Toda <roman.toda@gmail.com>
 */
public class SearchPDF extends HttpServlet {

    public SearchPDF() {
    }
        
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws io.cortical.services.api.client.ApiException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ApiException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        //set & remember search params
        Search_Params searchParams = (Search_Params)session.getAttribute("SearchParams");
        if(searchParams == null){
            searchParams = new Search_Params();
            session.setAttribute("SearchParams", searchParams);
        }            
        searchParams.loadFromRequest(request);
        
        // empty response
        if (searchParams.getSearchFileID() == -1 && searchParams.getSearchString().isEmpty()){
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response); 
            return;
        }
        
        PDF_Semantics_DB db=new PDF_Semantics_DB();
        try (Connection conn = db.Connection()) {
            String sql;
            if (searchParams.getSearchFileID() != -1 ){
                sql = SQLForSimilar(searchParams);
            } else {
                // searching by string
                sql = SQLForSearchString(searchParams);
            }
            
            Statement myStatement = conn.createStatement();
            ResultSet rs = myStatement.executeQuery(sql);
            
            
            //remember search result
            ArrayList rows = new ArrayList();
            Integer count = 0;
            while (rs.next() && count<50) {
                Search_Result row = new Search_Result();
                row.setFileID(rs.getInt("fileid"));
                row.setFileName(rs.getString("fileName"));
                row.setText(rs.getString("text"));
                row.setScore(rs.getInt("count(D1.fileid)"));
                row.setPageID(rs.getInt("pageid"));
                row.setParagraphID(rs.getInt("paragraphid"));
                rows.add(row);          
                count++;
            }
            
            //request.setAttribute("SearchResults", rows);
            session.setAttribute("SearchResults", rows);            
            rs.close();
            myStatement.close();
            conn.close();
        } catch (Exception e) {
        }
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ApiException | SQLException ex) {
            Logger.getLogger(SearchPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ApiException | SQLException ex) {
            Logger.getLogger(SearchPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String SQLForSimilar(Search_Params searchParams) {
        
        String sql;
        //searching similar to what? if to file=>
        //        AND (D2.fileid = #SomeNumber)
        //        AND (D2.pageid = -1) 
        //        AND (D2.paragraphid=-1)
        //searching where? if in files=>
        //        AND (D1.pageid=-1)
        //        AND (D1.paragraphid=-1)
        
        sql =   "SELECT  D1.fileid, D1.pageid, D1.paragraphid, D3.fileName, D3.text, count(D1.fileid) \n" +
                "FROM  pdf_file_fingerprint D1, pdf_file_fingerprint D2," + 
                "pdf_files D3 \n" +
                "WHERE (D1.position=D2.position) \n" +
                " AND (D2.fileid = ";
        sql+=   String.valueOf(searchParams.getSearchFileID());
        sql+=   ") \n" +
                " AND (D2.pageid = ";
        sql+=   String.valueOf(searchParams.getSearchPageID());
        sql+=   ") \n" +
                " AND (D2.paragraphid = ";
        sql+=   String.valueOf(searchParams.getSearchParagraphID());
        sql+=   ")  AND (D1.fileid=D3.id) AND (D1.pageid = D3.pageid) AND (D1.paragraphid = D3.paragraphid) \n";
        
        //where are we searching? files,pages,paragraphs?
        sql+= AppendSearchWhereCondition(searchParams);
        
        sql+=   "GROUP BY D1.fileid, D1.pageid, D1.paragraphid ORDER BY count(D1.fileid) DESC";    
        
        return sql;
    }

    private String SQLForSearchString(Search_Params searchParams) throws ApiException {
        
        PDF_Cortical cort = new PDF_Cortical();
        String sql;
        
        Fingerprint fingerprint;
        fingerprint = cort.getStringFingerPrint(searchParams.getSearchString());

        // write fingerprint for whole file
        sql =   "SELECT D1.fileid, D2.fileName, D2.text, D1.pageid, D1.paragraphid, count(D1.fileid)  \n" +
                "FROM  pdf_file_fingerprint D1, pdf_files D2  \n" +
                "WHERE (D1.fileid=D2.id) AND (D1.pageid=D2.pageid) AND (D1.paragraphid = D2.paragraphid) \n";

        //where are we searching? files,pages,paragraphs?
        sql+= AppendSearchWhereCondition(searchParams);

        //what type of fingerprint
        String oneCondition = "AND ( ( position = %d )";
        for (int i = 0; i < fingerprint.getPositions().length; i++) {
            sql += String.format(oneCondition,fingerprint.getPositions()[i]);
            oneCondition = "OR ( position = %d ) ";
        }
        sql+=") GROUP BY D1.fileid, D1.pageid, D1.paragraphid ORDER BY count(D1.fileid) DESC ";
        
        return sql;
    }

    private String AppendSearchWhereCondition(Search_Params searchParams) {
        String retS;
        switch (searchParams.getSearchWhere()) {
            case 0:
                // search in files
                retS=   " AND (D1.pageid=-1) "+
                        " AND (D1.paragraphid=-1)";
                break;
            case 1:
                // search in pages
                retS=   " AND (D1.pageid<>-1) "+
                        " AND (D1.paragraphid=-1)";
                break;
            default:
                // search in paragraphs
                retS=   " AND (D1.paragraphid<>-1)";
                break;
        }
        return retS;
    }

}


//            <form id="formid" method="post" action="SearchPDF?search_where="<%=sp.getSearchString()%>" enctype="multipart/form-data">
//                <a href="#" onclick="document.getElementById('formid').submit()">Similar</a>
//            </form>
