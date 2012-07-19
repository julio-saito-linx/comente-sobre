package br.com.saitodisse.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.saitodisse.model.Usuario;

public class UsuarioDaoTest {
	private Session session;
	private UsuarioDao dao;

	@Test
	public void shouldFindAUsuarioWithSimilarTitle() throws Exception {
		Usuario usuario = new Usuario("Joao Mario");
		dao.add(usuario);
	}

	@Before
	public void setUp() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure().setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:comenteDb");
		session = cfg.buildSessionFactory().openSession();
		session.beginTransaction();
		dao = new DefaultUsuarioDao(session);
	}


	@After
	public void tearDown() throws Exception {
		if (session != null && session.getTransaction().isActive()) {
			session.getTransaction().rollback();
		}
	}
}
