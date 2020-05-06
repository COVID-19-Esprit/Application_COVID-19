/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.entities;

/**
 *
 * @author Rihab
 */
public class Information {
    
    private int id;
    private String titre;
    private String content;

    public Information() {
    }

    public Information(int id, String titre, String content) {
        this.id = id;
        this.titre = titre;
        this.content = content;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Information{" + "id=" + id + ", titre=" + titre + ", content=" + content + '}';
    }
    
    
    
}
