package model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "tab_lancamentos")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Column(name = "id_conta", nullable = false)
    private Integer idConta;
    
    @Column(name = "id_plano_conta", nullable = false)
    private Integer idPlanoConta;
    
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

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public Integer getIdPlanoConta() {
		return idPlanoConta;
	}

	public void setIdPlanoConta(Integer idPlanoConta) {
		this.idPlanoConta = idPlanoConta;
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
}
