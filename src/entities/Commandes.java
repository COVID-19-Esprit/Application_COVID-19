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
public class Commandes {
    private int code ;
    private String commande;
    private String quantité;
    private String description;
    private String status;
    
    public Commandes ()
    {}
    
    public Commandes (int code , String commande,String quantité ,String description, String status)
    {this.code=code;
    this.commande=commande;
    this.quantité=quantité;
    this.description=description;
    this.status=status;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCommande(String commande) {
        this.commande = commande;
    }

    public String getCommande() {
        return commande;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public void setQuantité(String  quantité) {
        this.quantité = quantité;
    }

    public String getQuantité() {
        return quantité;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
    
    
}
