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
	
		<h1>Corregir Usuario</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/UserController" method="POST">
				
				
				
				
<table class="table">

  <tbody>

    <tr>
      <th scope="row">Contraseña</th>
      <td></td>
      <td><input type = "text" class = "form-control" name = "password" placeholder = "Enter Password" value = "${user.password}"/></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">Apellidos</th>
      <td></td>
      <td><input type = "text" class = "form-control" name = "last_name" placeholder = "Enter Last Name" value = "${user.last_name}"/></td>
      <td></td>
    </tr>
        <tr>
      <th scope="row">Email</th>
      <td></td>
      <td><input type = "text" class = "form-control" name = "email" placeholder = "Enter e-Mail" value = "${user.email}"/></td>
      <td></td>
    </tr>
    
        <tr>
      <th scope="row">Nombre</th>
      <td></td>
      <td><input type = "text" class = "form-control" name = "first_name" placeholder = "Entre First Name" value = "${user.first_name}"/></td>
      <td></td>
    </tr>
    
        <tr>
      <th scope="row">Edad</th>
      <td></td>
      <td><input type = "text" class = "form-control" name = "age" placeholder = "Enter edad" value = "${user.age}"/></td>
      <td></td>
    </tr>
    
    <tr>
      <th scope="row">Nif</th>
      <td></td>
      <td>	<input type = "text" class = "form-control" name = "niff" placeholder = "Enter e-Mail" value = "${user.nif}"/></td>
      <td></td>
    </tr>
    
     <tr>
      <th scope="row">Estrado Civil</th>
      <td></td>
      <td>   <select name="maried">
   <option value="Casado">Casado/a</option>
   <option value="Casado">Soltero/a</option>
   </select>
					<input type = "hidden" name = "id" value = "${user.id}"/>				
					<input type = "hidden" name = "TipoUser" value = "normal"/>
					
					
      <td>   <br/><br/><input type="submit"  value="enviar"><br/><br/><br/></td>
    </tr>  
     
  </tbody>
</table>

				</form>
			</div>
		</div>
		 <a href="/entregam3/UserController">Volver Inicio</a></br>	
	
	</div>
	
<jsp:include page="footer.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>