package br.com.saitodisse.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.saitodisse.dao.DiscussaoDao;
import br.com.saitodisse.dao.UsuarioDao;
import br.com.saitodisse.model.Discussao;
import br.com.saitodisse.model.UsuarioLogado;

@Resource
public class IndexController {

	private final Result _result;
	private final UsuarioLogado _usuarioLogado;
	private DiscussaoDao _discussaoDao;

	//FIXME: os controllers precisam de testes unitários
	public IndexController(Validator validator, Result result, UsuarioLogado usuarioLogado, UsuarioDao UsuarioDao, DiscussaoDao discussaoDao) {
		_result = result;
		_usuarioLogado = usuarioLogado;
		_discussaoDao = discussaoDao;
	}

	@Path("/")
	public List<Discussao> index() {
		if(_usuarioLogado.getUsuario() == null) {
			// usuário não está logado, vai para o login
			_result.redirectTo(UsuarioController.class).logon();
			return null;
		}
		
		// usuário logado: recebe a lista discussoes
		_result.include("usuarioLogado", _usuarioLogado);
		
		return _discussaoDao.pesquisarTodas();
	}
	
	@Get
	@Path("/{tituloAmigavel}")
	public void index(String tituloAmigavel) {
		if(_usuarioLogado.getUsuario() == null) {
			// usuário não está logado, vai para o login
			_result.redirectTo(UsuarioController.class).logon();
		}
		
		// usuário logado: recebe a lista discussoes
		_result.include("usuarioLogado", _usuarioLogado);
		
		if(tituloAmigavel.isEmpty()){
			_result.include("discussaoList", _discussaoDao.pesquisarTodas());
		}
		else{
			Discussao discussaoPesquisada = _discussaoDao.pesquisarPorTituloAmigavel(tituloAmigavel);
			if(discussaoPesquisada != null){
				// está recebendo uma url amigável
				_result.include("discussao", discussaoPesquisada);
				_result.of(DiscussaoController.class).detalhe(discussaoPesquisada.getId());
			}
		}
	}
}
