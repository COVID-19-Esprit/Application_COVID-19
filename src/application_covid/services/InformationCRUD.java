/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.services;

import application_covid.entities.Information;
import application_covid.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rihab
 */
public class InformationCRUD {
    Connection cnx;

    public InformationCRUD() {
         cnx = MyConnection.getInstance().getCnx();
    }
    public void ajouterInformation( Information i) {
        try {
            String requete2 = "INSERT INTO information (titre, content)"
                    + "VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete2);
            pst.setString(1, i.getTitre());
            pst.setString(2, i.getContent());
            pst.executeUpdate();
            System.out.println("Information added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void supprimerInformation(int id) {
        try {
            String requete = "DELETE FROM information WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Information supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateInformation(Information p, int id) {
        try {
            String requete = "UPDATE information SET titre=?,content=? "
                    + "WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(3, id);
            pst.setString(1, p.getTitre());
            pst.setString(2, p.getContent());
            pst.executeUpdate();
            System.out.println("Information modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   public List<Information> displayAll(){
       List<Information> listeInformation = new ArrayList<>();
        try {
            String requete = "SELECT * FROM information";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Information i = new Information();
                i.setId(rs.getInt(1));
                i.setTitre(rs.getString("titre"));
                i.setContent(rs.getString("content"));
                listeInformation.add(i);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listeInformation;
   }     
    
    
}
