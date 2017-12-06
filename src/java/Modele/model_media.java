/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import dao.beans.media;
import dao.daomedia;
import java.util.List;
import java.util.Map;
import dao.interface_dao_media;
/**
 *
 * @author Mohammed Mehdi Sarray#
 */
public class model_media {
    private media media;
    private daomedia dao = new daomedia();
    
    public  List<Map<String, String>> affichermedia () {
    
       return dao.affichermedia() ;
    }
    public List<Map<String, String>> affiche_media_par_categorie(int id_categorie)
     {
         return this.dao.affichermediaParCategorie(id_categorie);
     }
    public  void ajouter_media (media m)
    {
    this.dao.ajoutmedia(m);
    }
    public void Supprimer_media(int id_media)
    {
    this.dao.Supprimer_Media(id_media);
    }
    
    
    
    
}
