package br.com.thundercoders.service;

import java.util.Optional;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.repository.ContaRepository;

public class ContaService {

	private ContaRepository contaRepository;

	public ContaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	public Conta findById(Integer id) {
		Optional<Conta> conta = Optional.of(contaRepository.findById(id));
		if (!conta.isPresent()) {
			throw new RuntimeException("Conta inexistente");
		}
		return conta.get();
	}
}
