package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;

public class Receita implements OperacaoI {

	private ContaService contaService;

	public Receita() {
	}

	@Override
	public Conta efetuarOperacao(Double valor, Integer... contasId) {
		Conta conta = contaService.findById(contasId[0]);
		conta.creditar(valor);
		return null;
	}

	@Override
	public void setService(ServiceI<Conta> repository) {
		this.contaService = (ContaService) repository;

	}
}
