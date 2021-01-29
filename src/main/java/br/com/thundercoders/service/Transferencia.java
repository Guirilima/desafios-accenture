package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.LancamentoTipo;

public class Transferencia implements OperacaoI {

	private String id = LancamentoTipo.TRANSFERENCIA.toString();
	private Conta contaDestino;
	private ContaService contaService;

	public Transferencia(ContaService contaService) {
		this.contaService = contaService;
	}

	@Override
	public Conta efetuarOperacao(Double valor, Integer... contasId) {
		Conta conta = contaService.findById(contasId[0]);
		contaDestino = contaService.findById(contasId[1]);
		conta.debitar(valor);
		contaDestino.creditar(valor);
		return contaDestino;
	}

	@Override
	public String getId() {
		return id;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}
}
