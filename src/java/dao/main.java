/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.* ;
import dao.beans.*;
import java.util.* ;
/**
 *
 * @author Mohammed Mehdi Sarray#
 */
public class main {
    public static void main (String args[])
    {  
        List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
        
       daomedia m = new daomedia() ;
      
          maListe =  m.affichermedia() ;
        
     
               
         int total = 0 ;
          
         for (Map<String, String> entry : maListe) {
                 
                  
                   
                     
                      System.out.print(entry+"\n"+maListe.indexOf(entry));
                      System.out.print(total=maListe.indexOf(entry));
                    // System.out.println(entry.get("nbv")) ;
                  }
       

         }
         
        
    }


          
    


