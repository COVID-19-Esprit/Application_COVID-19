/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.services;

import application_covid.entities.Membre;
import application_covid.entities.Personne;
import application_covid.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MembreCRUD {
    Connection cnx;

    public MembreCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }
     
    public void ajoutMembre(){
        try {
            String requete = "INSERT INTO membre VALUES (09717614 ,'NEFZAOUI','Achref' ,'WAREDNAAM NAFTA', 23 , 'test' , 54825709 ) ";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("membre ajoutee");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
    }
       public void ajouterMembre2(Membre m) {
        try {
            String requete2 = "INSERT INTO membre (cin,nomMembre, prenomMembre, adresseMembre , ageMembre , passwordMembre , telephoneMembre)"
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete2);
            pst.setInt(1,m.getId());
            pst.setString(2, m.getNomMembre());
            pst.setString(3, m.getPrenomMembre());
            pst.setString(4, m.getAdresseMembre());
            pst.setInt(5, m.getAge());
            pst.setString(6, m.getPasswordMembre());
            pst.setInt(7, m.getTelephoneMembre());
            pst.executeUpdate();
            System.out.println("Membre Added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
       
        public void supprimerMembre(int cin) {
        try {
            String requete = "DELETE FROM membre WHERE cin=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, cin);
            pst.executeUpdate();
            System.out.println("Member deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
         public void updateMembre(Membre m, int cin) {
         try {
            String requete = "UPDATE membre SET cin=?,nomMembre=?,prenomMembre=?,adresseMembre=?,ageMembre=?,passwordMembre=?,telephoneMembre=? WHERE cin=?"; 
                     
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(8, cin);
            pst.setInt(1, m.getId());
            pst.setString(2, m.getNomMembre());
            pst.setString(3, m.getPrenomMembre());
            pst.setString(4, m.getAdresseMembre());
            pst.setInt(5, m.getAge());
            pst.setString(6, m.getPasswordMembre());
            pst.setInt(7, m.getTelephoneMembre());
            pst.executeUpdate();
            System.out.println("Modified member");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
           public List<Membre> displayAll(){
       List<Membre> listeMembres = new ArrayList<>();
        try {
            String requete = "SELECT * FROM Membre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Membre m = new Membre();
                m.setId(rs.getInt(1));
                m.setNomMembre(rs.getString("nomMembre"));
                m.setPrenomMembre(rs.getString("prenomMembre"));
                listeMembres.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listeMembres;
   } 
}
