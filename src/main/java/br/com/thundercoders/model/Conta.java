package br.com.thundercoders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "conta_numero")
	private String numeroConta;

	@Column(name = "conta_saldo")
	private Double saldo;

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public boolean deposita(Double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("O valor não pode ser negativo");
		}
		saldo += valor;
		return true;
	}

	public boolean saca(Double valor) {
		if (saldo < valor) {
			throw new RuntimeException("Valor de saque maior que saldo");
		}
		saldo -= valor;
		return true;
	}

	public void transfere(Double valor, Conta contaDestino) {
		saca(valor);
		contaDestino.deposita(valor);
	}

}
