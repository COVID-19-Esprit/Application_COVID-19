/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.services;

/**
 *
 * @author Flexos
 */
import application_covid.entities.SuiviMalade;
import application_covid.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Flexos
 */
public class SuiviMaladeCRUD {
            Connection cnx;
            
    public SuiviMaladeCRUD(){
        cnx =  MyConnection.getInstance().getCnx();
    
    }    
    
    public void suiviMalade(){
                try {
                    String requete = "INSERT INTO suivi_malade(etat,temp,toux,respiration,douleur,symptomes,perte_de_odorat,perte_de_apetit,diarrhee,maux_de_tete,code)"
                            + "VALUES ('OK','39','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','6969') ";
                    Statement st = cnx.createStatement();
                    st.executeUpdate(requete);
                    System.out.println("your informations has been registered!");
                } catch (SQLException ex) {
                    System.err.println ("Insert error!");
                    System.out.println(ex.getMessage());
                }
    }
    
    public void suiviMalade2 (SuiviMalade sma){
                try {
                    String requete2 = "INSERT INTO suivi_malade(etat,temp,toux,respiration,douleur,symptomes,perte_de_odorat,perte_de_apetit,diarrhee,maux_de_tete,code) "
                            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = cnx.prepareStatement(requete2);
                    pst.setString(1, sma.getEtat());
                    pst.setInt (2, sma.getTemp());
                    pst.setString(3, sma.getToux());
                    pst.setString(4, sma.getRespiration());
                    pst.setString(5, sma.getDouleur());
                    pst.setString(6, sma.getSymptomes());
                    pst.setString(7, sma.getPerteOdorat());
                    pst.setString(8, sma.getPerteApetit());
                    pst.setString(9, sma.getDiarrhee());
                    pst.setString(10, sma.getMauxTete());
                    pst.setString(11, sma.getCode());
                    pst.executeUpdate();
                    System.out.println("Informations saved!");
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
        
    
    }
}
