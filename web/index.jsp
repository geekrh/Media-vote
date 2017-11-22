

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <head>
  <meta charset="UTF-8">
  <title>Login & Sign Up VOTE-MEDIA</title>
  
  
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:400,300'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>

      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>
    
  <div class="cotn_principal">
<div class="cont_centrar">

  <div class="cont_login">
<div class="cont_info_log_sign_up">
      <div class="col_md_login">
<div class="cont_ba_opcitiy">
        
        <h2>LOGIN</h2>  
 
  <button class="btn_login"  name="zzq" value="pap" onclick="cambiar_login()">LOGIN</button>
  </div>
  </div>
<div class="col_md_sign_up">
<div class="cont_ba_opcitiy">
  <h2>SIGN UP</h2>

  
  

  <button class="btn_sign_up" name="zz" value="bf" onclick="cambiar_sign_up()">SIGN UP</button>
</div>
  </div>
       </div>

    
    <div class="cont_back_info">
       <div class="cont_img_back_grey">
       <img src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d" alt="" />
       </div>
       
    </div>
<div class="cont_forms" >
    <div class="cont_img_back_">
       <img src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d" alt="" />
       </div>
 <div class="cont_form_login">
<a href="#" onclick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
   <h2>LOGIN</h2>
   <form method="post" action="Connection">
 <input type="text" placeholder="Email" name="l1" />
<input type="password" placeholder="Password" name="p1" />
<button class="btn_login" name="logme" value="d" onclick="cambiar_login()">LOGIN</button>
  </div>
  
   <div class="cont_form_sign_up">
<a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
     <h2>SIGN UP</h2>
<input type="text" name="mail"  placeholder="Email" />
<input type="text" name="nom"  placeholder="Name" />
<input type="text" name="prenom"  placeholder="Surname" />
<input type="text" name="cin"  placeholder="Cin" />
<input type="text" name="name" placeholder="User" />
<input type="password" name="pwd"  placeholder="Password" />
<input type="password" placeholder="Confirm Password" />
<button class="btn_sign_up" name="logme" value="insc" onclick="cambiar_sign_up()">SIGN UP</button>
 </form>
  </div>

    </div>
    
  </div>
 </div>
</div>
  
    <script  src="js/index.js"></script>
   
    </body>
</html>
