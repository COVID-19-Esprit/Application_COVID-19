/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.services;

import application_covid.utils.MailNotif;
import application_covid.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Flexos
 */
public class AdminNotifications {
    
            Connection cnx;
            
    public AdminNotifications(){
        cnx =  MyConnection.getInConnection().getCnx();
    
    }    
    
    public void AdminNotifications(){
                try {
                    String requete = "SELECT mailMalade FROM malade WHERE mailMalade NOT 0 ";
                    Statement st = cnx.createStatement();
                    st.executeQuery(requete);
                    System.out.println("your informations has been registered!");
                } catch (SQLException ex) {
                    System.err.println ("Select error!");
                    System.out.println(ex.getMessage());
                }
    }
    
    /**
     *
     * @return
     */
    public List<MailNotif> dispayAll(){
        List<MailNotif> ListMail = new ArrayList<>();
        try {
                    String requete = "SELECT mailMalade FROM malade WHERE mailMalade NOT 0 ";
                    Statement st = cnx.createStatement();
                    ResultSet rs = st.executeQuery(requete);
                    System.out.println("your informations has been registered!");
                } catch (SQLException ex) {
                    System.err.println ("Select error!");
                    System.out.println(ex.getMessage());
                }
        return ListMail;
        
    }
    
}

