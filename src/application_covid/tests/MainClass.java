/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.tests;

import application_covid.entities.Personne;
import application_covid.services.PersonneCRUD;
import application_covid.utils.MyConnection;

/**
 *
 * @author House
 */
public class MainClass {
    
    public static void main(String[] args) {
       // MyConnection mc = MyConnection.getInstance();
       // MyConnection mc2 = MyConnection.getInstance();
       // System.out.println(mc.hashCode()+ " -- "+mc2.hashCode());
        PersonneCRUD pc = new PersonneCRUD();
       //pc.ajouterPersonne();
       //Personne p = new Personne(55, "Ben Salem", "Nader");
       //pc.ajouterPersonne2(p);
       //pc.supprimerPersonne(2);
       Personne p1 = new Personne(14,"Messi", "Lionel");
       pc.ajouterPersonne2(p1);
        System.out.println(pc.displayAll());
// pc.updatePersonne(p1, 1);
    }
}
