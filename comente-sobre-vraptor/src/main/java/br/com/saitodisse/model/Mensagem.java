package br.com.saitodisse.model;

import java.beans.ConstructorProperties;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.saitodisse.model.exceptions.MensagemInvalidaException;
import br.com.saitodisse.util.StringWebUtil;

/*	
 * entidade Mensagem
 * ------------------
 * Uma mensagem sempre está associada a um usuário
 * 
 * */
@Entity
public class Mensagem {
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Usuario usuario;

	private Date data;

	private String titulo;

	private String tituloAmigavel;

	private String texto;

	public Mensagem() {
	}

	public Mensagem(String texto, Usuario usuario) throws MensagemInvalidaException {
		inicializar("", texto, usuario);
	}

	@ConstructorProperties(value = { "" })
	public Mensagem(String titulo, String texto, Usuario usuario) throws MensagemInvalidaException {
		inicializar(titulo, texto, usuario);
	}

	private void inicializar(String titulo, String texto, Usuario usuario)
			throws MensagemInvalidaException {
		if(texto == null || texto.length() == 0){
			throw new MensagemInvalidaException("O texto é obrigatório");
		}
		if(usuario == null){
			throw new MensagemInvalidaException("A mensagem deve estar associada a um usuario");
		}

		this.setTitulo(titulo);
		if(this.getTitulo() != null){
			this.setTituloAmigavel(converterTitulo());
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	private String converterTitulo() {
		return StringWebUtil.converterParaUrlAmigavel(getTitulo());
	}

	public String getTituloAmigavel() {
		return tituloAmigavel;
	}

	public void setTituloAmigavel(String tituloAmigavel) {
		this.tituloAmigavel = tituloAmigavel;
	}

}
