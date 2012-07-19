package br.com.saitodisse.dao;

import org.hibernate.Session;
import br.com.caelum.vraptor.ioc.Component;
import br.com.saitodisse.model.Usuario;

@Component
public class DefaultUsuarioDao implements UsuarioDao {

	// current hibernate session
	private final Session session;

	/**
	 * Creates a new UsuarioDao.
	 *
	 * @param session hibernate session.
	 */
	public DefaultUsuarioDao(Session session) {
		this.session = session;
	}

	public void add(Usuario usuario) {
		session.save(usuario);
	}
}
