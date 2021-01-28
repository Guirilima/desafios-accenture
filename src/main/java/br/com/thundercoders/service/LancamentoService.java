package br.com.thundercoders.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.repository.LancamentoRepository;
import br.com.thundercoders.repository.RepositoryImpl;

public class LancamentoService extends ServiceImpl<Lancamento> {

	private ContaService contaService;
	private PlanoContaService planoContaService;
	private LancamentoRepository lancamentoRepository;

	public LancamentoService(RepositoryImpl<Lancamento, Integer> lancamentoRepository, ContaService contaService,
			PlanoContaService planoContaService) {
		super(lancamentoRepository);
		this.contaService = contaService;
		this.planoContaService = planoContaService;
		this.lancamentoRepository = (LancamentoRepository) lancamentoRepository;
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
    //Método extrair lancamentos por idConta
    public List<Lancamento> extractByIdConta(Integer idConta) {

        return lancamentoRepository.findByIdConta(idConta);
    }

    //Método extrair por périodo e idConta
    public List<Lancamento> extractByPeriodAndIdConta(Integer idConta, LocalDateTime dataInicial, LocalDateTime dataFinal) {

        return lancamentoRepository.findByPeriod(idConta,dataInicial,dataFinal);
    }

    //Método extrair por périodo e idConta e salvar num arquivo .txt (Projeto futuro {SpringBoot}: html=>PDF e CSV/EXCEL)
    public void extractFileByPeriodAndIdConta(Integer idConta, LocalDateTime dataInicial, LocalDateTime dataFinal) {
        //Fazer a lógica de salvamento
        //Método static no Utils e Escrever
    }


}
