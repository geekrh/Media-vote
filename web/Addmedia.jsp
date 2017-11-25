<%-- 
    Document   : Addmedia
    Created on : 29 oct. 2017, 00:34:34
    Author     : Mohammed Mehdi Sarray#
--%>

<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Envoi de fichier</title>
         <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css2/shop-item.css" rel="stylesheet">
    <style>
        fieldset { 
    display: block;
    margin-left: 2px;
    margin-right: 2px;
    padding-top: 0.35em;
    padding-bottom: 0.625em;
    padding-left: 0.75em;
    padding-right: 0.75em;
    border: 2px groove (internal value);
}
    </style>
    </head>
    <body >
        <form action="media" method="POST" enctype="multipart/form-data" >
            <%@include file="nav.jsp" %>
            <br><br><br>
            <fieldset style="margin-right: 10%;">
               
                <label for="description">Titre du media</label>
                <input type="text" id="description" name="titre" value="" required/>
                <br />
                <br>
                
                
                <label for="description">Description du media</label>
                <input type="text" id="description" name="description" value="" required/>
                <br />
                <br>
                Categorie Media 
                <Select name="categorie">
                    <option value="1">Film</option>
                    <option value="2">Jeux</option>
                    <option value="3">Serie</option>
                    <option value="4">Livre</option>
                </Select>
                <br><br>
                <label for="fichier">Emplacement du fichier <span class="requis">*</span></label>
                <input type="file" id="fichier" name="fichier"  accept="image/x-png,image/gif,image/jpeg"/>
                <br />
                <br>
                <label for="fichier"> <%  String s = null ;
                s  = (String) request.getAttribute("Message") ;
                                           if (s != null) { 
                                          
                                                out.print(s) ; }
                                                                %> <span class="requis">*</span></label>
                <input type="submit" name="plus" value="Envoyer"  />
                               
            </fieldset>
            <br><br> <br><br> <br><br> <br><br> 
        
        
          <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Media-Vote 2017</p>
      </div>
              
      <!-- /.container -->
    </footer>
            
        </form>
    </body>
</html>
