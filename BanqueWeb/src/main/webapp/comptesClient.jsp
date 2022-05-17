<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="tn.enis.entity.Compte"%>
<%@ page import="tn.enis.entity.Client"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comptes</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%
	Client c = (Client) request.getAttribute("client");
	%>
	<h1>
		Liste des comptes du client :<%=c.getNom()%></h1>
	<%
	List<Compte> comptes = (List<Compte>) request.getAttribute("accounts");
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
			for (Compte com : comptes) {
				Long rib = com.getRib();
		%>
		<tr id="<%=rib%>">
			<td><%=com.getRib()%></td>
			<td><%=com.getSolde()%></td>
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
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.6.0.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="js/compte.js"></script>
</body>
</html>