<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta, modificacion consulta de users administrador</title>
</head>
<body>


	<form action="GestionCRUD" method="post">
	<input type="text" maxlength="20" size="20" name="isbn" value="${sessionScope.user.}" placeholder="isbn">
  
	<br/><br/><input type="text" name="first_name" value="${sessionScope.user.first_name}" placeholder="Titulo">
	<br/><br/><input type="text" name="last_name" value="${sessionScope.user.last_name}" placeholder="Autor">
	<br/><br/><input type="text" name="password" value="${sessionScope.user.password}" placeholder="Paginas">
	<br/><br/><input type="text" name="age" value="${sessionScope.user.age}" placeholder="Precio">
	<br/><br/><input type="text" name="maried" value="${sessionScope.user.maried}" placeholder="Tema">
   
	
   <br/><br/><input type="submit"  name="crud" value="Alta">
    <input type="submit"  name="crud" value="Modificar">
    <input type="submit"  name="crud" value="Eliminar">
    <input type="submit"  name="crud" value="Consultar">
    

</form>

	<p><c:out  value="${requestScope.mensajeCRUD }"/></p>
   <p><a href="index.jsp">Volver Inicio</a></p>
</body>
</html>