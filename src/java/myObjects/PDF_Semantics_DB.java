package myObjects;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDF_Semantics_DB 
{
    public Connection Connection()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection(myObjects.Settings.DB_LINK);
            
            return myConnection;
        } catch (ClassNotFoundException | SQLException ex) {Logger.getLogger(PDF_Semantics_DB.class.getName()).log(Level.SEVERE, null, ex);}
        return null;
    }
}
