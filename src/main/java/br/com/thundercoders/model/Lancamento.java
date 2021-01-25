package br.com.thundercoders.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tab_lancamentos")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
	@OneToMany
	@JoinColumn(name = "id_conta", referencedColumnName = "id")
    private Conta conta;
    
	@OneToMany
	@JoinColumn(name = "id_plano_conta", referencedColumnName = "id")
    private PlanoConta planoConta;
    
    @Column(name = "valor")
    private Float valor;
    
    @Column(name = "id_conta_destino")
    private Integer idContaDestino;
    
    @Column(name = "descricao", length = 100)
    private String descricao;
    
    @Column(name = "data")
    private Date data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Integer getIdContaDestino() {
		return idContaDestino;
	}

	public void setIdContaDestino(Integer idContaDestino) {
		this.idContaDestino = idContaDestino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
}
