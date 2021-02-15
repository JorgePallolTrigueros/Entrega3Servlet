<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	
	
	<div class = "container">
	
		<div class = "mt-5 mb-5 container">
		
		<h1>Inserto de de Usuario</h1> 
		<hr/>
		
		<p>${NOTIFICATION}</p>

<form action="Login?opcion=registrar" method="post">


<table class="table">
  <thead>

  </thead>
  <tbody>
    <tr>
      <th scope="row">Usuario</th>
      <td></td>
      <td><input type="text" maxlength="20" size="20" name="usuario" placeholder="Usuario"></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">Contraseña</th>
      <td></td>
      <td><input type="password" maxlength="20" size="20" name="password" placeholder="Contraseña"></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">Apellidos</th>
      <td></td>
      <td><input type="text" maxlength="20" size="20" name="last_name" placeholder="Last Name"></td>
      <td></td>
    </tr>
        <tr>
      <th scope="row">Email</th>
      <td></td>
      <td><input type="text" maxlength="20" size="20" name="email" placeholder="email"></td>
      <td></td>
    </tr>
    
        <tr>
      <th scope="row">Nombre</th>
      <td></td>
      <td><input type="text" maxlength="20" size="20" name="first_name" placeholder="first_name"></td>
      <td></td>
    </tr>
    
        <tr>
      <th scope="row">Edad</th>
      <td></td>
      <td><input type="number" maxlength="20" size="20" name="age" placeholder="age"></td>
      <td></td>
    </tr>
    
    <tr>
      <th scope="row">Nif</th>
      <td></td>
      <td><input type="text" maxlength="20" size="20" name="nif" placeholder="Nif"></td>
      <td></td>
    </tr>
    
     <tr>
      <th scope="row">Estrado Civil</th>
      <td></td>
      <td>   <select name="maried">
   <option value="Casado">Casado/a</option>
   <option value="Casado">Soltero/a</option>
   </select></td>
      <td></td>
    </tr>  
     
  </tbody>
</table>




	  
   <br/><br/><input type="submit"  value="enviar"><br/><br/><br/>
</form>
   <a href="/entregam3/UserController">Volver Inicio</a></br>	

<jsp:include page="footer.jsp"></jsp:include>
