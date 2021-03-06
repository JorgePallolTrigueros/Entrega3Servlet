<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	
	<div class = "mt-5 mb-5 container">
	<h1>Todo detail ${user.id}</h1>
		<h1>Todo detail ${direccion.id}</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/direccion" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "description" placeholder = "Enter Name" value = "${direccion.direccion_personal1}"/>
						<input type = "text" class = "form-control" name = "description" placeholder = "Enter Name" value = "${direccion.direccion_personal2}"/>
					</div>




</div>
					<input type = "hidden" name = "id" value = "${direccion.id}"/>
				
					<button type = "submit" class = "btn btn-primary mt-3">Save</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/todos">Volver</a>
	</div>
	
<jsp:include page="footer.jsp"></jsp:include>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>