package br.com.saitodisse.model.exceptions;

public class NomeUsuarioInvalidoException extends Exception {
	private static final long serialVersionUID = 6639363695732011769L;
	public NomeUsuarioInvalidoException() {
	}
	public NomeUsuarioInvalidoException(String message) {
		super(message);
	}
}
