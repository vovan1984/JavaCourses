package com.luv2code.servletdemo;

import java.sql.*;

public class DriverDB
{
    private final static String URL = "jdbc:mysql://localhost:3306/sakila"; 
    private final static String USER = "student";
    private final static String PASSWORD = "student";
    
    private Connection myCon;
    
    public DriverDB()
    {
        myCon = null;
        
        // 1.Get connection to the database
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myCon = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    
    public ResultSet executeQuery(String query) throws SQLException
    {  
        ResultSet myRs = null;
        
        // 2. Create a statement
        Statement myStmnt = myCon.createStatement();
            
        // 3. Execute SQL query
        myRs = myStmnt.executeQuery(query);
        
        return myRs;

    }

    
    public int executeUpdate(String updateQuery) throws SQLException
    {  
         
        // 2. Create a statement
        Statement myStmnt = myCon.createStatement();
            
        // 3. Execute SQL query
        return myStmnt.executeUpdate(updateQuery);
    }
}
