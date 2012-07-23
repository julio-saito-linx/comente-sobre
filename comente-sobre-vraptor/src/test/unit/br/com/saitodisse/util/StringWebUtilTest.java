package br.com.saitodisse.util;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringWebUtilTest {

	@Test
	public void converterParaUrlAmigavel_remove_interrogacao() {
		assertEquals("sou-feliz", StringWebUtil.converterParaUrlAmigavel("sou feliz?"));
	}

	@Test
	public void converterParaUrlAmigavel_retira_acentos() {
		assertEquals("isso-e-muito-legal", StringWebUtil.converterParaUrlAmigavel("Isso é muito legal..."));
	}

	@Test
	public void converterParaUrlAmigavel_retira_outros_caracteres_especiais() {
		assertEquals("adoro-caracteres-estranhos", StringWebUtil.converterParaUrlAmigavel("@#ado$ro$# !!caract)eres( +=_estranho%s#"));
	}
}
