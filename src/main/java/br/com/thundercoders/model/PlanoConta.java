package br.com.thundercoders.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_plano_conta")
public class PlanoConta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "usuario_id", foreignKey = @ForeignKey(name = "usuario_id_fk"), nullable = false)
	private Usuario usuario;
	@Enumerated(EnumType.STRING)
	private LancamentoTipo lancamentoTipo;
	private String descricao;

	public PlanoConta() {
	}

	public PlanoConta(Usuario usuario, LancamentoTipo lancamentoTipo, String descricao) {
		this.usuario = usuario;
		this.lancamentoTipo = lancamentoTipo;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public LancamentoTipo getLancamentoTipo() {
		return lancamentoTipo;
	}

	public String getDescricao() {
		return descricao;
	}

}
