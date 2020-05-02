/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

/**
 *
 * @author Achref
 */
public class Admin {
    private String id;
    
    private String motdepasse;
    
    public Admin (){}
    public Admin(String id, String motdepasse)
    {this.id=id;
    this.motdepasse=motdepasse;}

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getMotdepasse() {
        return motdepasse;
    }
    
    
    
    
}
