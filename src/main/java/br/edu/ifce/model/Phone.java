package br.edu.ifce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "telefone")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtelefone;
	@Column(length = 10)
	private String telefone;
	@ManyToMany(mappedBy = "telefones")
	private List<Client> clientes = new ArrayList<>();

	//get and set
	public Integer getIdtelefone() { return idtelefone; }
	public String getTelefone() { return telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }
	public List<Client> getClientes() { return clientes; }

	@Override
	public String toString() {
		return "Telefone cliente {idtelefone=" + idtelefone + ", telefone=" + telefone + "}";
	}

}
