package br.edu.ifce.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.edu.ifce.model.Client;

public class ClienteDAO {
	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("TJW").createEntityManager();
	}

	public Client salvar(Client cliente) {
		getEntityManager().getTransaction().begin();
		cliente = getEntityManager().merge(cliente);
		getEntityManager().getTransaction().commit();
		return cliente;
	}

	public Client consultarPorId(Long id) { return getEntityManager().find(Client.class, id); }

	public void excluir(Client cliente) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(cliente);
		getEntityManager().getTransaction().commit();
	}

}
