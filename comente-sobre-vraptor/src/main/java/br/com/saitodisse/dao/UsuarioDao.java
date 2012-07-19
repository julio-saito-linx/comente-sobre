package br.com.saitodisse.dao;

import java.util.List;

import br.com.saitodisse.model.Usuario;

/**
 * Data Access Object for the Usuario entity.
 *
 * @author Lucas Cavalcanti
 */
public interface UsuarioDao {
	void salvar(Usuario usuario);
	Usuario pesquisar(long id);
	List<Usuario> pesquisarTodos();
	Usuario pesquisarPorNome(String nome);
}