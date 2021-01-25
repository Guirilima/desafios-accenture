package br.com.thundercoders.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_contas")
@Embeddable
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

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
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
