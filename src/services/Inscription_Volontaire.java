/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import utils.myconnection;
import entities.Utilisateur_Volontaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Inscription_Volontaire {
    Connection con;
     public Inscription_Volontaire ()
    {  con = new  myconnection().conDB();
    }
     
      public void ajouteruv (Utilisateur_Volontaire v)
    {
        try {
                String req2="INSERT INTO volentaire(nomVolontaire,prenomVolontaire,adresseVolontaire,telephoneVolontaire,mail,code,association) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(req2);
         //  pst.setInt(1,v.getId());
            pst.setString(1, v.getNomVolontaire());
           pst.setString(2, v.getPrenomVolontaire());
              pst.setString(3, v.getAdresseVolontaire());
            pst.setString(4, v.getTelephoneVolontaire());
            pst.setString(5, v.getMail());
             pst.setString(6, v.getCode());
            pst.setString(7, v.getAssociation());

            pst.executeUpdate();
            System.out.println("Association Ajouter ! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }

    }
    
}
