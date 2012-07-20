package br.com.saitodisse.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.saitodisse.model.Usuario;

public class UsuarioDaoTest {
	private Session session;
	private UsuarioDao dao;

	@Test
	public void inserirPesquisar() throws Exception {
		Usuario usuarioInserido = new Usuario("Joao Mario");
		dao.salvar(usuarioInserido);

		Usuario usuarioPesquisado = dao.pesquisar(usuarioInserido.getId());
		assertEquals("Joao Mario", usuarioPesquisado.getNome());
	}

	@Test
	public void pesquisarTodos() throws Exception {
		dao.salvar(new Usuario("Joao 1"));
		dao.salvar(new Usuario("Joao 2"));
		dao.salvar(new Usuario("Joao 3"));

		List<Usuario> todosUsuarios = dao.pesquisarTodos();
		assertEquals(3, todosUsuarios.size());
	}

	@Test
	public void pesquisarPorNome() throws Exception {
		dao.salvar(new Usuario("Mario"));
		dao.salvar(new Usuario("Luis"));
		dao.salvar(new Usuario("Antonio"));

		Usuario usuarioMario = dao.pesquisarPorNome("Mario");
		assertEquals("Mario", usuarioMario.getNome());
	}

	@Test
	public void pesquisarPorNomeInexistenteRetornaNull() throws Exception {
		dao.salvar(new Usuario("Mario"));
		dao.salvar(new Usuario("Luis"));
		dao.salvar(new Usuario("Antonio"));
		assertNull(dao.pesquisarPorNome("Evandro"));
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
