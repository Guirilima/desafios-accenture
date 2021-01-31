package br.com.thundercoders.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.thundercoders.model.Lancamento;

public interface LancamentoRepository extends CrudRepository<Lancamento, Integer> {

	public List<Lancamento> findAllByContaId(Integer id);

	public List<Lancamento> findAllByContaIdAndDataHoraBetween(Integer idConta, LocalDateTime dataInicial,
			LocalDateTime dataFinal);
}
