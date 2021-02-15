<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<h1>Sesion de :  ${sessionScope.usuario.first_name}</h1>

<a href="/UserController">Gestionar Usuarios</a></br>
<a href="CrudUser.jsp">Gestionar Usuarios</a></br>

<a href="GestionLibros?opcion=cerrarSesion">Logout</a></br>



    

	<p><c:out  value="${requestScope.mensajeCRUD }"/></p>
   <p><a href="index.jsp">Volver Inicio</a></p>






<p><c:out value="${requestScope.mensaje}"/></p>
</body>
</html>