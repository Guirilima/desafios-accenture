package br.com.thundercoders.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperacaoService {

	List<OperacaoI> operacores;
	

	public OperacaoService(ContaService contaService) {
		operacores = new ArrayList<OperacaoI>(Arrays.asList(new Despesa(contaService), new Receita(contaService),new Transferencia(contaService)));
	}

	public OperacaoI getById(String operacaoTipo) {
		return operacores.stream().filter(o -> o.getId().equals(operacaoTipo)).findFirst()
				.orElseThrow(() -> new RuntimeException("Operação inexistente "+operacaoTipo));
	}
}
