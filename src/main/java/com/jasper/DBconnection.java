package com.jasper;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    
     public Connection getconnection()
    {
        try
        {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/visitor","root","root");
                    return con;
        }
        
        catch(Exception e)
        {
        System.out.println(e);
        return null;
        }
    }
}
