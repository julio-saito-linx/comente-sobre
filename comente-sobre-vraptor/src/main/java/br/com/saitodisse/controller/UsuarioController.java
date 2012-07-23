package br.com.saitodisse.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.saitodisse.dao.UsuarioDao;
import br.com.saitodisse.model.Usuario;
import br.com.saitodisse.model.UsuarioLogado;
import br.com.saitodisse.model.exceptions.NomeUsuarioInvalidoException;
import static br.com.caelum.vraptor.view.Results.*;

@Resource
public class UsuarioController {
	
	private final UsuarioDao _usuarioDao;
	private final Result _result;
	private UsuarioLogado _usuarioLogado;
	private Validator _validator;

	public UsuarioController(Validator validator, Result result, UsuarioDao usuarioDao, UsuarioLogado usuarioLogado) {
		_validator = validator;
		_result = result;
		_usuarioDao = usuarioDao;
		_usuarioLogado = usuarioLogado;
	}
	
	@Path("/usuario")
	public List<Usuario> lista(){
		return _usuarioDao.pesquisarTodos();
	}

	@Path("/usuario/{id}")
	public Usuario detalhe(Long id){
		return _usuarioDao.pesquisar(id);
	}

	@Path("/usuario/{id}/xml")
	public void detalheXml(Long id){
		Usuario usuario = _usuarioDao.pesquisar(id);
		_result.use(xml()).from(usuario).serialize();
	}
	@Path("/usuario/{id}/json")
	public void detalheJson(Long id){
		Usuario usuario = _usuarioDao.pesquisar(id);
		_result.use(json()).from(usuario).serialize();
	}

	@Get
	public void novo(){
	}

	@Post
	public void novo(String nome) throws NomeUsuarioInvalidoException{
		Usuario usu = new Usuario(nome);
		_usuarioDao.salvar(usu);
		_usuarioLogado.setUsuario(usu);
		_result.redirectTo(IndexController.class).index("");
	}
	
	@Get
	public void logon() {
		if(_usuarioLogado.getUsuario() != null){
			_result.include("usuarioLogado", _usuarioLogado);
		}
	}

	@Post
	public void logon(String nome) throws NomeUsuarioInvalidoException {
		Usuario usuario = _usuarioDao.pesquisarPorNome(nome);
		if(usuario != null){
			// usuário já existia previamente
			_usuarioLogado.setUsuario(usuario);
		}
		else{
			// cria novo usuário para este login
			try {
				usuario = new Usuario(nome);	
			} catch (NomeUsuarioInvalidoException e) {
				_validator.add(new ValidationMessage(e.getMessage(), "usuario"));
				_validator.onErrorUsePageOf(UsuarioController.class).logon();
				return;
			}
			
			_usuarioDao.salvar(usuario);
			_usuarioLogado.setUsuario(usuario);
		}
		_result.redirectTo(IndexController.class).index("");
	}
	
	@Get
	public void logout() {
		_usuarioLogado.setUsuario(null);
		_result.redirectTo(IndexController.class).index("");
	}	
}
