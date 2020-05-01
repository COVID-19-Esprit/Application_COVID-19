/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inscription;


import Myconnection.myconnection;
import Volontaire.Utilisateur_Volontaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Inscription_Volontaire {
    Connection con;
     public Inscription_Volontaire ()
    {  con = new  myconnection().getCnx();
    }
     
      public void ajouteruv (Utilisateur_Volontaire v)
    {
        try {
                   String req2="INSERT INTO volentaire(id,nomVolontaire,prenomVolontaire,adresseVolontaire,telephoneVolontaire,mail,code,association) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(req2);
           pst.setInt(1,v.getId());
            pst.setString(2, v.getNomVolontaire());
           pst.setString(3, v.getPrenomVolontaire());
              pst.setString(4, v.getAdresseVolontaire());
            pst.setInt(5, v.getTelephoneVolontaire());
            pst.setString(6, v.getMail());
             pst.setString(7, v.getCode());
            pst.setString(8, v.getAssociation());

            pst.executeUpdate();
            System.out.println("Association Ajouter ! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }

    }
    
}
