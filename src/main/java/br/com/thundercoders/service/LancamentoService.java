package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.repository.LancamentoRepository;

public class LancamentoService {

	private LancamentoRepository lancamentoRepository;
	private ContaService contaService;
	private PlanoContaService planoContaService;

	public LancamentoService(LancamentoRepository lancamentoRepository,ContaService contaService,PlanoContaService planoContaService) {
		this.lancamentoRepository = lancamentoRepository;
		this.contaService = contaService;
		this.planoContaService = planoContaService;
	}

	public Lancamento salvaLancamento(DtoLancamento dtoLancamento) {
		Conta conta = contaService.findById(dtoLancamento.getContaId());
		PlanoConta planoConta = planoContaService.findById(dtoLancamento.getPlanoContaId());
		Lancamento lancamento = new Lancamento(conta, planoConta, dtoLancamento.getValor(), dtoLancamento.getDescricao(), dtoLancamento.getDataHora(), dtoLancamento.getLancamentoTipo());
		return this.lancamentoRepository.save(lancamento);
	}
}
