package br.edu.ifce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "cliente")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcliente;
	@Column(length = 80)
	private String nome;
	private LocalDate dtnascimento;
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Document documento;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "telefone_dos_clientes", joinColumns = @JoinColumn(name = "id_do_cliente"), inverseJoinColumns = @JoinColumn(name = "id_do_telefone"))
	private List<Phone> telefones = new ArrayList<>();
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "cliente_endereco", joinColumns = @JoinColumn(name = "cliente_idcliente"), inverseJoinColumns = @JoinColumn(name = "endereco_idendereco"))
	private List<Address> enderecos = new ArrayList<>();

	//get and set
	public Integer getIdcliente() { return idcliente; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public LocalDate getDtnascimento() { return dtnascimento; }
	public void setDtnascimento(LocalDate dtnascimento) { this.dtnascimento = dtnascimento; }
	public Document getDocumento() { return documento; }
	public void setDocumento(Document documento) { this.documento = documento; }
	public List<Phone> getTelefones() { return telefones; }
	public void setTelefones(List<Phone> telefones) { this.telefones = telefones; }
	public List<Address> getEnderecos() { return enderecos; }
	public void setEnderecos(List<Address> enderecos) { this.enderecos = enderecos; }

	@Override
	public String toString() {
		return "idcliente=" + idcliente + ", \nnome=" + nome + ", \ndtnascimento=" + dtnascimento + ", \ndocumento="
				+ documento + ", \ntelefones=" + telefones + ", \nenderecos=" + enderecos;
	}

}
