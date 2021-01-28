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

	@Override
	public void debitar(Double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creditar(Double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(Double valor,Conta contaDestino) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getSaldo() {
		// TODO Auto-generated method stub
		return null;
	}
}
