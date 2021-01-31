package br.com.thundercoders.model.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class DtoLogin {

	private String login;
	private String senha;

	public DtoLogin(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public UsernamePasswordAuthenticationToken converte() {

		return new UsernamePasswordAuthenticationToken(login, senha);
	}

}
