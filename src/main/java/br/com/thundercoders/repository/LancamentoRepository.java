package br.com.thundercoders.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import br.com.thundercoders.model.Lancamento;

public class LancamentoRepository extends RepositoryImpl<Lancamento, Integer> {

	public LancamentoRepository(EntityManager em) {
		super(em);
	}

	@Override
	public Lancamento save(Lancamento entity) {
		em.getTransaction().begin();
		Lancamento lancamento = em.merge(entity);
		em.getTransaction().commit();
		return lancamento;
	}

	@Override
	public void update(Lancamento entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	@Override
	public List<Lancamento> findAll() {

		return em.createQuery("Select l from Lancamento l", Lancamento.class).getResultList();
	}

	@Override
	public Lancamento findById(Integer id) {
		return em.find(Lancamento.class, id);
	}

	// Irá buscar todos os lançamentos encontrado pelo idConta informado
	public List<Lancamento> findByIdConta(Integer idConta) {
		TypedQuery<Lancamento> query = em.createQuery("Select l from Lancamento l where l.conta.id = :idConta",
				Lancamento.class);

		query.setParameter("idConta", idConta);

		return (List<Lancamento>) query.getResultList();
	}

	// Irá buscar todos os lançamentos encontrado pelo idConta e Periodo informado
	public List<Lancamento> findByPeriod(Integer idConta, LocalDateTime dataInicial, LocalDateTime dataFinal) {

		TypedQuery<Lancamento> query = em.createQuery("Select l from Lancamento l where l.conta.id = :idConta "
				+ "and l.dataHora between :dataInicial and :dataFinal", Lancamento.class);

		query.setParameter("idConta", idConta);
		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);

		List<Lancamento> listLncamentoBD = new ArrayList<>();
		try {
			listLncamentoBD = (List<Lancamento>) query.getResultList();
		} catch (NoResultException | NonUniqueResultException nre) {
			throw new RuntimeException("Nenhum lancamento encontrado"); // Ajustar futuramente, pois retorno 0 não é um
																		// erro || e Criar uma Exception personalizada
																		// ao invês do RuntimeException
		}
		return listLncamentoBD;
	}

}
