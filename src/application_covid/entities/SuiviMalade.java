/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.entities;

/**
 *
 * @author Flexos
 */
public class SuiviMalade {
    
   private String Etat;
   private int temp;
   private String toux;
   private String respiration;
   private String douleur;
   private String symptomes;
   private String PerteOdorat;
   private String PerteApetit;
   private String diarrhee;
   private String MauxTete;
   private String code;   

    public SuiviMalade() {
    }

    public SuiviMalade(String Etat, int temp, String toux, String respiration, String douleur, String symptomes, String PerteOdorat, String PerteApetit, String diarrhee, String MauxTete, String code) {
        this.Etat = Etat;
        this.temp = temp;
        this.toux = toux;
        this.respiration = respiration;
        this.douleur = douleur;
        this.symptomes = symptomes;
        this.PerteOdorat = PerteOdorat;
        this.PerteApetit = PerteApetit;
        this.diarrhee = diarrhee;
        this.MauxTete = MauxTete;
        this.code = code;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getToux() {
        return toux;
    }

    public void setToux(String toux) {
        this.toux = toux;
    }

    @Override
    public String toString() {
        return "SuiviMalade{" + "Etat=" + Etat + ", temp=" + temp + ", toux=" + toux + ", respiration=" + respiration + ", douleur=" + douleur + ", symptomes=" + symptomes + ", PerteOdorat=" + PerteOdorat + ", PerteApetit=" + PerteApetit + ", diarrhee=" + diarrhee + ", MauxTete=" + MauxTete + ", code=" + code + '}';
    }

    public String getRespiration() {
        return respiration;
    }

    public void setRespiration(String respiration) {
        this.respiration = respiration;
    }

    public String getDouleur() {
        return douleur;
    }

    public void setDouleur(String douleur) {
        this.douleur = douleur;
    }

    public String getSymptomes() {
        return symptomes;
    }

    public void setSymptomes(String symptomes) {
        this.symptomes = symptomes;
    }

    public String getPerteOdorat() {
        return PerteOdorat;
    }

    public void setPerteOdorat(String PerteOdorat) {
        this.PerteOdorat = PerteOdorat;
    }

    public String getPerteApetit() {
        return PerteApetit;
    }

    public void setPerteApetit(String PerteApetit) {
        this.PerteApetit = PerteApetit;
    }

    public String getDiarrhee() {
        return diarrhee;
    }

    public void setDiarrhee(String diarrhee) {
        this.diarrhee = diarrhee;
    }

    public String getMauxTete() {
        return MauxTete;
    }

    public void setMauxTete(String MauxTete) {
        this.MauxTete = MauxTete;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
   

    
    public void suiviMalade2(SuiviMalade sma) {
        
    }
   
   
}
