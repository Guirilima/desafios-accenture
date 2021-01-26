package br.com.thundercoders.service;

import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.repository.LancamentoRepository;

public class LancamentoService {

	private LancamentoRepository lancamentoRepository;

	public LancamentoService(LancamentoRepository lancamentoRepository) {
		this.lancamentoRepository = lancamentoRepository;
	}

	public Lancamento salvaLancamento(DtoLancamento dtoLancamento) {

		new Lancamento(conta, planoConta, dtoLancamento.getValor(), dtoLancamento.getDescricao(), dtoLancamento.getDataHora(), lancamentoTipo);
		this.lancamentoRepository.save(lancamento);
	}
}
