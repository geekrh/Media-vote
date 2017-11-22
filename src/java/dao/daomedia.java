/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dao.beans.media ;
import dao.beans.categorie ;
import java.util.* ; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitaire.SingletonConnection;
/**
 *
 * @author Mohammed Mehdi Sarray#
 */
public class daomedia implements interface_dao_media {
    private categorie c = new categorie (000) ;
    private media m= new media(1,"pp","sur ecoute","image/batman.jpg",c ,3 ) ;
    
    
    
    public  List<Map<String, String>> affichermedia () 
    {
        
        List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
         
        
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select * from media order by nbr_vote desc ");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            m.setId_media(rs.getInt("id_media"));
            m.setLibelle(rs.getString("libelle"));
            m.setDescription(rs.getString("description"));
            m.setUrl_media(rs.getString("url_media"));
            c.setId_categorie(rs.getInt("id_cat"));
            m.setNbvote(rs.getInt("nbr_vote"));
           
             
            String id = Integer.toString(m.getId_media())   ;
            
            news.put("id", id);
            news.put("url",m.getUrl_media()) ;
            news.put("titre",m.getLibelle());
            news.put("description", m.getDescription()) ;
            news.put("nbv",String.valueOf(m.getNbvote())) ;
            
             maListe.add(news);
            
             }
           
            ps.close();
       
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }
      return maListe ;
    }
    
    public void ajoutmedia(String lib,String desc , String url) {
        
          
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("insert into media(libelle,description,url_media,id_cat,nbr_vote) values (?,?,?,?,?) ");
 
            ps.setString(1,lib);
            ps.setString(2, desc);
            ps.setString(3, url);
            ps.setInt(4, 111);
            ps.setInt(5, 000);
            
            ps.executeUpdate();
           
            ps.close();
       
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      public  Map<String, String> afficherMediaRecent (String lib) 
    {
        
       Map<String, String> news = new HashMap<String, String>(); ;
         
        
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select * from media where libelle = ? ");
            ps.setString(1, lib);
            ResultSet rs=ps.executeQuery();
            
             while (rs.next()) {
          //  Map<String, String> newss = new HashMap<String, String>();     
            m.setId_media(rs.getInt("id_media"));
            m.setLibelle(rs.getString("libelle"));
            m.setDescription(rs.getString("description"));
            m.setUrl_media(rs.getString("url_media"));
            c.setId_categorie(rs.getInt("id_cat"));
            m.setNbvote(rs.getInt("nbr_vote"));
            
            news.put("url",m.getUrl_media()) ;
            news.put("titre",m.getLibelle());
            news.put("description", m.getDescription()) ;
            news.put("nbv",String.valueOf(m.getNbvote())) ;
            
            
            
             }
           
            ps.close();
       
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }
      return news ;
    }
    
         
    public  List<Map<String, String>> afficherFilm () 
    {
        
        List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
         
        
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select * from media where id_cat = 1 ");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            m.setId_media(rs.getInt("id_media"));
            m.setLibelle(rs.getString("libelle"));
            m.setDescription(rs.getString("description"));
            m.setUrl_media(rs.getString("url_media"));
            c.setId_categorie(rs.getInt("id_cat"));
            m.setNbvote(rs.getInt("nbr_vote"));
            
            news.put("url",m.getUrl_media()) ;
            news.put("titre",m.getLibelle());
            news.put("description", m.getDescription()) ;
            news.put("nbv",String.valueOf(m.getNbvote())) ;
            
             maListe.add(news);
            
             }
           
            ps.close();
       
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }
      return maListe ;
    }
  public  List<Map<String, String>> afficherJeux () 
    {
        
        List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
         
        
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select * from media where id_cat = 2 ");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            m.setId_media(rs.getInt("id_media"));
            m.setLibelle(rs.getString("libelle"));
            m.setDescription(rs.getString("description"));
            m.setUrl_media(rs.getString("url_media"));
            c.setId_categorie(rs.getInt("id_cat"));
            m.setNbvote(rs.getInt("nbr_vote"));
            
            news.put("url",m.getUrl_media()) ;
            news.put("titre",m.getLibelle());
            news.put("description", m.getDescription()) ;
            news.put("nbv",String.valueOf(m.getNbvote())) ;
            
             maListe.add(news);
            
             }
           
            ps.close();
       
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }
      return maListe ;
    }
   public  List<Map<String, String>> afficherLivre () 
    {
        
        List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
         
        
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select * from media where id_cat = 3 ");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            m.setId_media(rs.getInt("id_media"));
            m.setLibelle(rs.getString("libelle"));
            m.setDescription(rs.getString("description"));
            m.setUrl_media(rs.getString("url_media"));
            c.setId_categorie(rs.getInt("id_cat"));
            m.setNbvote(rs.getInt("nbr_vote"));
            
            news.put("url",m.getUrl_media()) ;
            news.put("titre",m.getLibelle());
            news.put("description", m.getDescription()) ;
            news.put("nbv",String.valueOf(m.getNbvote())) ;
            
             maListe.add(news);
            
             }
           
            ps.close();
       
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }
      return maListe ;
    }
   public  List<Map<String, String>> afficherSerie () 
    {
        
        List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
         
        
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select * from media where id_cat = 4 ");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            m.setId_media(rs.getInt("id_media"));
            m.setLibelle(rs.getString("libelle"));
            m.setDescription(rs.getString("description"));
            m.setUrl_media(rs.getString("url_media"));
            c.setId_categorie(rs.getInt("id_cat"));
            m.setNbvote(rs.getInt("nbr_vote"));
            
            news.put("url",m.getUrl_media()) ;
            news.put("titre",m.getLibelle());
            news.put("description", m.getDescription()) ;
            news.put("nbv",String.valueOf(m.getNbvote())) ;
            
             maListe.add(news);
            
             }
           
            ps.close();
       
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }
      return maListe ;
    }
   
   
   public void vote(int numvote)
   {
       try {
        Connection con=SingletonConnection.getCon();
        PreparedStatement ps=con.prepareStatement("update media set nbr_vote = nbr_vote+1 where id_media = ?");
            ps.setInt(1, numvote);
            ps.executeUpdate();
            ps.close();
            
       
   }catch (SQLException ex) {
             Logger.getLogger(daomedia.class.getName()).log(Level.SEVERE, null, ex);
        }
}

}