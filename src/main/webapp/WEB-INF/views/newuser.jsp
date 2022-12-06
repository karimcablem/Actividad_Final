<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creacion de Usuario</title>
</head>
<body>

	<h3>Nuevo Usuario</h3>
		<b>${error }</b>
	<form method="post"
		action="${pageContext.request.contextPath }/CreateUser">
		<table border="0" cellpadding="2" cellspacing="2">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre"></td>
			</tr>			
			<tr>
				<td>Edad</td>
				<td><select name="edad">
				  <% for(int i = 15; i < 100; i+=1) { %>
					  <option value="<%=i%>"><%=i%> a&ntilde;os</option>
        			<% } %>

					</select></td>
			</tr>
			<tr>
				<td>Sexo</td>
				<td><select name="sexo">
					  <option value="M" selected>Masculino</option>
					  <option value="F" >Femenino</option>
					</select></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Crear" name="crear">
			</tr>
		</table>
	</form>

</body>
</html>