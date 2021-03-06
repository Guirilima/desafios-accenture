package br.com.thundercoders.model.dto;

import java.time.LocalDateTime;

import br.com.thundercoders.model.LancamentoTipo;

public class DtoLancamento {

	private Integer contaId;
	private Integer contaDestinoId;
	private Integer planoContaId;
	private Double valor;
	private String descricao;
	private LocalDateTime dataHora;
	private LancamentoTipo lancamentoTipo;
	
	public DtoLancamento() {
	}

	public DtoLancamento(Integer contaId, Integer planoContaId, Double valor, String descricao, LocalDateTime dataHora,
			LancamentoTipo lancamentoTipo) {
		this.contaId = contaId;
		this.planoContaId = planoContaId;
		this.valor = valor;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.lancamentoTipo = lancamentoTipo;
	}

	public DtoLancamento(Integer contaId, Integer contaDestinoId, Integer planoContaId, Double valor, String descricao,
			LocalDateTime dataHora, LancamentoTipo lancamentoTipo) {
		this.contaId = contaId;
		this.contaDestinoId = contaDestinoId;
		this.planoContaId = planoContaId;
		this.valor = valor;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.lancamentoTipo = lancamentoTipo;
	}

	public Integer getContaId() {
		return contaId;
	}

	public Integer getContaDestinoId() {
		return contaDestinoId;
	}

	public Integer getPlanoContaId() {
		return planoContaId;
	}

	public Double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public LancamentoTipo getLancamentoTipo() {
		return lancamentoTipo;
	}

}
