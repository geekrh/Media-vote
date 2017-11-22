/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Mohammed Mehdi Sarray#
 */
public interface interface_dao_media {
    List<Map<String, String>> affichermedia() ;
    void ajoutmedia(String lib,String desc , String url) ;
      Map<String, String> afficherMediaRecent (String lib) ;
}
