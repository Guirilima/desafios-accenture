package br.com.thundercoders.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Conta extends EntidadeBase {

	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}
	
	public Conta(Usuario usuario) {
		this.usuario = usuario;
	}
}
