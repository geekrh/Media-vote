/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Mohammed Mehdi Sarray#
 */
public class categorie implements Serializable{
    private int id_categorie; 
    private String libelle ; 
    private ArrayList<media> liste_media;
    private int nbr_media; 

    public categorie(int id_categorie, String libelle, ArrayList<media> liste_media, int nbr_media) {
        this.id_categorie = id_categorie;
        this.libelle = libelle;
        this.liste_media = liste_media;
        this.nbr_media = nbr_media;
    }
    
    public categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public categorie() {
    }
    

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<media> getListe_media() {
        return liste_media;
    }

    public void setListe_media(ArrayList<media> liste_media) {
        this.liste_media = liste_media;
    }

    public int getNbr_media() {
        return nbr_media;
    }

    public void setNbr_media(int nbr_media) {
        this.nbr_media = nbr_media;
    }
    
    
    
    
}
