/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.tests;

import application_covid.entities.Information;
import application_covid.services.InformationCRUD;
import application_covid.utils.MyConnection;

/**
 *
 * @author House
 */
public class MainClass {
    
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
        InformationCRUD ic = new InformationCRUD();
        Information i = new Information(5, "titre1", "bababaabb");
        //ic.ajouterInformation(i);
        System.out.println(ic.displayAll());
        Information i2 = new Information(8, "titre8", "bksddksidjib");
        //ic.updateInformation(i2, 1);
        ic.supprimerInformation(1);
    }
}
