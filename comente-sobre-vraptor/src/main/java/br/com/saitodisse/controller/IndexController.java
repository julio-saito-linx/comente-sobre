package br.com.saitodisse.controller;

import static br.com.caelum.vraptor.view.Results.page;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.saitodisse.dao.DefaultUsuarioDao;
import br.com.saitodisse.model.Usuario;
import br.com.saitodisse.model.UsuarioLogado;

@Resource
public class IndexController {

	private final Result _result;
	private final UsuarioLogado _usuarioLogado;
	private final DefaultUsuarioDao _defaultUsuarioDao;

	public IndexController(Result result, UsuarioLogado usuarioLogado, DefaultUsuarioDao defaultUsuarioDao) {
		_result = result;
		_usuarioLogado = usuarioLogado;
		_defaultUsuarioDao = defaultUsuarioDao;
	}

	@Get
	@Path("/")
	public void index() {
		if(_usuarioLogado.getUsuario() != null){
			_result.use(page()).of(IndexController.class).bemVindo();
		}
	}

	@Post
	@Path("/")
	public void index(String nome) {
		Usuario usuario = _defaultUsuarioDao.pesquisarPorNome(nome);
		if(usuario != null){
			_usuarioLogado.setUsuario(usuario);
			_result.use(page()).of(IndexController.class).bemVindo();
			return;
		}
		else{
			_result.redirectTo(UsuarioController.class).novo();
		}
	}

	public void bemVindo() {
		_result.include("usuarioLogado", _usuarioLogado);
	}

}
