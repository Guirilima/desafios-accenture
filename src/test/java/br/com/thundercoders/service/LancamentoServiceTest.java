package br.com.thundercoders.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
import br.com.thundercoders.model.ContaTipo;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.repository.ContaRepository;
import br.com.thundercoders.repository.LancamentoRepository;
import br.com.thundercoders.repository.PlanoContaRepository;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.utils.ConexaoFactory;

class LancamentoServiceTest {
	private EntityManager em;
	private LancamentoService lancamentoService;
	private LancamentoRepository lancamentoRepository;
	private ContaService contaService;
	private PlanoContaService planoContaService;
	private ContaRepository contaRepository;
	private UsuarioService usuarioService;
	private PlanoContaRepository planoContaRepository;
	private UsuarioRepository usuarioRepository;
	private Usuario usuario;

	@BeforeEach
	public void initialize() {
		this.em = ConexaoFactory.getConexao();
		this.contaRepository = new ContaRepository(em);
		this.usuarioRepository = new UsuarioRepository(em);
		this.planoContaRepository = new PlanoContaRepository(em);
		this.lancamentoRepository = new LancamentoRepository(em);

		this.usuarioService = new UsuarioService(usuarioRepository);
		this.contaService = new ContaService(contaRepository);
		this.planoContaService = new PlanoContaService(usuarioService, planoContaRepository);
		lancamentoService = new LancamentoService(lancamentoRepository, contaService, planoContaService);
		this.usuario = this.usuarioService.save(new Usuario("joao.pedro", "14587", "João Pedro", "45896578412"));
	}

	@Test
	void salvaLancamento() {

		Lancamento salvaLancamento = this.lancamentoService
				.salvaLancamento(new DtoLancamento(1, 1, 100.0, "Teste", LocalDateTime.now(), LancamentoTipo.RECEITA));
		assertNotNull(salvaLancamento);
	}

	@Test
	void salvaLancamentoDespesa() {
		Conta conta = contaService.save(new ContaCorrente(usuario, ContaTipo.CORRENTE.toString(), "4578", 300.0));

		Lancamento salvaLancamento = this.lancamentoService.salvaLancamento(
				new DtoLancamento(conta.getId(), 1, 100.0, "Teste", LocalDateTime.now(), LancamentoTipo.RECEITA));
		Conta contaSalva = contaService.findById(conta.getId());
		assertNotNull(salvaLancamento);
		assertEquals(200.0, salvaLancamento.getConta().getSaldo());

	}
}
