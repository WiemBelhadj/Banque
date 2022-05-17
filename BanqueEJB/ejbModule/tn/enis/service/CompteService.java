package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.enis.dao.CompteDao;
import tn.enis.entity.Client;
import tn.enis.entity.Compte;

@Stateless
@LocalBean
public class CompteService {
	@EJB
	private CompteDao compteDao;

	public void save(Compte compte) {
		compteDao.save(compte);
	}

	public void update(Compte compte) {
		compteDao.update(compte);
	}

	public void delete(Long rib) {
		compteDao.delete(getById(rib));
	}

	public Compte getById(Long rib) {
		return compteDao.getById(rib);
	}

	public List<Compte> getAll() {
		return compteDao.getAll();
	}

	public List<Compte> getAllByClient(Client client) {
		return compteDao.getAllByClient(client);
	}

}
