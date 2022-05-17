package tn.enis.dao;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.Client;
import tn.enis.entity.Compte;


@Singleton
@LocalBean
public class CompteDao {

	@PersistenceContext
	private EntityManager em;

	/*public void test() {
		
		 * Client client = new Client("087", "Belhadj", "Wiem"); em.persist(client);
		 * Compte compte1 = new Compte(1000, client); em.persist(compte1); Compte
		 * compte2 = new Compte(200, client); em.persist(compte2);
		 

		// unidirectionnel
		Compte compte = em.find(Compte.class, 1L);
		System.out.println(compte.getClient());

		// comment récupérer la liste des comptes
		List<Compte> comptes = em.createQuery("select c from Compte c where c.client.cin=:cin", Compte.class)
				.setParameter("cin", "087").getResultList();
		System.out.println(comptes);

	}*/

	public void save(Compte compte) {
		em.persist(compte);
	}

	public void update(Compte compte) {
		em.merge(compte);
	}

	public void delete(Compte compte) {
		em.remove(compte);
	}

	public Compte getById(Long rib) {
		return em.find(Compte.class, rib);
	}

	public List<Compte> getAll() { // EJB-QL ou JP-QL, orient� objet
		return em.createQuery("select c from Compte c", Compte.class).getResultList();
	}

	public List<Compte> getAllByClient(Client client) { // EJB-QL ou JP-QL, orient� objet
		return em.createQuery("select c from Compte c where c.client=:clt", Compte.class).setParameter("clt", client)
				.getResultList();
	}
}



