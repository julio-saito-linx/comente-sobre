package br.com.saitodisse.dao;

import java.util.List;

import br.com.saitodisse.model.Mensagem;

public interface MensagemDao {
	void salvar(Mensagem mensagem);
	Mensagem pesquisar(long id);
	List<Mensagem> pesquisarTodos();
	List<Mensagem> pesquisarPorUsuario(long usuarioId);
}
