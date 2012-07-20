package br.com.saitodisse.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saitodisse.model.Discussao;

@Component
public class DefaultDiscussaoDao implements DiscussaoDao {

	private final Session session;

	public DefaultDiscussaoDao(Session session) {
		this.session = session;
	}

	public void salvar(Discussao discussao) {
		session.save(discussao);
	}

	public Discussao pesquisar(long id) {
	    Object o = session.load(Discussao.class, id);
	    return (Discussao)o;		
	}

	public List<Discussao> pesquisarTodas() {
	    Query queryResult = session.createQuery("from Discussao");
	    return queryResult.list();
	}

	public List<Discussao> pesquisarPerguntasPorUsuario(long usuarioId) {
		StringBuilder sb = new StringBuilder();
		sb.append("from Discussao d ");
		sb.append(" join d.pergunta mensagemPergunta");
		sb.append(" join mensagemPergunta.usuario usu");
		sb.append(" where usu.id = :usuarioId");
		
		String hqlQuery = sb.toString();
		Query queryResult = session.createQuery(hqlQuery);
		queryResult.setParameter("usuarioId", usuarioId);
		
	    return queryResult.list();
	}

	public List<Discussao> pesquisarRespostasPorUsuario(long usuarioId) {
		StringBuilder sb = new StringBuilder();
		sb.append("from Discussao d ");
		sb.append(" join d.respostas mensagensRespostas");
		sb.append(" join mensagensRespostas.usuario usu");
		sb.append(" where usu.id = :usuarioId");
		
		String hqlQuery = sb.toString();
		Query queryResult = session.createQuery(hqlQuery);
		queryResult.setParameter("usuarioId", usuarioId);
		
	    return queryResult.list();
	}

}
