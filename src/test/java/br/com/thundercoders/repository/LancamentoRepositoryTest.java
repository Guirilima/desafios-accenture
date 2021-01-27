package br.com.thundercoders.repository;

import static java.util.Objects.nonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.utils.ConexaoFactory;

public class LancamentoRepositoryTest {

	private LancamentoRepository repository;
	private UsuarioRepository uRepository;
	private PlanoContaRepository pRepository;
	private ContaRepository cRepository;
	private EntityManager em;

	@BeforeEach
	public void initialize() {
		this.em = ConexaoFactory.getConexao();
		this.repository = new LancamentoRepository(em);
		this.pRepository = new PlanoContaRepository(em);
		this.uRepository = new UsuarioRepository(em);
		this.cRepository = new ContaRepository(em);
	}

	@Test
	public void salvaLancamentoTest() {
		Usuario usuario = uRepository.save(new Usuario("franklin-barreto2", "12345", "Franklin Barreto", "12345678910"));
		PlanoConta planoConta = pRepository.save(new PlanoConta(usuario, "Farra"));
		Conta conta =  cRepository.save(new Conta(usuario, "CC", "2014", 200.0));
		Lancamento lancamento = repository
				.save(new Lancamento(conta, planoConta, 20.0, "Cerveja", LocalDateTime.now(), LancamentoTipo.DEBITO));
		assertEquals(1, lancamento.getId());
	}

	@Test
	public void buscarLancamentoTest() {

		Lancamento lancamento = repository.findById(1);
		assertTrue( nonNull(lancamento) );
	}

	@Test
	public void buscarLancamentosPorIdContaTest() {

		List<Lancamento> lancamentos = repository.findByIdConta(3);

		for (Lancamento l : lancamentos) {
			System.out.println(String.format("ID: %d , VALOR: %.2f , DESCRIÇÂO: %s",l.getId(),l.getValor(),l.getDescricao()));
		}

		assertTrue( lancamentos.size() > 0 );
	}

	@Test
	public void buscarLancamentosPorPeriodoEidContaTest() {

		List<Lancamento> lancamentos = repository.findByPeriod(3,
				LocalDateTime.of(2020,1,1,00,00),	//Data Inicio
				LocalDateTime.of(2020,1,13,00,00));//Data Final

		for (Lancamento l : lancamentos) {
			System.out.println(String.format("ID: %d , VALOR: %.2f , DESCRIÇÂO: %s",l.getId(),l.getValor(),l.getDescricao()));
		}

		assertTrue( lancamentos.size() > 0 );
	}

}
