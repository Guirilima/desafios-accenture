package br.com.thundercoders.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario extends EntidadeBase {

	@Column(name = "user", length = 20)
	private String login;

	@Column(name = "password", length = 100, nullable = false)
	private String senha;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 12, nullable = false)
	private String cpf;

	public Usuario() {
	}

	public Usuario(String login, String senha, String nome, String cpf) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Usuario that = (Usuario) o;
		return Objects.equals(login, that.login) && Objects.equals(senha, that.senha) && Objects.equals(nome, that.nome)
				&& Objects.equals(cpf, that.cpf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, senha, nome, cpf);
	}
}
