package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.LancamentoTipo;

public class Receita implements OperacaoI {

	private String id = LancamentoTipo.RECEITA.toString();
	private ContaService contaService;

	public Receita(ContaService contaService) {
		this.contaService = contaService;
	}

	@Override
	public Conta efetuarOperacao(Double valor, Integer... contasId) {
		Conta conta = contaService.findById(contasId[0]);
		conta.creditar(valor);
		return null;
	}

	@Override
	public String getId() {
		return id;
	}
}
