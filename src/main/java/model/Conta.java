package model;

import javax.persistence.*;

@Entity
@Table(name = "tab_contas")
@Embeddable
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "tipo", length = 8)
    private String tipo;

    @Column(name = "saldo")
    private Float saldo;

    @Column(name = "num_cartao_credito")
    private String numCartaoCredito;
    
    @Column(name = "nome_cartao_credito")
    private String nomeCartaoCredito;
    
    @Column(name = "sigla_cartao_credito")
    private String siglaCartaoCredito;

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

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public String getNumCartaoCredito() {
		return numCartaoCredito;
	}

	public void setNumCartaoCredito(String numCartaoCredito) {
		this.numCartaoCredito = numCartaoCredito;
	}

	public String getNomeCartaoCredito() {
		return nomeCartaoCredito;
	}

	public void setNomeCartaoCredito(String nomeCartaoCredito) {
		this.nomeCartaoCredito = nomeCartaoCredito;
	}

	public String getSiglaCartaoCredito() {
		return siglaCartaoCredito;
	}

	public void setSiglaCartaoCredito(String siglaCartaoCredito) {
		this.siglaCartaoCredito = siglaCartaoCredito;
	}
}
