<%-- 
    Document   : AddCategorie
    Created on : 26 nov. 2017, 13:27:38
    Author     : hamdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Envoi de fichier</title>
         <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css2/shop-item.css" rel="stylesheet">
    <style>
       

    </style>
    </head>
    <body >
        <form action="Categorie" method="POST" enctype="multipart/form-data" >
            <%@include file="nav_Admin.jsp" %>
            <br><br><br>
             <label for="description">Titre du categorie</label>
                <input type="text" id="description" name="titre" value="" required/>
                <br />
                       <input type="submit" name="addcategorie" value="ajotuer Categorie" >
                <br>
                
                <br><br><br><br><br><br>
                
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
