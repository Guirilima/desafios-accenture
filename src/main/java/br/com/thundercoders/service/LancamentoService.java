package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.repository.RepositoryImpl;

public class LancamentoService extends ServiceImpl<Lancamento> {

	private ContaService contaService;
	private PlanoContaService planoContaService;

	public LancamentoService(RepositoryImpl<Lancamento, Integer> lancamentoRepository, ContaService contaService,
			PlanoContaService planoContaService) {
		super(lancamentoRepository);
		this.contaService = contaService;
		this.planoContaService = planoContaService;
	}

	public Lancamento salvaLancamento(DtoLancamento dtoLancamento) {
		Conta conta = contaService.findById(dtoLancamento.getContaId());
		PlanoConta planoConta = planoContaService.findById(dtoLancamento.getPlanoContaId());

		if (dtoLancamento.getLancamentoTipo().equals(LancamentoTipo.DESPESA)) {
			conta.saca(dtoLancamento.getValor());
		}

		contaService.update(conta);
		System.out.println(conta.getSaldo());
		Lancamento lancamento = new Lancamento(conta, planoConta, dtoLancamento.getValor(),
				dtoLancamento.getDescricao(), dtoLancamento.getDataHora(), dtoLancamento.getLancamentoTipo());
		return repository.save(lancamento);
	}
}
