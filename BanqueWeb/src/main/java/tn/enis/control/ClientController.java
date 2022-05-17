package tn.enis.control;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.entity.Client;
import tn.enis.entity.Compte;
import tn.enis.service.ClientService;
import tn.enis.service.CompteService;

@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CompteService compteService;
	@EJB
	private ClientService clientService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("add".equals(request.getParameter("action"))) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
			String cin = request.getParameter("cin");

			Client client = new Client(cin, nom, prenom, adresse);
			clientService.save(client);
			response.getWriter().append("<h1> client ajouté avec succés</h1>");
		}

		if ("delete".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			clientService.delete(cin);
			return;
		}

		if ("edit".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			Client client = clientService.getById(cin);

			request.setAttribute("client", client);
			request.getRequestDispatcher("clientsEdit.jsp").forward(request, response);
			return;
		}

		if ("apply".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
			Client client = new Client(cin, nom, prenom, adresse);
			clientService.update(client);
		}

		if ("userAccounts".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			Client client = clientService.getById(cin);
			List<Compte> accounts = compteService.getAllByClient(client);
			request.setAttribute("client", client);
			request.setAttribute("accounts", accounts);
			request.getRequestDispatcher("comptesClient.jsp").forward(request, response);
			return;
		}

		request.setAttribute("clients", clientService.getAll());
		request.getRequestDispatcher("clients.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}