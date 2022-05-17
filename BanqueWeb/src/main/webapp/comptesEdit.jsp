<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="tn.enis.entity.Compte"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Edit</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1>Mise à jour compte</h1>
	<%
	Compte c = (Compte) request.getAttribute("compte");
	%>
	<form action="CompteController" method="POST">
		<input type="hidden" name="rib" value="<%=c.getRib()%>">
		<table>
			<tr>
				<td>Solde</td>
				<td><input type="text" name="solde" value="<%=c.getSolde()%>"></td>
			</tr>
			<tr>
				<td>Cin</td>
				<td><input type="text" name="cin"
					value="<%=c.getClient().getCin()%>"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-primary" name="action"
					value="apply"></td>
			</tr>
		</table>

	</form>

	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>