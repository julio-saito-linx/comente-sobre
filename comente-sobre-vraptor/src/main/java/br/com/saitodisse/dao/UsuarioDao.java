package br.com.saitodisse.dao;

import br.com.saitodisse.model.Usuario;

/**
 * Data Access Object for the Usuario entity.
 *
 * @author Lucas Cavalcanti
 */
public interface UsuarioDao {

	/**
	 * Add a new usuario to the database.
	 *
	 * @param usuario
	 */
	void add(Usuario usuario);
}