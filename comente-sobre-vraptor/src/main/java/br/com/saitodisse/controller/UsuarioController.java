package br.com.saitodisse.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
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

	public UsuarioController(Result result, UsuarioDao usuarioDao, UsuarioLogado usuarioLogado) {
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
		_result.redirectTo(IndexController.class).bemVindo();
	}
}
