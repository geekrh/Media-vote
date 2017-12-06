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
   <%@include file="nav.jsp" %>

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
            
              List<Map<String, String>> maListe = new ArrayList<Map<String, String>>();
             
              maListe = (ArrayList<Map<String, String>>)request.getAttribute("listmedia"); 
                  // if (maListe != null) {
                       for (Map<String, String> entry : maListe) {
                                    
                      
                         %> 
                    <div class="card mt-4">
                        <img src="<%= entry.get("url") %>" height="300" >                      
                    <div class="card-body">
                        <h3 class="card-title"><%= entry.get("titre") %></h3>  
                         <p class="card-text"><%= entry.get("description") %></p>
                         <span class="text-warning"><% int a=Integer.parseInt(entry.get("nbr_etoile"));
                            if (a!=0) 
                            for (int i=0;i<a;i++)
                             out.print("&#9733");
                             %> </span>
			<!-- <p class="card-text"><%= entry.get("nbv") %></p> -->
          <p class="v">   <%= entry.get("nbv") %> <br> <p/>
                          <span><a href="voter?action=voter&id=<%= entry.get("id") %>" > voter </a> </span></div>
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
