package br.com.thundercoders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlanoConta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	private String descricao;
	
	public PlanoConta() {
		// TODO Auto-generated constructor stub
	}
	
	public PlanoConta(Usuario usuario, String descricao) {
		this.usuario = usuario;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
}
