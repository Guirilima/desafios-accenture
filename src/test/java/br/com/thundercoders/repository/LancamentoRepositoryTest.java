package br.com.thundercoders.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
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
		Conta conta =  cRepository.save(new ContaCorrente(usuario, "CC", "2014", 200.0));
		Lancamento lancamento = repository
				.save(new Lancamento(conta, planoConta, 20.0, "Cerveja", LocalDateTime.now(), LancamentoTipo.DESPESA));
		assertEquals(1, lancamento.getId());
	}

}
