<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>

	<h3>Gestion de IMC</h3>
	<b>Welcome ${sessionScope.nombre }</b>
	
	
	<br>
	<form method="post"
		action="${pageContext.request.contextPath }/HistoricoImc">
		<table border="0" cellpadding="2" cellspacing="2">
			<tr>
				<td>Altura</td>
				<td><input type="text" name="altura"></td>
			</tr>
			<tr>
				<td>Peso</td>
				<td><input type="text" name="peso"></td>
			</tr>
						
			
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Guardar" name="guardar">
			</tr>
			<tr><td>Mensaje respuesta: &nbsp; <b>${error }</b></td>
			</tr>
		</table>
		
		 <table border="1" cellpadding="0" cellspacing="" width="35%">
            <caption><h3>Historico Imc</h3></caption>
            <thead>
                <tr class="tr tr-success">
                    <td>Altura</td>
                    <td>Peso</td>
                    <td>IMC</td>
                    <td>Registro</td>
                </tr>   
            </thead>
            <tbody>
                <c:forEach items="${imclist}" var="temp">
                    <tr>
                        <td>${temp.altura} mts</td>
                        <td>${temp.peso} kgs</td>
                        <td>${temp.imc} %</td>
                        <td>${temp.fecha_registro}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		
	</form>	
	
	
	
	
	
	
	
	
	<a href="${pageContext.request.contextPath }/logout">Logout</a>

</body>
</html>