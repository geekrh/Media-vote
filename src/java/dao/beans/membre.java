/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.beans;

import java.util.ArrayList;
import java.sql.Timestamp ;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
/**
 *
 * @author Mohammmed Mehdi Sarray#
 */
public class membre extends personne{
   private String login ; 
   private String password;
   private String type ;
   private Timestamp date_inscription ;
   private ArrayList<vote> vote; 
  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    public membre(String login, String password, ArrayList<vote> vote, int cin, String nom, String prenom, String email , Timestamp dateinsc , String Type) {
        super(cin, nom, prenom, email);
        this.login = login;
        this.password = password;
        this.vote = vote;
        this.date_inscription = dateinsc ;
        this.type = Type ;
    }

    public membre(String login, String password, int cin, String nom, String prenom, String email) {
        super(cin, nom, prenom, email);
        this.login = login;
        this.password = password;
    }
    
    
    public membre(String login, String password, int cin, String nom, String prenom, String email ,String Type) {
        super(cin, nom, prenom, email);
        this.login = login;
        this.password = password;
        this.type = Type ;
       
    }

    public membre(){
        super();
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(Timestamp date_inscription) {
        this.date_inscription = date_inscription;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<vote> getVote() {
        return vote;
    }

    public void setVote(ArrayList<vote> vote) {
        this.vote = vote;
    }
    
    
}
