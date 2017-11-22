<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ page import="java.util.*" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.List"%>
<%@page import="dao.beans.media" %>
<%@page import="dao.daomedia" %>

<!DOCTYPE html>
<html>
     <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MEDIA-VOTE</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css2/shop-item.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Vote challenge</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Profile</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="http://localhost:8089/Vote2/Addmedia.jsp">Add</a>
                </li>
            <li class="nav-item">
              <a class="nav-link" href="http://localhost:8089/Vote2/index.jsp">Log out</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3">
          <h1 class="my-4">Vote</h1>
          <div class="list-group">
            <a href="film.jsp" class="list-group-item ">Film</a>
            <a href="#" class="list-group-item "id="jeux">Jeux</a>
            <a href="livre.jsp" class="list-group-item ">Livre</a>
            <a href="serie.jsp" class="list-group-item ">Serie</a>
            
          </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9" id="contenu">
         

         <%  
            daomedia modetud= new  daomedia();
            List<Map<String, String>> maListe = modetud.afficherJeux();
            
                       
               for (Map<String, String> entry : maListe) {
                    
                      
                         %> 
                    <div class="card mt-4">
                        <img src="<%= entry.get("url") %>" height="300" >                      
                    <div class="card-body">
                        <h3 class="card-title"><%= entry.get("titre") %></h3>  
                         <p class="card-text"><%= entry.get("description") %></p>
                         <span class="text-warning">&#9733; </span>
			<!-- <p class="card-text"><%= entry.get("nbv") %></p> -->
                         <p class="v">   1.0 stars<br> <p/>
              <span><button id="vote"><img src="image/voter.png" width="30" height="30"></button> voter</span>
            </div>
          </div>
                       <%        
                             }
                        
                           // }
                   
                         %>
              
             
            
          <!-- /.card -->

          <div class="card card-outline-secondary my-4">
            
          </div>
          <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Media-Vote 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script>
        var max = 0 ;
$(document).ready(function(){
    $("#vote").click(function(){
        $(".text-warning").append(" &#9733; ");
       $("#vote").prop("disabled",true);
    
        
    });
});
</script>

    </body>
</html>
