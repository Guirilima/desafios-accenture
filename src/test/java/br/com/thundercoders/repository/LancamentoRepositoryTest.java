package br.com.thundercoders.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.utils.ConexaoFactory;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class LancamentoRepositoryTest {

	private LancamentoRepository repository;
	private UsuarioRepository uRepository;
	private PlanoContaRepository pRepository;
	private ContaRepository cRepository;
	private EntityManager em;
	private Usuario usuario;
	private Conta conta;

	@BeforeAll
	public void initialize() {
		this.em = ConexaoFactory.getConexao();
		this.repository = new LancamentoRepository(em);
		this.pRepository = new PlanoContaRepository(em);
		this.uRepository = new UsuarioRepository(em);
		this.cRepository = new ContaRepository(em);
		this.usuario = uRepository.save(new Usuario("franklin-barreto2", "12345", "Franklin Barreto", "12345678910"));
		this.conta = cRepository.save(new ContaCorrente(usuario, "CC", "2014", 200.0));
	}

	@Test
	@Order(1)
	public void salvaLancamentoTest() {
		PlanoConta planoConta = pRepository.save(new PlanoConta(usuario, "Farra"));
		Lancamento lancamento = repository.save(new Lancamento(conta, planoConta, 20.0, "Cerveja",
				LocalDateTime.of(2020, 1, 1, 00, 00), LancamentoTipo.DESPESA));
		assertEquals(1, lancamento.getId());
	}

	@Test
	@Order(2)
	public void buscarLancamentoTest() {

		Lancamento lancamento = repository.findById(1);
		assertNotNull(lancamento);
	}

	@Test
	@Order(3)
	public void buscarLancamentosPorIdContaTest() {

		List<Lancamento> lancamentos = repository.findByIdConta(conta.getId());

		assertTrue(lancamentos.size() > 0);
	}

	@Test
	@Order(4)
	public void buscarLancamentosPorPeriodoEidContaTest() {

		List<Lancamento> lancamentos = repository.findByPeriod(conta.getId(), LocalDateTime.of(2020, 1, 1, 00, 00), // Data
																													// Inicio
				LocalDateTime.of(2020, 1, 13, 00, 00));// Data Final

		assertTrue(lancamentos.size() > 0);
	}

}
