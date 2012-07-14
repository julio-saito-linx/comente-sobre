package br.com.saitodisse.model;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.saitodisse.model.exceptions.MensagemInvalidaException;
import br.com.saitodisse.model.exceptions.NomeUsuarioInvalidoException;

public class MensagemTest {

	@Test(expected=MensagemInvalidaException.class)
	public void todo_mensagem_deve_possuir_um_texto() throws Throwable  {
		new Mensagem("", new Usuario("saitodisse"));
	}

	@Test(expected=MensagemInvalidaException.class)
	public void todo_mensagem_deve_estar_associada_a_um_usuario() throws Throwable  {
		new Mensagem("tem texto aqui", null);
	}

}
