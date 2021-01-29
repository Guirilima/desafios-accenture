package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;

public class Despesa implements OperacaoI {

	private ContaService contaService;

	public Despesa() {
	}
	
	@Override
	public Conta efetuarOperacao(Double valor, Integer... contaId) {
		Conta conta  = contaService.findById(contaId[0]);
		conta.debitar(valor);
		return null;
	}

	@Override
	public void setService(ServiceI<Conta> service) {
		contaService = (ContaService) service;
	}


}
