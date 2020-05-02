/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inscription;

import Malade.Utilisateur_Malade;
import Myconnection.myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Achref
 */
public class InterfaceAdmin {
    Connection con;
 {  con = new  myconnection().getCnx();}   
     
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

      public void update (Utilisateur_Malade p , int id)
    {
         String req3="UPDATE malade SET  nomMalade=? , prenomMalade=?  , ageMalade=? , adresseMalade=? , telephoneMalade=?, mailMalade=? ,code=? WHERE id=?";
        try {
            PreparedStatement p3 = con.prepareStatement(req3);
             p3.setInt(8, id);
             p3.setString(1,p.getNomMalade());
             p3.setString(2,p.getPrenomMalade());
             p3.setInt(3,p.getAgeMalade());
               p3.setString(4,p.getAdresseMalade());
                            p3.setInt(5,p.getTelephoneMalade());
                                         p3.setString(6,p.getMailMalade());
                                                      p3.setString(7,p.getCode());




             p3.executeUpdate();
             System.out.println("Personne Modifié");
                    } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    
    }
      
         public void supprimer (int id )
    {
        String req2="DELETE FROM malade WHERE id=?";
        PreparedStatement p2;
        try {
            p2 = con.prepareStatement(req2);
                    p2.setInt(1, id);
                 p2.executeUpdate();
                 System.out.println("Personnes supprimé!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }
     
} 