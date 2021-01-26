package br.com.thundercoders.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_conta", referencedColumnName = "id")
	private Conta conta;

	@ManyToOne
	@JoinColumn(name = "id_plano_conta", referencedColumnName = "id")
	private PlanoConta planoConta;

	@Column(name = "valor")
	private Double valor;

	@Column(name = "descricao", length = 100)
	private String descricao;

	@Column(name = "data")
	private LocalDateTime dataHora;

	private LancamentoTipo lancamentoTipo;

	public Lancamento() {
	}	
	
	public Lancamento(Conta conta, PlanoConta planoConta, Double valor, String descricao, LocalDateTime dataHora,
			LancamentoTipo lancamentoTipo) {
		this.conta = conta;
		this.planoConta = planoConta;
		this.valor = valor;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.lancamentoTipo = lancamentoTipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public PlanoConta getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}

	public LancamentoTipo getLancamentoTipo() {
		return lancamentoTipo;
	}

}
