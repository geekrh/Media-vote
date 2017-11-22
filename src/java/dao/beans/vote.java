/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.beans;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Mohammmed Mehdi Sarray#
 */
public class vote implements Serializable{
    private Timestamp date_vote; 
    private media media; 
    private membre membre ; 

    public vote(Timestamp date_vote, media media, membre membre) {
        this.date_vote = date_vote;
        this.media = media;
        this.membre = membre;
    }

    public Timestamp getDate_vote() {
        return date_vote;
    }

    public void setDate_vote(Timestamp date_vote) {
        this.date_vote = date_vote;
    }

    public media getMedia() {
        return media;
    }

    public void setMedia(media media) {
        this.media = media;
    }

    public membre getMembre() {
        return membre;
    }

    public void setMembre(membre membre) {
        this.membre = membre;
    }
    
    
    
}
