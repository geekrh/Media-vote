/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.beans.membre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitaire.SingletonConnection;

/**
 *
 * @author hamdi
 */
public class daomembre implements interface_dao_membre{

    java.util.Date date = new java.util.Date();
    java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
     
    @Override
    public membre verif(membre m) {
         try {
             Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("select * from member where Login=? and Password=?");
             ps.setString(1,m.getLogin());
             ps.setString(2,m.getPassword());
            ResultSet rs=ps.executeQuery();
            if (rs.next())
            { 
               membre mem= new membre(rs.getString("login"),rs.getString("password"),rs.getInt("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("type"));
               return mem;
            }
            ps.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
         return null;
    }

    @Override
    public void ajouter_membre(membre m) {
        try {
            Connection con=SingletonConnection.getCon();
            PreparedStatement ps=con.prepareStatement("insert into member(cin,nom,prenom,email,type,Date_ins,Login,Password)  values (?,?,?,?,?,?,?,?)");
            ps.setInt(1, m.getCin());
            ps.setString(2,m.getNom());
            ps.setString(3,m.getPrenom());
            ps.setString(4,m.getEmail());
            ps.setString(5, m.getType());
            ps.setTimestamp(6, timestamp);
            ps.setString(7,m.getLogin());
            ps.setString(8, m.getPassword());
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(daomembre.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
