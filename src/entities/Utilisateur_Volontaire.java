/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Achref
 */
public class Utilisateur_Volontaire {
     private int id;
    private String nomVolontaire;
    private String prenomVolontaire;
    private String adresseVolontaire;
    private String telephoneVolontaire;
        private String mail;
           private String code;
        private String association;
      
  
    
    public Utilisateur_Volontaire ()
    {}

   
    
    public  Utilisateur_Volontaire (String nomVolontaire , String prenomVolontaire ,String adresseVolontaire, String telephoneVolontaire,  String mail ,String code, String association)
    {  
        this.id=id;
        this.nomVolontaire=nomVolontaire;
        this.prenomVolontaire=prenomVolontaire;
        this.adresseVolontaire=adresseVolontaire;
        this.telephoneVolontaire= telephoneVolontaire;
        this.mail=mail;
        this.code=code;
        this.association=association;
     }

    public Utilisateur_Volontaire(String string, String string0, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNomVolontaire(String nomVolontaire) {
        this.nomVolontaire = nomVolontaire;
    }

    public String getNomVolontaire() {
        return nomVolontaire;
    }

    public void setPrenomVolontaire(String prenomVolontaire) {
        this.prenomVolontaire = prenomVolontaire;
    }

    public String getPrenomVolontaire() {
        return prenomVolontaire;
    }

    public void setAdresseVolontaire(String adresseVolontaire) {
        this.adresseVolontaire = adresseVolontaire;
    }

    public String getAdresseVolontaire() {
        return adresseVolontaire;
    }

    public void setTelephoneVolontaire(String telephoneVolontaire) {
        this.telephoneVolontaire = telephoneVolontaire;
    }

    public String getTelephoneVolontaire() {
        return telephoneVolontaire;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public String getAssociation() {
        return association;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

   
 



   
   
            
    
    
}
