package br.com.thundercoders.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoFactory {
	private static EntityManager em;

	public static EntityManager getConexao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MY_PU");
		em = emf.createEntityManager();
		return em;
	}
}
