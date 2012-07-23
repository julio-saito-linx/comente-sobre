package br.com.saitodisse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.saitodisse.model.exceptions.NomeUsuarioInvalidoException;

/*	
 * entidade Usuario
 * ------------------
 * O usuário possui um nome
 * Representa alguém que pode fazer perguntas e também responder
 * 
 * */
@Entity
public class Usuario {
	public Usuario() {
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	//FIXME: isso não é seguro, o ideal seria se ter uma senha
	public Usuario(String nome) throws NomeUsuarioInvalidoException {
		if(nome == null || nome.isEmpty()){
			throw new NomeUsuarioInvalidoException("O nome do usuário não pode ser vazio.");
		}
		
		this.setNome(nome);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 41;
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
		Usuario other = (Usuario) obj;
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
