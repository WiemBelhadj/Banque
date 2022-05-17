<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="tn.enis.entity.Client"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
</head>
<body>
	<h1>Mise à jour client</h1>
	<%
	Client c = (Client) request.getAttribute("client");
	%>
	<form action="ClientController" method="POST">
		<table>
			<tr>
				<td>CIN</td>
				<td><input type="text" name="cin" value="<%=c.getCin()%>"></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><input type="text" name="nom" value="<%=c.getNom()%>"></td>
			</tr>
			<tr>
				<td>Prenom</td>
				<td><input type="text" name="prenom" value="<%=c.getPrenom()%>"></td>
			</tr>
			<tr>
				<td>Adresse</td>
				<td><input type="text" name="adresse" value="<%=c.getAdresse()%>"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-primary" name="action" value="apply"></td>
			</tr>
		</table>

	</form>

	<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>