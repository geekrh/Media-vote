/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.beans.categorie;
import dao.beans.media;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitaire.SingletonConnection;
    
/**
 *
 * @author Ahmed
 */
public class daocategorie implements interface_dao_categorie{
    daomedia m=new daomedia();
    @Override
    public void ajoutcategorie(categorie c) {
   
    }

    @Override
    public void supprimermedia(int i) {
     try {
        Connection con=SingletonConnection.getCon();
        PreparedStatement ps=con.prepareStatement("delete from media where id_media = ?");
            ps.setInt(1, i);
            ps.executeUpdate();
            ps.close();
            
       
   }catch (SQLException ex) {
             Logger.getLogger(daomedia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  

    @Override
    public void mise_a_jour() {
     List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
              maListe = (ArrayList<Map<String, String>>) this.ListerCategorie(); 
                  // if (maListe != null) {
                       for (Map<String, String> entry : maListe) {
                             try{  
                            int a=m.SUMMEDIAINCATEGORIE(Integer.parseInt(entry.get("id")));
                            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("update categorie set nbr_media = ? where id_categorie = ?");
            ps.setInt(1, a);
            ps.setInt(2, Integer.parseInt(entry.get("id")));
            ps.executeUpdate();
                       
   }catch (SQLException ex) {
             Logger.getLogger(daomedia.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
    }
                       
    

    @Override
    public  List<Map<String, String>> ListerCategorie() {
    List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
         categorie c=new categorie();
        
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select * from categorie");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            c.setId_categorie(rs.getInt("id_categorie"));
            c.setLibelle(rs.getString("libelle"));
            c.setNbr_media(rs.getInt("nbr_media"));
            String id = Integer.toString(c.getId_categorie())   ;
            
            news.put("id_categorie", id);
            news.put("libelle",c.getLibelle()) ;
            news.put("nbr_media",String.valueOf(c.getNbr_media()));
            maListe.add(news);
            
             }
           
            ps.close();
       
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }
      return maListe ;
    }

    @Override
    public void supprimercategorie(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
