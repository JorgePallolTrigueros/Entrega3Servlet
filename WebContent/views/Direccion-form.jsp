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
	
		<h1>Corregir Direccion</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/DireccionController" method="POST">
				
				
				
				
<table class="table">

  <tbody>

    <tr>
      <th scope="row">Direccion 1</th>
      <td></td>
      <td><input type = "text" class = "form-control" name = "direccionpersonal1" placeholder = "Enter Directon 1" value = "${direccion.direccion_personal}"/></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">Direccion 2</th>
      <td></td>
      <td><input type = "text" class = "form-control" name = "direccionpersonal2" placeholder = "Enter Direction 2" value = "${direccion.direccion_personal2}"/></td>
      <td></td>
    </tr>
     
					
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