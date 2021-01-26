package br.com.thundercoders.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "conta_id", referencedColumnName = "id")
	private Conta conta;

	@ManyToOne
	@JoinColumn(name = "plano_conta_id")
	private PlanoConta planoConta;

	private Double valor;
	private String descricao;
	@Enumerated(EnumType.STRING)

	private LancamentoTipo lancamentoTipo;
	private LocalDate data;

	public Lancamento() {
		// TODO Auto-generated constructor stub
	}

	public Lancamento(Conta conta, PlanoConta planoConta, Double valor, String descricao, LancamentoTipo lancamentoTipo,
			LocalDate data) {
		this.conta = conta;
		this.planoConta = planoConta;
		this.valor = valor;
		this.descricao = descricao;
		this.lancamentoTipo = lancamentoTipo;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public Conta getConta() {
		return conta;
	}

	public PlanoConta getPlanoConta() {
		return planoConta;
	}

	public Double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public LancamentoTipo getLancamentoTipo() {
		return lancamentoTipo;
	}

	public LocalDate getData() {
		return data;
	}

}
