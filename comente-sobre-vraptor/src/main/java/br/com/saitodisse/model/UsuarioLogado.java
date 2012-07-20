package br.com.saitodisse.model;

import java.util.Date;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioLogado {
	
	public UsuarioLogado() {
		dataLogon = new Date();
	}
	
	private Usuario usuario;
	private Date dataLogon;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataLogon() {
		return dataLogon;
	}
}
