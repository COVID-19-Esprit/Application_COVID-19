/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.Main;

import Inscription.InterfaceAdmin;
import Malade.Utilisateur_Malade;
import Myconnection.myconnection;

/**
 *
 * @author Achref
 */
public class Application_COVID19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
           myconnection mc = new myconnection();
           InterfaceAdmin ia = new InterfaceAdmin();
           
         Utilisateur_Malade um = new Utilisateur_Malade(1,"ee22e","yy22yyy",100,"u22uuuu",23601135,"oo22oo","1211");
       // ia.ajouterMalade(um);
         ia.update(um,1);
     //   ia.supprimer(113);
    }
    
}
