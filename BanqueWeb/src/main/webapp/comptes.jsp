<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="tn.enis.entity.Compte"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title style="color:green">Comptes</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1 style="color:green">Ajout de compte</h1>
	<form action="CompteController" method="post">
		<table>
			<tr>
				<td>Solde</td>
				<td><input type="text" name="solde"></td>
			</tr>
			<tr>
				<td>Cin</td>
				<td><input type="text" name="cin"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-primary" name="action"
					value="add"> <a
					href="http://localhost:8080/BanqueWeb/CompteController"><button
							type="button" class="btn btn-success">Afficher comptes</button></a></td>
			</tr>
		</table>

	</form>
	<h1 style="color:green">Liste des comptes</h1>

	<%
	List<Compte> comptes = (List<Compte>) request.getAttribute("comptes");
	%>
	<table class="table">
		<tr>
			<th>RIB</th>
			<th>Solde</th>
			<th>Delete</th>
			<th>Edit</th>

		</tr>
		<%
		if (comptes != null && !comptes.isEmpty()) {
			for (Compte c : comptes) {
				Long rib = c.getRib();
		%>
		<tr id="<%=rib%>">
			<td><%=c.getRib()%></td>
			<td><%=c.getSolde()%></td>
			<td><a href="javascript:deleteCompte(<%=rib%>)"><button
						type="button" class="btn btn-secondary">Delete</button></a></td>
			<td><a href=CompteController?action=edit&rib=<%=rib%>><button
						type="button" class="btn btn-secondary">Edit</button></a></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<a href="index.html"><button type="button"
			class="btn btn-secondary">Accueil</button></a>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.6.0.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="js/compte.js"></script>
</body>
</html>