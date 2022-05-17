package tn.enis.control;

import java.io.IOException;

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

@WebServlet("/CompteController")
public class CompteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CompteService compteService;
	@EJB
	private ClientService clientService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("add".equals(request.getParameter("action"))) {

			Client client = clientService.getById(request.getParameter("cin"));
			float solde = Float.parseFloat(request.getParameter("solde"));
			Compte compte = new Compte(solde, client);
			compteService.save(compte);

			response.getWriter().append("<h1> compte ajout� avec succ�s</h1>");
		}

		if ("delete".equals(request.getParameter("action"))) {
			Long rib = Long.parseLong(request.getParameter("rib"));
			compteService.delete(rib);
			return;
		}

		if ("edit".equals(request.getParameter("action"))) {
			Long rib = Long.parseLong(request.getParameter("rib"));
			Compte compte = compteService.getById(rib);

			request.setAttribute("compte", compte);
			request.getRequestDispatcher("comptesEdit.jsp").forward(request, response);
			return;
		}

		if ("apply".equals(request.getParameter("action"))) {
			Long rib = Long.parseLong(request.getParameter("rib"));
			Client client = clientService.getById(request.getParameter("cin"));
			float solde = Float.parseFloat(request.getParameter("solde"));

			Compte compte = new Compte(rib, solde, client);
			compteService.update(compte);
		}

		request.setAttribute("comptes", compteService.getAll());
		request.getRequestDispatcher("comptes.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
