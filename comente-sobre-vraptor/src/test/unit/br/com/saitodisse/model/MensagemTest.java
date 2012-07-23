package br.com.saitodisse.model;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.saitodisse.model.exceptions.MensagemInvalidaException;

public class MensagemTest {

	@Test
	public void titulo_nao_eh_obrigatorio() throws Throwable  {
		Mensagem mensagemSemTitulo = new Mensagem("", "texto", new Usuario("saitodisse"));
		assertEquals(mensagemSemTitulo.getTitulo(), "");
	}

	@Test(expected=MensagemInvalidaException.class)
	public void deve_possuir_um_texto() throws Throwable  {
		new Mensagem("titulo", "", new Usuario("saitodisse"));
	}

	@Test(expected=MensagemInvalidaException.class)
	public void deve_possuir_um_texto_mesmo_se_null() throws Throwable  {
		new Mensagem("titulo", null, new Usuario("saitodisse"));
	}

	@Test
	public void deve_nao_deve_tentar_converter_se_titulo_null() throws Throwable  {
		Mensagem mensagem = new Mensagem(null, "texto", new Usuario("saitodisse"));
		assertTrue("o titulo deveria estar vazio",
				    mensagem.getTitulo() == null);
		assertTrue("o titulo amigável deveria estar vazio",
			    mensagem.getTituloAmigavel() == null);
	}


	@Test(expected=MensagemInvalidaException.class)
	public void deve_estar_associada_a_um_usuario() throws Throwable  {
		new Mensagem("titulo", "texto", null);
	}

	@Test
	public void deve_converte_titulo_para_url_amigavel() throws Throwable  {
		Mensagem mensagem = new Mensagem(":)Sou Feliz!!!", "texto", new Usuario("saitodisse"));
		assertEquals("sou-feliz", mensagem.getTituloAmigavel());
	}


}
