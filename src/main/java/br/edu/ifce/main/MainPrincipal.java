package br.edu.ifce.main;

import java.io.IOException;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import br.edu.ifce.dao.ClienteDAO;
import br.edu.ifce.model.Client;
import br.edu.ifce.model.Address;
import br.edu.ifce.model.Phone;

public class MainPrincipal {
	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("TJW").createEntityManager();
	}

	public static void main(String args[]) throws IOException {
		getEntityManager().getTransaction().begin();

		//criando telefone
		Phone phone = new Phone();
		phone.setTelefone("999999999");
		getEntityManager().persist(phone);
		
		//criando endereço1
		Address addr1 = new Address();
		addr1.setLogradouro("Rua João XXIII");
		addr1.setCep("61661180");
		addr1.setNumero("2200");
		addr1.setCidade("Fortaleza");
		addr1.setEstado("CE");
		addr1.setEnderecocol("$$$");
		getEntityManager().persist(addr1);

		//criando endereço2
		Address addr2 = new Address();
		addr2.setLogradouro("Rua 5333");
		addr2.setCep("60160230");
		addr2.setNumero("2134");
		addr2.setCidade("Fortaleza");
		addr2.setEstado("CE");
		addr2.setEnderecocol("$$$");
		getEntityManager().persist(addr2);

		getEntityManager().getTransaction().commit();
		
		//criando cliente
		Client cliente = new Client();
		cliente.setNome("Marllon Sóstenes");
		cliente.setDtnascimento(LocalDate.of(1995, 9, 18));
		cliente.getEnderecos().add(addr1);
		cliente.getEnderecos().add(addr2);
		cliente.getTelefones().add(phone);
		
		ClienteDAO clienteDao = new ClienteDAO();
		cliente = clienteDao.salvar(cliente);
		System.out.println("\n\n** Os Dados do Cliente Serão Listados Abaixo**");
		System.out.println(cliente);
	}

}
