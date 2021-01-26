package br.com.thundercoders.model.dto;

public class DtoPlanoConta {

	private Integer usuarioId;

	private String descricao;

	public DtoPlanoConta(Integer usuarioId, String descricao) {
		this.usuarioId = usuarioId;
		this.descricao = descricao;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public String getDescricao() {
		return descricao;
	}

}
