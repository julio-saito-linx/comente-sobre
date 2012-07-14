package br.com.saitodisse.model;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.saitodisse.model.exceptions.MensagemInvalidaException;
import br.com.saitodisse.model.exceptions.NomeUsuarioInvalidoException;

/*	
 * entidade Mensagem
 * ------------------
 * Uma mensagem sempre está associada a um usuário
 * 
 * */
public class Mensagem {
	@Id
	@GeneratedValue
	private Long id;
	
	private Usuario usuario;
	
	private Calendar data;
	
	private String texto;

	public Mensagem(String texto, Usuario usuario) throws MensagemInvalidaException {
		if(texto.length() == 0){
			throw new MensagemInvalidaException("A mensagem nao pode ser vazia");
		}
		if(usuario == null){
			throw new MensagemInvalidaException("A mensagem deve estar associada a um usuario");
		}

		this.setTexto(texto);
		this.setUsuario(usuario);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}

	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Mensagem other = (Mensagem) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
