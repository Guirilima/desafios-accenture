package br.com.thundercoders.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class ContaCredito extends Conta {
	
	@Column(name = "numero_cartao")
	private String numeroCartao;

	@Column(name = "nome_impresso")
	private String nomeImpresso;

	@Column(name = "cvv")
	private String cvv;
	
	@Column(name = "limite")
	private Double limite;
	
	public ContaCredito() {
		// TODO Auto-generated constructor stub
	}

	public ContaCredito(Usuario usuario, String numeroCartao, String nomeImpresso, String cvv, Double limite) {
		super(usuario);
		this.numeroCartao = numeroCartao;
		this.nomeImpresso = nomeImpresso;
		this.cvv = cvv;
		this.limite = limite;
	}
}
