package model;

import javax.persistence.*;

@Entity
@Table(name = "tab_plano_contas")
public class PlanoConta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    
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

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
}
