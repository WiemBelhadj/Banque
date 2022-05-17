package tn.enis.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.Client;

@Singleton
@LocalBean
public class ClientDao {

	@PersistenceContext
	private EntityManager em;

	/*
	 * public void test() {
	 * 
	 * Client client = new Client("087", "Jallouli", "Rahma"); em.persist(client);
	 * Client client1 = new Client(1000, client); em.persist(client1); Client
	 * client2 = new Client(200, client); em.persist(client2);
	 * 
	 * 
	 * // unidirectionnel //Client client = em.find(Client.class, 1L);
	 * //System.out.println(client.getNom());
	 * 
	 * // comment r�cup�rer la liste des clients List<Client> clients =
	 * em.createQuery("select c from Client c where c.compte.rib=:rib",
	 * Client.class) .setParameter("rib", "087").getResultList();
	 * System.out.println(clients);
	 * 
	 * }
	 */

	public void save(Client client) {
		em.persist(client);
	}

	public void update(Client client) {
		em.merge(client);
	}

	public void delete(Client client) {
		em.remove(client);
	}

	public Client getById(String cin) {
		return em.find(Client.class, cin);
	}

	public List<Client> getAll() { // EJB-QL ou JP-QL, orient� objet
		return em.createQuery("select c from Client c", Client.class).getResultList();
	}

	public Client getByCompte(String compte) {
		return em.find(Client.class, compte);
	}

}
