package br.com.saitodisse.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.saitodisse.model.Mensagem;
import br.com.saitodisse.model.Usuario;

public class MensagemDaoTest {
	private Session session;
	private MensagemDao dao;
	private UsuarioDao daoUsuario;
	private Usuario _usuarioInserido;

	@Test
	public void inserirPesquisar() throws Exception {
		Mensagem mensagemInserida = new Mensagem("mensagem 1", _usuarioInserido);
		dao.salvar(mensagemInserida);

		Mensagem mensagemPesquisada = dao.pesquisar(mensagemInserida.getId());
		assertEquals(mensagemInserida, mensagemPesquisada);
	}

	@Test
	public void pesquisarTodas() throws Exception {
		dao.salvar(new Mensagem("Mensagem 1", _usuarioInserido));
		dao.salvar(new Mensagem("Mensagem 2", _usuarioInserido));
		dao.salvar(new Mensagem("Mensagem 3", _usuarioInserido));

		List<Mensagem> todasMensagems = dao.pesquisarTodos();
		assertEquals(3, todasMensagems.size());
	}

	@Test
	public void pesquisarPorUsuario() throws Exception {
		dao.salvar(new Mensagem("Mensagem 1", _usuarioInserido));
		dao.salvar(new Mensagem("Mensagem 2", _usuarioInserido));
		dao.salvar(new Mensagem("Mensagem 3", _usuarioInserido));

		List<Mensagem> mensagensRetornadas = dao.pesquisarPorUsuario(_usuarioInserido.getId());
		assertEquals(3, mensagensRetornadas.size());
	}

	@Before
	public void setUp() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure().setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:comenteDb");
		session = cfg.buildSessionFactory().openSession();
		session.beginTransaction();
		dao = new DefaultMensagemDao(session);
		
		_usuarioInserido = new  Usuario("Rodrigo");
		daoUsuario = new DefaultUsuarioDao(session);
		daoUsuario.salvar(_usuarioInserido);
		
	}


	@After
	public void tearDown() throws Exception {
		if (session != null && session.getTransaction().isActive()) {
			session.getTransaction().rollback();
		}
	}
}
