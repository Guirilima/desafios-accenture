package br.com.thundercoders.model.dto;

public class DtoErro {

	private String campo;
	private String mensagem;

	public DtoErro(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}

}
