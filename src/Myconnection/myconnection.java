/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Achref
 */
public class myconnection {
    public String url="jdbc:mysql://localhost:3306/covid_database";
    public String login="root";
    public String pwd="";
    Connection con ;
    public myconnection()
    {   
        try {
        con =DriverManager.getConnection(url, login, pwd);
            System.out.println("Connection établie !");
        } 
    
    catch (SQLException ex) {
        System.err.println(ex.getMessage());  
    }
    }
    
    public Connection getCnx()
    {return con ;}
    
    }

