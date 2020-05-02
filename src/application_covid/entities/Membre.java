package application_covid.entities;

/**
 *
 * @author A
 */
public class Membre {
    private int id ;
    private String nomMembre ;
    private String prenomMembre ;
    private String adresseMembre ;
    private int age ; 
    private String passwordMembre ;
    private int telephoneMembre ;

    public Membre() {
    }

    public Membre(int id, String nomMembre, String prenomMembre, String adresseMembre,int age ,String passwordMembre, int telephoneMembre) {
        this.id = id;
        this.nomMembre = nomMembre;
        this.prenomMembre = prenomMembre;
        this.adresseMembre = adresseMembre;
        this.age = age;
        this.passwordMembre = passwordMembre;
        this.telephoneMembre = telephoneMembre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public String getAdresseMembre() {
        return adresseMembre;
    }

    public void setAdresseMembre(String adresseMembre) {
        this.adresseMembre = adresseMembre;
    }

    public String getPasswordMembre() {
        return passwordMembre;
    }

    public void setPasswordMembre(String passwordMembre) {
        this.passwordMembre = passwordMembre;
    }

    public int getTelephoneMembre() {
        return telephoneMembre;
    }

    public void setTelephoneMembre(int telephoneMembre) {
        this.telephoneMembre = telephoneMembre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

    @Override
    public String toString() {
        return "Membre{" + "id=" + id + ", nomMembre=" + nomMembre + ", prenomMembre=" + prenomMembre + ", adresseMembre=" + adresseMembre + ", age=" +age + ", passwordMembre=" + passwordMembre + ", telephoneMembre=" + telephoneMembre + '}';
    }
    
    
}
