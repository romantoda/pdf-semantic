<%-- 
    Document   : ViewPDF
    Created on : Dec 3, 2015, 10:49:00 AM
    Author     : Roman Toda <roman.toda@gmail.com>
--%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="myObjects.PDF_Semantics_DB"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View File</title>
    </head>
    <body>
        <%  
            String fileId = "";
            fileId = request.getParameter("search_fileID");

            Integer pageId = Integer.parseInt(request.getParameter("search_pageID"));
            Integer paragraphId = Integer.parseInt(request.getParameter("search_paragraphID"));
            //pageId = request.getParameter("search_pageID");
            //paragraphId = request.getParameter("search_paragraphID");
           
            try
            {    
                PDF_Semantics_DB my_db=new PDF_Semantics_DB();
                Connection conn= my_db.Connection();
            
                String sqlString = "SELECT fileName FROM pdf_files WHERE id = '"+fileId+"'";
                Statement myStatement = conn.createStatement();
                
                ResultSet rs=myStatement.executeQuery(sqlString);
                if (rs.next()) 
                {
                    File file = new File(myObjects.Settings.FILE_FOLDER,fileId+"_"+rs.getString("fileName"));
                    InputStream input = new FileInputStream(file);
                    if (pageId==-1)
                    {
                        // send back whole pdf
                        long len = (int) file.length();
                        if (len<=Integer.MAX_VALUE)
                            response.setContentLength((int)len);

                        response.setContentType("application/pdf");
                        response.setHeader("Content-Disposition", "inline; filename=help.pdf");
                        response.setHeader("Cache-Control", "cache, must-revalidate");
                        response.setHeader("Pragma", "public");                    

                        OutputStream output = response.getOutputStream();
                        byte[] bytes = new byte[1024];
                        int read = 0;
                        while ((read = input.read(bytes, 0, 1024)) != -1) {
                            output.write(bytes, 0, read);
                        }
                        output.flush();
                        output.close();                
                    } else {
                        out.println("Not implemented yet");
                    }
                    input.close();
                } else 
                {
                    out.println("file not found!");
                    return;
                }
            } catch (SQLException ex) {Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);} 
        %>
    </body>
</html>
