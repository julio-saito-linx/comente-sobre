package br.com.saitodisse.dao;

import java.util.List;

import br.com.saitodisse.model.Discussao;

public interface DiscussaoDao {
	void salvar(Discussao discussao);
	Discussao pesquisar(long id);
	List<Discussao> pesquisarTodas();
	List<Discussao> pesquisarPerguntasPorUsuario(long usuarioId);
	List<Discussao> pesquisarRespostasPorUsuario(long usuarioId);
	Discussao pesquisarPorTituloAmigavel(String string);
}
