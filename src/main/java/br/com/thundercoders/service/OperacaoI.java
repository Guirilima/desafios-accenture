package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;

public interface OperacaoI {

	public Conta efetuarOperacao(Double valor, Integer...contas);

	public void setService(ServiceI<Conta> service);
}
