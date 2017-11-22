/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.beans.membre;
import dao.daomedia ;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hamdi
 */
public interface interface_dao_membre {
    boolean verif(membre m);
    void ajouter_membre(membre m);
    
}
