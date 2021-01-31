package br.com.thundercoders.model;

public enum ContaTipo {
	CORRENTE(new ContaCorrente()), CONTACREDITO(new ContaCredito());

	private Conta conta;

	private ContaTipo(Conta conta) {
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}

}