package application_covid.entities;

public class Utilisateur_Malade {
    private int id;
    private String nomMalade;
    private String prenomMalade;
    private String ageMalade;
    private String adresseMalade;
    private String telephoneMalade;
    private String mailMalade;
    private String code;

    
    public Utilisateur_Malade(){};
    public Utilisateur_Malade(int id ,String nomMalade , String prenomMalade , String ageMalade , String adresseMalade , String telephoneMalade , String mailMalade , String code )
    {   this.id=id;
        this.nomMalade=nomMalade;
        this.prenomMalade=prenomMalade;
        this.ageMalade=ageMalade;
        this.adresseMalade=adresseMalade;
        this.telephoneMalade=telephoneMalade;
        this.mailMalade=mailMalade;
        this.code=code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomMalade(String nomMalade) {
        this.nomMalade = nomMalade;
    }

    public String getNomMalade() {
        return nomMalade;
    }

    public void setPrenomMalade(String prenomMalade) {
        this.prenomMalade = prenomMalade;
    }

    public String getPrenomMalade() {
        return prenomMalade;
    }

    public void setAgeMalade(String ageMalade) {
        this.ageMalade = ageMalade;
    }

    public String getAgeMalade() {
        return ageMalade;
    }

    public void setAdresseMalade(String adresseMalade) {
        this.adresseMalade = adresseMalade;
    }

    public String getAdresseMalade() {
        return adresseMalade;
    }

    public void setTelephoneMalade(String telephoneMalade) {
        this.telephoneMalade = telephoneMalade;
    }

    public String getTelephoneMalade() {
        return telephoneMalade;
    }

    public void setMailMalade(String mailMalade) {
        this.mailMalade = mailMalade;
    }

    public String getMailMalade() {
        return mailMalade;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getEditor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
   
    
    
    
          
    
}