/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.beans.categorie;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hamdi
 */
public interface interface_dao_categorie {
    void ajoutcategorie(categorie c);
    void supprimermedia(int i);
    void supprimercategorie(int i);
    void mise_a_jour();
     List<Map<String, String>> ListerCategorie();
}
