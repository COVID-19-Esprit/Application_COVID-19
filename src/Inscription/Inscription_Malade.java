/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inscription;

import Malade.Utilisateur_Malade;
import Myconnection.myconnection;
import Volontaire.Utilisateur_Volontaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Achref
 */
public class Inscription_Malade {
    Connection con;
     public Inscription_Malade ()
    {  con = new  myconnection().getCnx();
    }
     
     public void ajouterMalade (Utilisateur_Malade m)
    {
        try {
                   String req2="INSERT INTO malade(id,nomMalade,prenomMalade,ageMalade,adresseMalade,telephoneMalade,mailMalade,code) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(req2);
            pst.setInt(1,m.getId());
           pst.setString(2,m.getNomMalade());
            pst.setString(3,m.getPrenomMalade());
           pst.setInt(4,m.getAgeMalade());
              pst.setString(5,m.getAdresseMalade());
             pst.setInt(6, m.getTelephoneMalade());
              pst.setString(7,m.getMailMalade());
                           pst.setString(8,m.getCode());

            pst.executeUpdate();
            System.out.println("Malade Ajouter ! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }

    }
}
