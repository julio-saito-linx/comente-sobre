package br.com.saitodisse.controller;

import java.util.List;

import br.com.caelum.vraptor.*;
import br.com.saitodisse.dao.DefaultDiscussaoDao;
import br.com.saitodisse.model.Discussao;
import br.com.saitodisse.model.Mensagem;
import br.com.saitodisse.model.UsuarioLogado;
import br.com.saitodisse.model.exceptions.MensagemInvalidaException;

@Resource
public class DiscussaoController {

	private final DefaultDiscussaoDao _defaultDiscussaoDao;
	private final UsuarioLogado _usuarioLogado;
	private final Result _result;

	public DiscussaoController(DefaultDiscussaoDao defaultDiscussaoDao, UsuarioLogado usuarioLogado, Result result) {
		_defaultDiscussaoDao = defaultDiscussaoDao;
		_usuarioLogado = usuarioLogado;
		_result = result;
	}
	
	public List<Discussao> ultimas(){
		return _defaultDiscussaoDao.pesquisarTodas();
	}

	@Get
	@Path("/discussao/{id}")
	public Discussao detalhe(Long id){
		return _defaultDiscussaoDao.pesquisar(id);
	}

	@Post
	@Path("/discussao/{id}")
	public Discussao detalhe(Long id, String resposta) throws MensagemInvalidaException{
		Discussao discussao = _defaultDiscussaoDao.pesquisar(id);
		Mensagem mensagemResposta = new Mensagem(resposta, _usuarioLogado.getUsuario());
		discussao.addResposta(mensagemResposta);
		return _defaultDiscussaoDao.pesquisar(id);
	}

	@Get
	public void novaPergunta(){
	}

	@Post
	public void novaPergunta(String pergunta) throws MensagemInvalidaException{
		Mensagem mensagem = new Mensagem(pergunta, _usuarioLogado.getUsuario());
		Discussao discussao = new Discussao();
		discussao.setPergunta(mensagem);
		_defaultDiscussaoDao.salvar(discussao);
		_result.redirectTo(DiscussaoController.class).ultimas();
	}
}
