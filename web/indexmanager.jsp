<%-- 
    Document   : indexmanager
    Created on : Dec 2, 2015, 10:31:06 PM
    Author     : Roman Toda <roman.toda@gmail.com>
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="myObjects.PDF_Semantics_DB"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="UploadFile" enctype="multipart/form-data">
            <tbody>
                <td>Choose File : </td>
                <td><input type="file" name="file_uploaded" /></td>
                <td><input type="submit" value="Upload" name="upload" /></td>
            </tbody>             
        </form>

<br><br>       

<table border="1" width="25%" cellpadding="5">
    <thead> 
    <th colspan="3">Uploaded Files</th>        
    </thead>
    
    <tbody>
        <tr>
            <td><center><b>Id</b></center><td><center><b>FileName</b></center></td><td><center><b>??</b></center></td>
        </tr>

        <%
            try {
                PDF_Semantics_DB my_db = new PDF_Semantics_DB();
                Connection myconnection = my_db.Connection();

                String sqlString = "SELECT * FROM pdf_files where (pageid=-1)";
                Statement myStatement = myconnection.createStatement();
                ResultSet rs = myStatement.executeQuery(sqlString);

                if (!rs.isBeforeFirst()) {
        %>
        <tr>
            <td colspan="3"><center><%out.print("No Files!"); %></center></td>
        </tr>
        <%
            }

            while (rs.next()) {
        %>
            <tr>
                <td><center><%out.print(rs.getString("id")); %></center></td>
                <td><center><%out.print(rs.getString("fileName")); %></center></td>
                <td><center><a href="ViewPDF.jsp?id=<%out.print(rs.getString("id"));%>">View</a></center></td>
            </tr>
        <%
            }
        %>

    </tbody> 
</table>
<%
        rs.close();
        myStatement.close();
        myconnection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

%>
</body>

</html>
