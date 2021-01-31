package br.com.thundercoders.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.thundercoders.model.PlanoConta;

public class DtoPlanoConta {

	@Min(1)
	private Integer usuarioId;

	@NotNull
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

	public DtoPlanoConta converter(PlanoConta planoConta) {
		return new DtoPlanoConta(planoConta.getUsuario().getId(), planoConta.getDescricao());
	}

}
