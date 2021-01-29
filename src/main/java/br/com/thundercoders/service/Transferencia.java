package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;

public class Transferencia implements OperacaoI {

	private ContaService contaService;

	public Transferencia() {
	}

	@Override
	public Conta efetuarOperacao(Double valor, Integer... contasId) {
		Conta conta = contaService.findById(contasId[0]);
		Conta contaDestino = contaService.findById(contasId[1]);
		conta.debitar(valor);
		contaDestino.creditar(valor);
		return contaDestino;
	}

	@Override
	public void setService(ServiceI<Conta> service) {
		this.contaService = (ContaService) service;

	}
}
