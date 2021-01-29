package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.LancamentoTipo;

public class Despesa implements OperacaoI {

	private String id = LancamentoTipo.DESPESA.toString();
	private ContaService contaService;

	public Despesa(ContaService contaService) {
		this.contaService = contaService;
	}

	@Override
	public Conta efetuarOperacao(Double valor, Integer... contaId) {
		Conta conta  = contaService.findById(contaId[0]);
		conta.debitar(valor);
		return null;
	}

	@Override
	public String getId() {
		return id;
	}
}
