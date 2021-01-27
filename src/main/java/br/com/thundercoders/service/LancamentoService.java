package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.repository.LancamentoRepository;

public class LancamentoService {

	private LancamentoRepository lancamentoRepository;
	private ContaService contaService;

	public LancamentoService(LancamentoRepository lancamentoRepository,ContaService contaService) {
		this.lancamentoRepository = lancamentoRepository;
	}

	public Lancamento salvaLancamento(DtoLancamento dtoLancamento) {
		Conta conta = contaService.findById(dtoLancamento.getContaId());
		Usuario usuario = conta.getUsuario();
		Lancamento lancamento = new Lancamento(conta, usuario.getConta(), dtoLancamento.getValor(), dtoLancamento.getDescricao(), dtoLancamento.getDataHora(), dtoLancamento.getLancamentoTipo());
		this.lancamentoRepository.save(lancamento);
	}
}
