<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="tn.enis.entity.Client"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<meta charset="ISO-8859-1">
<title>Clients</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1 style="color:green">Ajout de client</h1>
	<form action="ClientController" method="POST">
		<table>
			<tr>
				<td>CIN</td>
				<td><input type="text" name="cin"></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><input type="text" name="nom" id="name"></td>
			</tr>
			<tr>
				<td>Prenom</td>
				<td><input type="text" name="prenom"></td>
			</tr>
			<tr>
				<td>Adresse</td>
				<td><input type="text" name="adresse"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-primary" name="action"
					value="add"><a
					href="http://localhost:8080/BanqueWeb/ClientController"><button
							type="button" class="btn btn-secondary">Afficher clients</button></a></td>
			</tr>
		</table>

	</form>
	<%-- var availableTags =[{}]; $("#name").autocomplete({ source :availableTags }); --%>
 
	</script>
	<h1 style="color:green">Liste des clients</h1>

	<%
	List<Client> clients = (List<Client>) request.getAttribute("clients");
	%>
	<table class="table">
		<tr>
			<th>CIN</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Adresse</th>
			<th>Delete</th>
			<th>Edit</th>
			<th> Liste des comptes </th>

		</tr>
		<%
		if (clients != null && !clients.isEmpty()) {
			for (Client c : clients) {
				String cin = c.getCin();
		%>
		<tr id="<%=cin%>">
			<td><%=c.getCin()%></td>
			<td><%=c.getNom()%></td>
			<td><%=c.getPrenom()%></td>
			<td><%=c.getAdresse()%></td>
			<td><a href="javascript:deleteClient(<%=cin%>)"><button
						type="button" class="btn btn-secondary">Delete</button></a></td>
			<td><a href=ClientController?action=edit&cin=<%=cin%>><button
						type="button" class="btn btn-secondary">Edit</button></a></td>
			<td><a href=ClientController?action=userAccounts&cin=<%=cin%>><button
						type="button" class="btn btn-secondary">Afficher</button></a></td>
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
	<script src="js/client.js"></script>
</body>
</html>