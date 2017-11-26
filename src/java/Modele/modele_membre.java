/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import dao.beans.membre;
import dao.interface_dao_membre;

/**
 *
 * @author Mohammed Mehdi Sarray#
 */
public class modele_membre {
    private membre membre;
    private interface_dao_membre intmembre;
    public membre verif(membre m)
    {
        return intmembre.verif(m);
    }
    public void ajouter_membre(membre m)
    {
        intmembre.ajouter_membre(m);
    }
    
}
