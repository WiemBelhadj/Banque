package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.enis.dao.ClientDao;
import tn.enis.entity.Client;

@Stateless
@LocalBean
public class ClientService {
	@EJB
	private ClientDao clientDao;

	public void save(Client client) {
		clientDao.save(client);
	}

	public void update(Client client) {
		clientDao.update(client);
	}

	public void delete(String cin) {
		clientDao.delete(getById(cin));
	}

	public List<Client> getAll() {
		return clientDao.getAll();
	}

	public Client getById(String cin) {
		return clientDao.getById(cin);
	}

}
