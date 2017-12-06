/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dao.beans.media ;
import dao.beans.categorie ;
import static java.lang.System.out;
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
        dao.beans.media med=new dao.beans.media();
        dao.beans.categorie cat=new dao.beans.categorie();
        
        
      public void Supprimer_Media(int num_media)
   {
       try {
        Connection con=SingletonConnection.getCon();
        PreparedStatement ps=con.prepareStatement("delete from media id_media=?");
            ps.setInt(1, num_media);
            ps.executeUpdate();
            ps.close();
            
       
   }catch (SQLException ex) {
             Logger.getLogger(daomedia.class.getName()).log(Level.SEVERE, null, ex);
        }
}   
        
    public  List<Map<String, String>> affichermediaParCategorie (int id_categorie) 
    { List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
         
        
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select * from media where id_cat = '"+id_categorie+"' order by nbr_vote desc");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            med.setId_media(rs.getInt("id_media"));
            med.setLibelle(rs.getString("libelle"));
            med.setDescription(rs.getString("description"));
            med.setUrl_media(rs.getString("url_media"));
            cat.setId_categorie(rs.getInt("id_cat"));
            med.setNbvote(rs.getInt("nbr_vote"));
            String id = Integer.toString(med.getId_media())   ;
            
            news.put("id", id);
            news.put("url",med.getUrl_media()) ;
            news.put("titre",med.getLibelle());
            news.put("description", med.getDescription()) ;
            news.put("nbv",String.valueOf(med.getNbvote())) ;
            news.put("nbr_etoile",String.valueOf(this.Nombre_Etoile(med.getNbvote(),rs.getInt("id_cat"))));
            
             maListe.add(news);
            
             }
           
            ps.close();
       
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }
      return maListe ;
    }
       
        
        
     //j= le nombre 
    public int Nombre_Etoile(int nbr_media,int categorie)
    {   
        int sum_media=0;
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select SUM(nbr_vote) from media where id_cat=?  ");
            ps.setInt(1,categorie);
            ResultSet result = ps.executeQuery();
            result.next();
            sum_media=result.getInt(1);
            
            // on va trouver le nombre d'etoile d'un vote alors on fait l'equation suivante pour trouver
            // le pourcentage d'un nombre de vote par rapport le nombre total
            
            
            //si le media n'a pas aucun vote 
            if (nbr_media==0)
                return 0;
            // fi le somme est supérieur a 0 // ce controle pour evite la division sur 0
            else if (sum_media!=0){  
            
            float x=(100*nbr_media)/sum_media;
                if (x>=80)
                    return 5;
                if (x>=60)
                    return 4;
                if (x>=40)
                    return 3;
                if (x>=20)
                    return 2;
                if (x>=0)
                    return 1;
                
                
            }
            //si le somme est egal a 0 
             else return 0 ;
                            
           
            ps.close();
              
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        } 
         return (1);
    }
    public  List<Map<String, String>> affichermedia () 
    {
        List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
         
        
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select * from media order by nbr_vote desc ");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            med.setId_media(rs.getInt("id_media"));
            med.setLibelle(rs.getString("libelle"));
            med.setDescription(rs.getString("description"));
            med.setUrl_media(rs.getString("url_media"));
            cat.setId_categorie(rs.getInt("id_cat"));
            med.setNbvote(rs.getInt("nbr_vote"));
           
             
            String id = Integer.toString(med.getId_media())   ;
            
            news.put("id", id);
            news.put("url",med.getUrl_media()) ;
            news.put("titre",med.getLibelle());
            news.put("description", med.getDescription()) ;
            news.put("nbv",String.valueOf(med.getNbvote())) ;
            news.put("nbr_etoile",String.valueOf(this.Nombre_Etoile(med.getNbvote(),rs.getInt("id_cat"))));
             maListe.add(news);
            
             }
           
            ps.close();
       
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }
      return maListe ;
    }
    
    public void ajoutmedia(media m) {
        
          
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("insert into media(libelle,description,url_media,id_cat,nbr_vote) values (?,?,?,?,?) ");
 
            ps.setString(1,m.getLibelle());
            ps.setString(2, m.getDescription());
            ps.setString(3, m.getUrl_media());
            ps.setInt(4, m.getCategorie().getId_categorie());
            ps.setInt(5, m.getNbvote());
            
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
            med.setId_media(rs.getInt("id_media"));
            med.setLibelle(rs.getString("libelle"));
            med.setDescription(rs.getString("description"));
            med.setUrl_media(rs.getString("url_media"));
            cat.setId_categorie(rs.getInt("id_cat"));
            med.setNbvote(rs.getInt("nbr_vote"));
            
            news.put("url",med.getUrl_media()) ;
            news.put("titre",med.getLibelle());
            news.put("description", med.getDescription()) ;
            news.put("nbv",String.valueOf(med.getNbvote())) ;
            
            
            
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
            PreparedStatement ps=con.prepareStatement("select * from media where id_cat = 1 order by nbr_vote desc");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            med.setId_media(rs.getInt("id_media"));
            med.setLibelle(rs.getString("libelle"));
            med.setDescription(rs.getString("description"));
            med.setUrl_media(rs.getString("url_media"));
            cat.setId_categorie(rs.getInt("id_cat"));
            med.setNbvote(rs.getInt("nbr_vote"));
            String id = Integer.toString(med.getId_media())   ;
            
            news.put("id", id);
            news.put("url",med.getUrl_media()) ;
            news.put("titre",med.getLibelle());
            news.put("description", med.getDescription()) ;
            news.put("nbv",String.valueOf(med.getNbvote())) ;
            news.put("nbr_etoile",String.valueOf(this.Nombre_Etoile(med.getNbvote(),rs.getInt("id_cat"))));
            
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
            PreparedStatement ps=con.prepareStatement("select * from media where id_cat = 2 order by nbr_vote desc");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            med.setId_media(rs.getInt("id_media"));
            med.setLibelle(rs.getString("libelle"));
            med.setDescription(rs.getString("description"));
            med.setUrl_media(rs.getString("url_media"));
            cat.setId_categorie(rs.getInt("id_cat"));
            med.setNbvote(rs.getInt("nbr_vote"));
            String id = Integer.toString(med.getId_media())   ;
            news.put("id", id);
            news.put("url",med.getUrl_media()) ;
            news.put("titre",med.getLibelle());
            news.put("description", med.getDescription()) ;
            news.put("nbv",String.valueOf(med.getNbvote())) ;
            news.put("nbr_etoile",String.valueOf(this.Nombre_Etoile(med.getNbvote(),rs.getInt("id_cat"))));
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
            PreparedStatement ps=con.prepareStatement("select * from media where id_cat = 3 order by nbr_vote desc");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            med.setId_media(rs.getInt("id_media"));
            med.setLibelle(rs.getString("libelle"));
            med.setDescription(rs.getString("description"));
            med.setUrl_media(rs.getString("url_media"));
            cat.setId_categorie(rs.getInt("id_cat"));
            med.setNbvote(rs.getInt("nbr_vote"));
            
            String id = Integer.toString(med.getId_media())   ;
            news.put("id", id);
            news.put("url",med.getUrl_media()) ;
            news.put("titre",med.getLibelle());
            news.put("description", med.getDescription()) ;
            news.put("nbv",String.valueOf(med.getNbvote())) ;
            news.put("nbr_etoile",String.valueOf(this.Nombre_Etoile(med.getNbvote(),rs.getInt("id_cat"))));
             
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
            PreparedStatement ps=con.prepareStatement("select * from media where id_cat = 4 order by nbr_vote desc");
            
            ResultSet rs=ps.executeQuery();
             while (rs.next()) {
            Map<String, String> news = new HashMap<String, String>();     
            med.setId_media(rs.getInt("id_media"));
            med.setLibelle(rs.getString("libelle"));
            med.setDescription(rs.getString("description"));
            med.setUrl_media(rs.getString("url_media"));
            cat.setId_categorie(rs.getInt("id_cat"));
            med.setNbvote(rs.getInt("nbr_vote"));
            String id = Integer.toString(med.getId_media())   ;
            news.put("id", id);
            news.put("url",med.getUrl_media()) ;
            news.put("titre",med.getLibelle());
            news.put("description", med.getDescription()) ;
            news.put("nbv",String.valueOf(med.getNbvote())) ;
            news.put("nbr_etoile",String.valueOf(this.Nombre_Etoile(med.getNbvote(),rs.getInt("id_cat"))));
            
            
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
   public int SUMMEDIA(int a)
   {
   
   
    int i=0;
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select count(nbr_vote) from media where id_cat=? ");
            ps.setInt(1,a);
            ResultSet result = ps.executeQuery();
            result.next();
            i=result.getInt(1);
        
           
            ps.close();
            return i;
              
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        } 
         return 0;
   
   
   }

   public int SUMMEDIAINCATEGORIE(int a)
   {
   
   
    int i=0;
         try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select count(id_media) from media where id_cat=? ");
            ps.setInt(1,a);
            ResultSet result = ps.executeQuery();
            result.next();
            i=result.getInt(1);
        
           
            ps.close();
            return i;
              
 
 
       } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        } 
         return 0;
   
   
   }


}