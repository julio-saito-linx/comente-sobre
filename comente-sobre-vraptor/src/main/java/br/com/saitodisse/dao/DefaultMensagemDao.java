package br.com.saitodisse.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saitodisse.model.Mensagem;

@Component
public class DefaultMensagemDao implements MensagemDao {

	private final Session session;

	public DefaultMensagemDao(Session session) {
		this.session = session;
	}

	public void salvar(Mensagem mensagem) {
		session.save(mensagem);
	}

	public Mensagem pesquisar(long id) {
	    Object o = session.load(Mensagem.class, id);
	    return (Mensagem)o;		
	}

	public List<Mensagem> pesquisarTodos() {
	    Query queryResult = session.createQuery("from Mensagem");
	    return queryResult.list();
	}

	public List<Mensagem> pesquisarPorUsuario(long usuarioId) {
		StringBuilder sb = new StringBuilder();
		sb.append("from Mensagem m ");
		sb.append(" join m.usuario u");
		sb.append(" where u.id = :usuarioId");
		
		String hqlQuery = sb.toString();
		Query queryResult = session.createQuery(hqlQuery);
		queryResult.setParameter("usuarioId",usuarioId);
		
	    return queryResult.list();
	}
}
