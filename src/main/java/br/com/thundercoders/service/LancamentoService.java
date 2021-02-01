package br.com.thundercoders.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.thundercoders.model.*;
import br.com.thundercoders.repository.ContaCorrenteRepository;
import br.com.thundercoders.repository.ContaCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.repository.LancamentoRepository;

@Service
public class LancamentoService {

	private ContaService contaService;
	private PlanoContaService planoContaService;
	private LancamentoRepository lancamentoRepository;
	private ContaCorrenteRepository contaCorrenteRepository;
	private ContaCreditoRepository contaCreditoRepository;

	@Autowired
	public LancamentoService(LancamentoRepository lancamentoRepository, ContaService contaService,
			PlanoContaService planoContaService,ContaCorrenteRepository contaCorrenteRepository, ContaCreditoRepository contaCreditoRepository) {
		this.contaService = contaService;
		this.planoContaService = planoContaService;
		this.lancamentoRepository = lancamentoRepository;
		this.contaCorrenteRepository = contaCorrenteRepository;
		this.contaCreditoRepository = contaCreditoRepository;

	}

	public Lancamento salvaLancamento(DtoLancamento dtoLancamento) {
		LancamentoTipo lancamentoTipo = dtoLancamento.getLancamentoTipo();
		Conta conta = contaService.findById(dtoLancamento.getContaId());
		PlanoConta planoConta = null;
		if (dtoLancamento.getPlanoContaId() != null) {

			planoConta = planoContaService.findById(dtoLancamento.getPlanoContaId());
		}
		Lancamento lancamento = new Lancamento(conta, planoConta, dtoLancamento.getValor(),
				dtoLancamento.getDescricao(), dtoLancamento.getDataHora(), dtoLancamento.getLancamentoTipo());

		lancamentoTipo.setService(contaService);
		;
		conta = lancamentoTipo.getOperacao().efetuarOperacao(dtoLancamento.getValor(), dtoLancamento.getContaId(),
				dtoLancamento.getContaDestinoId());
		lancamento.setContaDestino(conta);
		return lancamentoRepository.save(lancamento);
	}

	// Método extrair lancamentos por idConta
	public List<DtoLancamento> buscarLancamentoPorConta(Integer idConta) {

		 List<DtoLancamento> listDtoLancamentos = new ArrayList<>();

		for ( Lancamento lancamentoAtual : lancamentoRepository.findAllByContaId(idConta)) {

			listDtoLancamentos.add(new DtoLancamento(lancamentoAtual));

		}

		return listDtoLancamentos;
	}

	// Método extrair por périodo e idConta
	public List<DtoLancamento> buscarPorPeriodoEIdConta(Integer idConta, LocalDateTime dataInicial,
			LocalDateTime dataFinal) {

		List<DtoLancamento> listDtoLancamentos = new ArrayList<>();
		for ( Lancamento lancamentoAtual : lancamentoRepository.findAllByContaIdAndDataHoraBetween(idConta,dataInicial,dataFinal)) {

			listDtoLancamentos.add(new DtoLancamento(lancamentoAtual));

		}
		return listDtoLancamentos;
	}

	// Método extrair por périodo e idConta e salvar num arquivo .txt (Projeto
	// futuro {SpringBoot}: html=>PDF e CSV/EXCEL)
	public void extractFileByPeriodAndIdConta(Integer idConta, LocalDateTime dataInicial, LocalDateTime dataFinal) {
		// Fazer a lógica de salvamento
		// Método static no Utils e Escrever
	}

}
