package br.com.saitodisse.model.exceptions;

public class MensagemInvalidaException extends Exception {
	private static final long serialVersionUID = 4156047143809647260L;
	public MensagemInvalidaException() {
	}
	public MensagemInvalidaException(String message) {
		super(message);
	}
}
