package br.com.thundercoders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ContaCorrente extends Conta {

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "numero")
	private String numero;

	@Column(name = "saldo")
	private Double saldo;

	public ContaCorrente() {
	}

	public ContaCorrente(Usuario usuario, String tipo, String numero, Double saldo) {
		super(usuario);
		this.tipo = tipo;
		this.numero = numero;
		this.saldo = saldo;
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

	@Override
	public Double getSaldo() {
		return saldo;
	}

	@Override
	public void debitar(Double valor) {
		this.saldo -= valor;
	}
	
	@Override
	public void creditar(Double valor) {
		this.saldo += valor;
	}
	
	@Override
	public void transferir(Double valor,Conta contaDestino) {
		this.debitar(valor);
		contaDestino.creditar(valor);
	}

	@Override
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
		
	}
}
