<%-- 
    Document   : profil
    Created on : 29 oct. 2017, 12:41:58
    Author     : hamdi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="dao.beans.media"%>
<%@page import="dao.beans.membre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>


<%   
    if(request.getAttribute("model") == null)
    {
       response.sendRedirect("index.jsp");
       
    }
       
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
     <head>
 <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css2/shop-item.css" rel="stylesheet">
    <style>
        
            
            

    </style>
 
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Item - Start Bootstrap Template</title>

 </head>

  <body>
    
      <!-- Navigation -->
<%@include file="nav.jsp"  %>
<!-- Page Content -->
<%

membre m=(membre)request.getAttribute("model");

%>
<br><br><br>
 <fieldset style="display: block;
    margin-left: 2px;
    margin-right: 2px;
    padding-top: 0.35em;
    padding-bottom: 0.625em;
    padding-left: 0.75em;
    padding-right: 0.75em;
    border: 2px groove (internal value);">
     <label style="margin-left: 10%;">Nom :</label> <% m.getNom(); %>      <br>
     <label style="margin-left: 10%;">Prenom :</label>  <% m.getPrenom(); %>  <br>  
     <label style="margin-left: 10%;">Email :</label><% m.getEmail(); %>  <br>
     <label style="margin-left: 10%;">Login :</label> <% m.getLogin(); %>   <br>
     <label style="margin-left: 10%;">Password :</label> <% m.getPassword(); %> <br>  


 </fieldset>
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

      
    </body>
</html>
