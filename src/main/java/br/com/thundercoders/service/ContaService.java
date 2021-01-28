package br.com.thundercoders.service;

import java.util.Optional;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.repository.RepositoryImpl;

public class ContaService extends ServiceImpl<Conta> {

	public ContaService(RepositoryImpl<Conta, Integer> contaRepository) {

		super(contaRepository);
	}

	public Conta findById(Integer id) {
		Optional<Conta> conta = Optional.of(repository.findById(id));
		if (!conta.isPresent()) {
			throw new RuntimeException("Conta inexistente");
		}
		return conta.get();
	}
}
