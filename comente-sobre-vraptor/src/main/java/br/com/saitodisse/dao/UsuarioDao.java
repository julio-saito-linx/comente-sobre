package br.com.saitodisse.dao;

import java.util.List;

import br.com.saitodisse.model.Usuario;

public interface UsuarioDao {
	void salvar(Usuario usuario);
	Usuario pesquisar(long id);
	List<Usuario> pesquisarTodos();
	Usuario pesquisarPorNome(String nome);
}