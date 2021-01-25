package br.com.thundercoders.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_plano_contas")
public class PlanoConta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;
    
    @Column(name = "tipo", length = 14)
    private String tipo;

    @Column(name = "descricao", length = 100)
    private String descricao;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
