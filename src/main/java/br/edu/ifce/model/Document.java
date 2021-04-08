package br.edu.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
public class Document {
	@Id
	private Integer id;
	@Column(length = 45)
	private String cpf;
	@Column(length = 45)
	private String rg;
	@OneToOne
    @MapsId
    @JoinColumn(name = "cliente_idcliente")
    private Client cliente;

	//get and set
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getCpf() { return cpf; }
	public void setCpf(String cpf) { this.cpf = cpf; }
	public String getRg() { return rg; }
	public void setRg(String rg) { this.rg = rg; }
	public Client getCliente() { return cliente; }
	public void setCliente(Client cliente) { this.cliente = cliente; }

	@Override
	public String toString() {
		return "Documento referente = { id=" + id + ", rg=" + rg + ", cpf=" + cpf + ", cliente=" + cliente + "}";
	}

	
}
