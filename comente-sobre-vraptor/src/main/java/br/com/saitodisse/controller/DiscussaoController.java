package br.com.saitodisse.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.validator.ValidationMessage;
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
	private Validator _validator;

	public DiscussaoController(Validator validator, DefaultDiscussaoDao defaultDiscussaoDao, UsuarioLogado usuarioLogado, Result result) {
		_validator = validator;
		_defaultDiscussaoDao = defaultDiscussaoDao;
		_usuarioLogado = usuarioLogado;
		_result = result;
	}

	@Get
	@Path("/discussao/{id}")
	public void detalhe(Long id){
		_result.include("discussao", _defaultDiscussaoDao.pesquisar(id));
	}

	@Post
	@Path("/discussao/{id}")
	public void detalhe(Long id, String resposta) throws MensagemInvalidaException{
		Discussao discussao = _defaultDiscussaoDao.pesquisar(id);
		Mensagem mensagemResposta = null;
		// verifica erros na criação da mensagem
		try {
			mensagemResposta = new Mensagem(resposta, _usuarioLogado.getUsuario());
		} catch (MensagemInvalidaException e) {
			_validator.add(new ValidationMessage(e.getMessage(), "mensagem"));
			_result.include("discussao", discussao);
			_validator.onErrorUsePageOf(DiscussaoController.class).detalhe(discussao.getId());
			return;
		}

		discussao.addResposta(mensagemResposta);
		_result.redirectTo(IndexController.class).index(discussao.getPergunta().getTituloAmigavel());
	}

	@Post
	public void novaPergunta(String titulo, String texto) throws MensagemInvalidaException{
		// cria uma nova discussão com uma pergunta (Mensagem com título)
		Mensagem mensagem = null;

		// verifica se o titulo foi preenchido
		if(titulo == null || titulo.trim().isEmpty()){
			_validator.add(new ValidationMessage("o título é obrigatório para se iniciar uma discussão", "mensagem"));
		}

		// verifica erros na criação da mensagem
		try {
			mensagem = new Mensagem(titulo, texto, _usuarioLogado.getUsuario());
		} catch (MensagemInvalidaException e) {
			_validator.add(new ValidationMessage(e.getMessage(), "mensagem"));
		}

		if(_validator.getErrors().size() > 0){
			_validator.onErrorUsePageOf(IndexController.class).index();
			return;
		}

		Discussao discussao = new Discussao();
		discussao.setPergunta(mensagem);
		_defaultDiscussaoDao.salvar(discussao);
		_result.redirectTo(IndexController.class).index(mensagem.getTituloAmigavel());
	}
}
