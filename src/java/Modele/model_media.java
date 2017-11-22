/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import dao.beans.media;
import java.util.List;
import java.util.Map;
import dao.interface_dao_media;
/**
 *
 * @author Mohammed Mehdi Sarray#
 */
public class model_media {
    private media media;
    private interface_dao_media inter;
    
    public  List<Map<String, String>> afficherme () {
    
       return inter.affichermedia() ;
    
    }
    
    
    
    
}
