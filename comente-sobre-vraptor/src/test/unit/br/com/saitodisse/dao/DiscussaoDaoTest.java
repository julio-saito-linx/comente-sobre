package br.com.saitodisse.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.saitodisse.model.Discussao;
import br.com.saitodisse.model.Mensagem;
import br.com.saitodisse.model.Usuario;
import br.com.saitodisse.model.exceptions.MensagemInvalidaException;
import br.com.saitodisse.model.exceptions.NomeUsuarioInvalidoException;

public class DiscussaoDaoTest {
	private Session session;
	private DiscussaoDao dao;
	private UsuarioDao daoUsuario;
	private MensagemDao daoMensagem;
	private Usuario _usuarioInseridoUltimo;
	private Mensagem _mensagemInseridaUltima;

	@Test
	public void inserirPesquisar() throws Exception {
		Discussao discussaoInserida = new Discussao();

		// 1 pergunta
		discussaoInserida.setPergunta(_mensagemInseridaUltima);

		// 2 respostas
		discussaoInserida.addResposta(_mensagemInseridaUltima);
		discussaoInserida.addResposta(_mensagemInseridaUltima);

		dao.salvar(discussaoInserida);

		Discussao discussaoPesquisada = dao
				.pesquisar(discussaoInserida.getId());
		assertEquals(discussaoInserida, discussaoPesquisada);
	}

	@Test
	public void inserirCascade() throws Exception {
		Discussao discussaoInserida = new Discussao();

		// 1 pergunta
		discussaoInserida.setPergunta(new Mensagem("mensagem 1", _usuarioInseridoUltimo));

		// 2 respostas
		discussaoInserida.addResposta(new Mensagem("mensagem 2", _usuarioInseridoUltimo));
		discussaoInserida.addResposta(new Mensagem("mensagem 3", _usuarioInseridoUltimo));

		dao.salvar(discussaoInserida);

		Discussao discussaoPesquisada = dao.pesquisar(discussaoInserida.getId());
		assertEquals(discussaoInserida, discussaoPesquisada);
	}

	@Test
	public void pesquisarTodas() throws Exception {
		salvarDiscussao(
				"Joao", "pergunta 1",
				"Mario", "resposta 1.1",
				"Maria", "resposta 1.2"
				);

		salvarDiscussao(
				"Pedro", "pergunta 2",
				"Josefina", "resposta 2.1",
				"Gorda", "resposta 2.1"
				);

		salvarDiscussao(
				"Fabio", "pergunta 3",
				"Luis", "resposta 3.1",
				"Carolina", "resposta 3.2"
				);
		
		List<Discussao> todasDiscussoes = dao.pesquisarTodas();
		assertEquals(3, todasDiscussoes.size());
	}

	@Before
	public void setUp() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure().setProperty("hibernate.connection.url",
				"jdbc:hsqldb:mem:comenteDb");
		session = cfg.buildSessionFactory().openSession();
		session.beginTransaction();
		dao = new DefaultDiscussaoDao(session);

		getMensagemComUsuario("Rodrigo", "mensagem 1");
	}

	@After
	public void tearDown() throws Exception {
		if (session != null && session.getTransaction().isActive()) {
			session.getTransaction().rollback();
		}
	}

	private void salvarDiscussao(String nomePerguntador, String textoPergunta,
			String nomeRespondedor1, String resposta1, String nomeRespondedor2,
			String resposta2) throws NomeUsuarioInvalidoException,
			MensagemInvalidaException {
		Discussao _discussaoInserida = new Discussao();
		getMensagemComUsuario(nomePerguntador, textoPergunta);

		// 1 pergunta
		_discussaoInserida.setPergunta(_mensagemInseridaUltima);

		// 2 respostas
		getMensagemComUsuario(nomeRespondedor1, resposta1);
		_discussaoInserida.addResposta(_mensagemInseridaUltima);

		getMensagemComUsuario(nomeRespondedor2, resposta2);
		_discussaoInserida.addResposta(_mensagemInseridaUltima);

		dao.salvar(_discussaoInserida);
	}

	private void getMensagemComUsuario(String nomeUsuario, String textoMensagem)
			throws NomeUsuarioInvalidoException, MensagemInvalidaException {
		_usuarioInseridoUltimo = new Usuario(nomeUsuario);
		daoUsuario = new DefaultUsuarioDao(session);
		daoUsuario.salvar(_usuarioInseridoUltimo);

		_mensagemInseridaUltima = new Mensagem(textoMensagem,
				_usuarioInseridoUltimo);
		daoMensagem = new DefaultMensagemDao(session);
		daoMensagem.salvar(_mensagemInseridaUltima);
	}

}
