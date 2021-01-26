package br.com.thundercoders.model;

import javax.persistence.*;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "numero")
	private String numero;

	@Column(name = "saldo")
	private Double saldo;
	
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}

	public Conta(Usuario usuario, String tipo, String numero, Double saldo) {
		this.usuario = usuario;
		this.tipo = tipo;
		this.numero = numero;
		this.saldo = saldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
