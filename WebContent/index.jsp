<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Login?opcion=validar" method="post">
		<input type="text" name="usuario" placeholder="Usuario"/>
		<input type="text" name="password" placeholder="Contraseņa"/>
		<input type="submit" name="ejecutar" value="Enviar"/>
	</form>
	
	<a href="Registro.jsp">Registrar SIIIN use</a>
	<a href="RegistroUsebean.jsp">Registrar COON use</a>
	
	<p><c:out value="${requestScope.mensajeLogin}"/></p> 
</body>
</html>