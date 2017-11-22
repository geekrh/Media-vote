/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.beans;

import java.util.ArrayList;

/**
 *
 * @author Mohammmed Mehdi Sarray#
 */
public class media {
    private int id_media;
    private String libelle; 
    private String description ; 
    private String url_media ;
    private categorie categorie;
    private ArrayList<vote> vote; 
    private int nbvote ;
    public media(int id_media, String libelle, String description, String url_media, categorie categorie, ArrayList<vote> vote) {
        this.id_media = id_media;
        this.libelle = libelle;
        this.description = description;
        this.url_media = url_media;
        this.categorie = categorie;
        this.vote = vote;
    }

    public media(int id_media, String libelle, String description, String url_media, categorie categorie , int v ) {
        this.id_media = id_media;
        this.libelle = libelle;
        this.description = description;
        this.url_media = url_media;
        this.categorie = categorie;
        this.nbvote = v;
    }

    public int getNbvote() {
        return nbvote;
    }

    public void setNbvote(int nbvote) {
        this.nbvote = nbvote;
    }
    

    public media() {
    }
    

    public int getId_media() {
        return id_media;
    }

    public void setId_media(int id_media) {
        this.id_media = id_media;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_media() {
        return url_media;
    }

    public void setUrl_media(String url_media) {
        this.url_media = url_media;
    }

    public categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(categorie categorie) {
        this.categorie = categorie;
    }

    public ArrayList<vote> getVote() {
        return vote;
    }

    public void setVote(ArrayList<vote> vote) {
        this.vote = vote;
    }
       
    
}
