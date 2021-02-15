<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Directory</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

	<h3>Sesion de :  ${sessionScope.usuario.first_name}</h3>
	<div class = "container">

			
		<h1>Usuarios </h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/Registro_dentro.jsp'">Añadir Usuario</button>
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Email</th>
				<th>Estado Civil</th>
				<th>Edad</th>
				<th>Password</th>
				<th>Niff</th>
				<th>Acciones</th>
			</tr>
			
			<c:forEach items="${list}" var="user">
			
				<tr>

					<td>${user.first_name}</td>
					<td>${user.last_name}</td>					
					
					<td>${user.email}</td>
					<td>${user.married}</td>
					<td>${user.age}</td>
					<td>${user.password}</td>
					<td>${user.nif}</td>

					<td> 
					 
					
					
						<a href = "${pageContext.request.contextPath}/UserController?action=EDIT&id=${user.id}">Editar</a> 
						
						| <a href = "${pageContext.request.contextPath}/UserController?action=VIEW&id=${user.id}">Ver Direcciones</a> 
							
						| <a href = "${pageContext.request.contextPath}/UserController?action=DELETE&id=${user.id}">Borrar</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>
<jsp:include page="footer.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>