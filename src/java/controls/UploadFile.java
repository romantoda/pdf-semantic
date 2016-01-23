package controls;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import myObjects.PDF_Cortical;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import myObjects.PDF_Semantics_DB;
import io.cortical.rest.model.Fingerprint;
import io.cortical.services.api.client.ApiException;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import pdfix.pdfixlib.*;
import sun.misc.IOUtils;



//@WebServlet("/uploadServlet")
//@MultipartConfig(maxFileSize = 16177215)
@MultipartConfig(location=myObjects.Settings.TEMP_FOLDER, maxFileSize = 10485760L)

/**
 *
 * @author Roman Toda <roman.toda@gmail.com>
 */
public class UploadFile extends HttpServlet {
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
        //processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        // creates the save directory if it does not exists
        File fileSaveDir = new File(myObjects.Settings.FILE_FOLDER);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }        
        Boolean lRet = false;
        for(Part part : request.getParts()) {
            if(! "upload".equals(part.getName())) {
                String fileName = getFileName(part);
                try {
                    try {
                        ProcessFile(part.getInputStream(), fileSaveDir, fileName);
                    } catch (ApiException ex) {
                        out.println("Problem ApiException ");
                        return;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
                    out.println("Problem SQLException ");
                    return;
                }
            }
        }
       
        out.println("File Processed. ");
//        RequestDispatcher rs = request.getRequestDispatcher("indexmanager.jsp");
//        rs.include(request, response);
    }

    
    /**
     * ProcessFile (insert into DB, copy to repo, create fingerprints
     */
    private void ProcessFile(InputStream fileContent, File repositoryDir, String fileName ) throws IOException, SQLException, ApiException {
        
        Random rand = new Random();
        int  fileID = rand.nextInt(9999) + 1;
        String idTemp=(String.valueOf(fileID));
        
        PDF_Semantics_DB db=new PDF_Semantics_DB();
        PDF_Cortical cort = new PDF_Cortical();
        int rowFiles = 0;
        try (Connection conn = db.Connection()) {
            String realFileName = idTemp + "_" + fileName;
            File file = new File(repositoryDir, realFileName);
            long copy = Files.copy(fileContent, file.toPath());
            String absoluteFileName = file.toPath().toString();
            
            String fileString = ""; //readFile(txtFileName, StandardCharsets.UTF_8);            
            
            // init pdfix
            
            pdfix pfix = new pdfix();
            pfix.PdfInitLibrary();
            long doc_pdfix = pfix.PdfDocOpen(absoluteFileName, "");
            if (doc_pdfix != 0) {
                
                int num_pages = pfix.PdfDocGetNumPages(doc_pdfix);   
                for (int pagenum = 0; pagenum<num_pages; pagenum++)
                {
                    long page_pdfix = pfix.PdfDocAcquirePage(doc_pdfix, pagenum);
                    long pagemap_pdfix = pfix.PdfPageAcquirePageMap(page_pdfix, 0, 0);
                    int count = pfix.PdfPageMapGetNumElements(pagemap_pdfix);
                    String pageString = ""; 

                    for (int element = 0; element < count; element++) {
                        long elem_pdfix = pfix.PdfPageMapGetElement(pagemap_pdfix, element);
                        ProcessElement(pfix, elem_pdfix, fileString, pageString, 
                            conn, cort, fileID, pagenum, element, fileName);
//                        long type = pfix.PdeElementGetType(elem_pdfix);
//                        if (type == 3) {                   
//                            String str = pfix.PdeTextGetText(elem_pdfix);
//                            if (! str.isEmpty()) {
//                                fileString+=str;
//                                pageString+=str;
//                                // fingerprint for paragraph
//                                if (CommitToDB(conn, cort, str, fileID, pagenum, element)>0)
//                                    CommitTextToDB( conn, fileID, fileName, str, pagenum, element);
//                            }
//                       }
                    }
                    
                    // fingerprint for whole page 
                    if (CommitToDB(conn, cort, pageString, fileID, pagenum, -1)>0)
                        CommitTextToDB( conn, fileID, fileName, pageString, pagenum, -1);
                    pfix.PdfPageMapRelease(pagemap_pdfix);
                    pfix.PdfPageRelease(page_pdfix);
                }
 

                // fingerprint for the whole file
                if (CommitToDB(conn, cort, fileString, fileID, -1, -1) >0)
                    CommitTextToDB( conn, fileID, fileName, fileString, -1, -1);
                pfix.PdfDocClose(doc_pdfix);
            }    
            String s = pfix.PdfGetLastError();
            pfix.PdfDestroyLibrary();        
        }
    }
    
    void ProcessElement(pdfix pfix, long elem_pdfix, String fileString, String pageString, 
            Connection conn, PDF_Cortical cort, int fileID, int pagenum, 
            int element, String fileName) {
      long type = pfix.PdeElementGetType(elem_pdfix);
      if (type == 3) {                   
        String str = pfix.PdeTextGetText(elem_pdfix);
        if (! str.isEmpty()) {
            try {
                fileString+=str;
                pageString+=str;
                // fingerprint for paragraph
                if (CommitToDB(conn, cort, str, fileID, pagenum, element)>0)
                    CommitTextToDB( conn, fileID, fileName, str, pagenum, element);
            } catch (ApiException ex) {
                Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      }
      long num_childs = pfix.PdeElementGetNumChildren(elem_pdfix);
      for (int j = 0; j < num_childs; j++) {
        long elem2 = pfix.PdeElementGetChild(elem_pdfix, j);
        ProcessElement(pfix, elem_pdfix, fileString, pageString, 
            conn, cort, fileID, pagenum, element, fileName);
      }      
    }

    
     /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }   
    
    private String readFile(String path, Charset encoding) 
    throws IOException 
    {
      byte[] encoded = Files.readAllBytes(Paths.get(path));
      return new String(encoded, encoding);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Upload file to index manager";
    }// </editor-fold>

    private int CommitToDB(Connection conn, PDF_Cortical cort, String str, int fileID, int pageid, int paragraphid) throws ApiException {
        try {
            Fingerprint fingerprint = null;
            int len;
            try {
                fingerprint = cort.getStringFingerPrint(str);
                len = fingerprint.getPositions().length;
            } catch (Exception e)
            {
                len = 0;
            }
            
            String sqlFinger = "INSERT INTO pdf_file_fingerprint (fileid, position, pageid, paragraphid ) values (?, ?, ?, ?)";
            PreparedStatement statementFinger = conn.prepareStatement(sqlFinger);
            
            for (int i = 1; i <= len; i++) {
                statementFinger.setInt(1, fileID);
                statementFinger.setInt(2, fingerprint.getPositions()[i-1]);
                statementFinger.setInt(3, pageid);
                statementFinger.setInt(4, paragraphid);
                statementFinger.addBatch();
                
                if (i % 1000 == 0 || i == len ) {
                    statementFinger.executeBatch(); // Execute every 1000 items.
                }
            }
            return len;
        } catch (SQLException ex) {
            Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    private void CommitTextToDB(Connection conn, int fileID, String fileName, String text, int pageid, int paragraphid) {
        try {
            // insert file mark into db
            int maxLength = (text.length() < 512)?text.length():512;
            text = text.substring(0, maxLength);
            
            String sql = "INSERT INTO pdf_files (id, fileName, text, pageid, paragraphid ) values (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, fileID);
            statement.setString(2, fileName);
            statement.setString(3, text);
            statement.setInt(4, pageid);
            statement.setInt(5, paragraphid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
