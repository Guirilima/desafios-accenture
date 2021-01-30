package br.com.thundercoders.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conta extends EntidadeBase {

	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;
	
	public Conta() {
	}
	
	public Conta(Usuario usuario) {
		this.usuario = usuario;
	}

	public abstract void debitar(Double valor);
	public abstract void creditar(Double valor);
	public abstract void transferir(Double valor, Conta contaDestino);
	
	public abstract Double getSaldo();
}
