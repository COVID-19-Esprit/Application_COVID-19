/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Utilisateur_Volontaire;
import java.sql.Connection;

import java.sql.SQLException;
import utils.myconnection;
import utils.myconnection;
import entities.Utilisateur_Volontaire;
import entities.admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Achref
 */
public class Inscription_admin {
    Connection con;
     public Inscription_admin ()
    {  con = new  myconnection().conDB();
    }


     
      public void ajouteradmin (admin v)
    {
        try {
      String req2="INSERT admin(login,password) VALUES (?,?)";

            PreparedStatement pst = con.prepareStatement(req2);
         
            pst.setString(1,v.getLogin());
           pst.setString(2,v.getPassword());
             
            pst.executeUpdate();
            System.out.println("Admin Ajouter ! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }

    }
    
}
