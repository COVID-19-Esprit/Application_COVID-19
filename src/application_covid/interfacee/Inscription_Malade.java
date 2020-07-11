/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

import application_covid.entities.Utilisateur_Malade;
import application_covid.utils.MyConnection;
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
    {  con = MyConnection.getInstance().getCnx();
    }
     
     public void ajouterMalade(Utilisateur_Malade m)
    {
        try {
                   String req2="INSERT INTO malade(nomMalade,prenomMalade,ageMalade,adresseMalade,telephoneMalade,mailMalade,code) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(req2);
           // pst.setInt(1,m.getId());
           pst.setString(1,m.getNomMalade());
            pst.setString(2,m.getPrenomMalade());
           pst.setString(3,m.getAgeMalade());
              pst.setString(4,m.getAdresseMalade());
             pst.setString(5, m.getTelephoneMalade());
              pst.setString(6,m.getMailMalade());
              pst.setString(7,m.getCode());

            pst.executeUpdate();
            System.out.println("Malade Ajouter ! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }

    }
}
