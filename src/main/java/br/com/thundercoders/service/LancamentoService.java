package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.Lancamento;
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
		Lancamento lancamento = new Lancamento(conta, planoConta, dtoLancamento.getValor(),
				dtoLancamento.getDescricao(), dtoLancamento.getDataHora(), dtoLancamento.getLancamentoTipo());

		switch (dtoLancamento.getLancamentoTipo()) {
		case DESPESA:
			conta.debitar(dtoLancamento.getValor());
			break;
		case RECEITA:
			conta.creditar(dtoLancamento.getValor());
			break;
		case TRANSFERENCIA:
			Conta contaDestino = contaService.findById(dtoLancamento.getContaDestinoId());
			conta.transferir(dtoLancamento.getValor(), contaDestino);
			contaService.update(contaDestino);
			lancamento.setContaDestino(contaDestino);
			break;
		}

		contaService.update(conta);
		return repository.save(lancamento);
	}
}
