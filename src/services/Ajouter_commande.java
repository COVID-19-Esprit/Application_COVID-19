/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Commandes;
import entities.Utilisateur_Malade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.myconnection;

/**
 *
 * @author Achref
 */
public class Ajouter_commande {
     Connection con;
    
     public Ajouter_commande ()
    {  con = myconnection.conDB();
    } 
     
       public void ajoutercommande(Commandes m)
    {
        try {
                   String req2="INSERT INTO commande(code,commande,quantité,description) VALUES (?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(req2);
            pst.setInt(1,m.getCode());
           pst.setString(2,m.getCommande());
          //  pst.setFloat(3,m.getPrix());
           pst.setString(3,m.getQuantité());
              pst.setString(4,m.getDescription());
          // pst.setString(6,m.getDescription());

           

            pst.executeUpdate();
            System.out.println("Commande Ajouter ! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
