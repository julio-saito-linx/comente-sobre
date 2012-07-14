package br.com.saitodisse.model;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.saitodisse.model.exceptions.NomeUsuarioInvalidoException;

public class UsuarioTest {

	@Test(expected=NomeUsuarioInvalidoException.class)
	public void todo_usuario_deve_possuir_um_nome() throws NomeUsuarioInvalidoException {
		new Usuario("");
	}

}
