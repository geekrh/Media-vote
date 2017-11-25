<%-- 
    Document   : nav.jsp
    Created on : 25 nov. 2017, 08:10:10
    Author     : hamdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css2/shop-item.css" rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Vote challenge</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="Home?home=home">Home</a>
            </li>
            <li class="nav-item">

              <li class="nav-item">
                <a class="nav-link" href="Profil">Profile</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="Addmedia.jsp">Add</a>
                </li>
            <li class="nav-item">
              <a class="nav-link" href="index.jsp">Log out</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    </body>
</html>
