package br.com.thundercoders.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
import br.com.thundercoders.model.ContaTipo;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.model.dto.DtoUsuario;
import br.com.thundercoders.repository.PlanoContaRepository;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
class LancamentoServiceTest {
	@Autowired
	private LancamentoService lancamentoService;
	@Autowired
	private ContaService contaService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PlanoContaRepository planoContaRepository;
	private Usuario usuario;
	private Conta conta;
	private PlanoConta planoConta;
	private Conta contaDestino;

	@BeforeAll
//	public void initialize() {
//		this.usuario = this.usuarioService.save(new Usuario("joao.pedro", "14587", "João Pedro", "45896578412"));
//		this.conta = contaService.save(new ContaCorrente(usuario, ContaTipo.CORRENTE.toString(), "4578", 300.0));
//		this.contaDestino = contaService.save(new ContaCorrente(usuario, ContaTipo.CORRENTE.toString(), "5000", 400.0));
//	}


	@Test
	@Order(1)
	void salvaLancamento() {

		planoConta = planoContaRepository.save(new PlanoConta(usuario, "Pagamento de salário"));
		Lancamento salvaLancamento = this.lancamentoService.salvaLancamento(
				new DtoLancamento(conta.getId(), 1, 100.0, "Teste", LocalDateTime.now(), LancamentoTipo.RECEITA));
		assertEquals(400, salvaLancamento.getConta().getSaldo());
		assertNotNull(salvaLancamento);
	}

	@Test
	@Order(2)
	void salvaLancamentoDespesa() {
		planoConta = planoContaRepository.save(new PlanoConta(usuario, "Alimentação"));

		Lancamento salvaLancamento = this.lancamentoService.salvaLancamento(new DtoLancamento(conta.getId(),
				planoConta.getId(), 50.0, "Almoço", LocalDateTime.now(), LancamentoTipo.DESPESA));
		assertNotNull(salvaLancamento);
		assertEquals(350.0, salvaLancamento.getConta().getSaldo());

	}

	@Test
	@Order(3)
	void salvaLancamentoTransferencia() {
		planoConta = planoContaRepository.save(new PlanoConta(usuario, "Alimentação"));

		Lancamento salvaLancamento = this.lancamentoService
				.salvaLancamento(new DtoLancamento(conta.getId(), contaDestino.getId(), planoConta.getId(), 50.0,
						"Almoço", LocalDateTime.now(), LancamentoTipo.TRANSFERENCIA));
		assertNotNull(salvaLancamento);
		assertEquals(300.0, salvaLancamento.getConta().getSaldo());
		assertEquals(450.0, salvaLancamento.getContaDestino().getSaldo());

	}
}
