package br.com.thundercoders.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.repository.LancamentoRepository;

@Service
public class LancamentoService{

	private ContaService contaService;
	private PlanoContaService planoContaService;
	private LancamentoRepository lancamentoRepository;

	@Autowired
	public LancamentoService(LancamentoRepository lancamentoRepository, ContaService contaService,
			PlanoContaService planoContaService) {
		this.contaService = contaService;
		this.planoContaService = planoContaService;
		this.lancamentoRepository = lancamentoRepository;
	}
	
	public Lancamento salvaLancamento(DtoLancamento dtoLancamento) {
		LancamentoTipo lancamentoTipo = dtoLancamento.getLancamentoTipo();
		Conta conta = contaService.findById(dtoLancamento.getContaId());
		PlanoConta planoConta = planoContaService.findById(dtoLancamento.getPlanoContaId());
		Lancamento lancamento = new Lancamento(conta, planoConta, dtoLancamento.getValor(),
				dtoLancamento.getDescricao(), dtoLancamento.getDataHora(), dtoLancamento.getLancamentoTipo());
		
		lancamentoTipo.setService(contaService);;
		conta = lancamentoTipo.getOperacao().efetuarOperacao(dtoLancamento.getValor(),
				dtoLancamento.getContaId(), dtoLancamento.getContaDestinoId());
		lancamento.setContaDestino(conta);
		return lancamentoRepository.save(lancamento);
	}

	// Método extrair lancamentos por idConta
	public List<Lancamento> extractByIdConta(Integer idConta) {

		return lancamentoRepository.findAllByContaId(idConta);
	}

	// Método extrair por périodo e idConta
	public List<Lancamento> extractByPeriodAndIdConta(Integer idConta, LocalDateTime dataInicial,
			LocalDateTime dataFinal) {

		return lancamentoRepository.findAllByContaIdAndDataHoraBetween(idConta, dataInicial, dataFinal);
	}

	// Método extrair por périodo e idConta e salvar num arquivo .txt (Projeto
	// futuro {SpringBoot}: html=>PDF e CSV/EXCEL)
	public void extractFileByPeriodAndIdConta(Integer idConta, LocalDateTime dataInicial, LocalDateTime dataFinal) {
		// Fazer a lógica de salvamento
		// Método static no Utils e Escrever
	}

}
