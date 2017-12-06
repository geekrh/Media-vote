/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modele.modele_membre;
import Modele.model_media;
import dao.beans.categorie;
import dao.daomedia ;
import dao.beans.membre;
import dao.daocategorie;
import dao.daomembre ;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Mohammed Mehdi Sarray#
 */
public class media extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private daomedia media = new daomedia() ;
    private daocategorie categorie=new daocategorie();
    public static final String CHEMIN = "chemin";
    public static final int TAILLE_TAMPON = 10240; // 10 ko
    
    private static String getNomFichier( Part part ) {
    /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
    for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
        /* Recherche de l'éventuelle présence du paramètre "filename". */
        if ( contentDisposition.trim().startsWith( "filename" ) ) {
            /*
             * Si "filename" est présent, alors renvoi de sa valeur,
             * c'est-à-dire du nom de fichier sans guillemets.
             */
            return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
        }
    }
    /* Et pour terminer, si rien n'a été trouvé... */
    return null;
}

  private void cpy(Path src,Path dst) throws IOException
  {
      Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING) ;
      
  }
    
    /*
 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
 * sur le disque, dans le répertoire donné et avec le nom donné.
 */
/*
 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
 * sur le disque, dans le répertoire donné et avec le nom donné.
 */
private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
    /* Prépare les flux. */
    BufferedInputStream entree = null;
    BufferedOutputStream sortie = null;
    try {
        /* Ouvre les flux. */
        entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
        sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ),
                TAILLE_TAMPON );

        /*
         * Lit le fichier reçu et écrit son contenu dans un fichier sur le
         * disque.
         */
        byte[] tampon = new byte[TAILLE_TAMPON];
        int longueur;
        while ( ( longueur = entree.read( tampon ) ) > 0 ) {
            sortie.write( tampon, 0, longueur );
        }
    } finally {
        try {
            sortie.close();
        } catch ( IOException ignore ) {
        }
        try {
            entree.close();
        } catch ( IOException ignore ) {
        }
    }
}
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        
            if (request.getParameter("action").equals("filtrer"))
            {
               int categorie=Integer.parseInt(request.getParameter("id"));
               
                     List<Map<String, String>> lst = new ArrayList<Map<String, String>>(); 
                     lst = this.media.affichermediaParCategorie(categorie);
                     request.setAttribute("listmedia", lst);
                     request.setAttribute("listcategorie",this.categorie.ListerCategorie());
                     RequestDispatcher rd = request.getRequestDispatcher("page_principale.jsp");
                     rd.forward(request, response);}
                    
            
           
           if (request.getParameter("plus")!= null)
           
          { 
              /*
          * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
          * dans le web.xml
           */  String chemin = this.getServletConfig().getInitParameter( CHEMIN );
           
            int id_categorie=Integer.parseInt(request.getParameter("categorie"));
            String desc =  request.getParameter("description") ;
            String titre  = request.getParameter("titre") ; // titre du media 
           
    /*
     * Les données reçues sont multipart, on doit donc utiliser la méthode
     * getPart() pour traiter le champ d'envoi de fichiers.
     */
    Part part = request.getPart("fichier");
        
    /*
     * Il faut déterminer s'il s'agit d'un champ classique 
     * ou d'un champ de type fichier : on délègue cette opération 
     * à la méthode utilitaire getNomFichier().
     */
    String nomFichier = getNomFichier( part );

    /*
     * Si la méthode a renvoyé quelque chose, il s'agit donc d'un champ
     * de type fichier (input type="file").
     */
    if ( nomFichier != null && !nomFichier.isEmpty() ) {
        String nomChamp = part.getName();
        request.setAttribute( nomChamp, nomFichier );
    } List<Map<String, String>> lst = new ArrayList<Map<String, String>>(); 
               
    
    String Exist="false" ;
           lst = media.affichermedia();
           
            for (Map<String, String> entry : lst) {
             
                if( entry.get("titre").equals(titre)) 
                {
                     Exist="true" ;
                     break;
                }
            }
            
               
              if( Exist.equals("false")) 
              { 
             categorie c=new categorie(id_categorie);
             dao.beans.media media_ajouter=new dao.beans.media(titre, desc,"image/"+nomFichier,c,0);
             media.ajoutmedia(media_ajouter);
             // Ajout du nouveau MEDIA
             
             /*
              List<Map<String, String>> lst = new ArrayList<Map<String, String>>(); 
              lst = m.affichermedia() ; */
             
            lst= new ArrayList<Map<String, String>>();
             
             lst = media.afficherFilm() ;
             
                    // lst.add(m.afficherMediaRecent(titre));
              
             
              request.setAttribute("listmedia", lst);
              
              ecrireFichier(part,nomFichier,chemin ) ; // APPEL DU KING #
            
              Path dst = Paths.get("C:\\Users\\hamdi\\Documents\\NetBeansProjects\\Md-vote\\web\\image\\"+nomFichier);
              Path src = Paths.get("C:\\image\\"+nomFichier);
              cpy(src,dst) ;
              RequestDispatcher rd = request.getRequestDispatcher("page_principale.jsp");
              
               rd.forward(request, response);
            } else {
                  String msg = "Media Existant" ; 
                  request.setAttribute("Message", msg);
               RequestDispatcher rd = request.getRequestDispatcher("Addmedia.jsp");
              
               rd.forward(request, response);   
              }
          }
           
           
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
