package br.com.thundercoders.service;

import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.repository.LancamentoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class LancamentoService {
    //Instanciando LancamentoRepository ao nosso Service
    LancamentoRepository lancamentoRepository = new LancamentoRepository();

    //Método salvar Lançamento


    //Método buscar um lançamento pelo idLancamento
    public Lancamento findById(Integer idLancamento) {

        return lancamentoRepository.findById(idLancamento);
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
