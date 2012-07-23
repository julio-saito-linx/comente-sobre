package br.com.saitodisse.util;

public class StringWebUtil {
	public static String converterParaUrlAmigavel(String texto){
		String convertido = texto;
		convertido = convertido.toLowerCase();
		convertido = convertido.replaceAll("[�����]", "a");
		convertido = convertido.replaceAll("[����]", "e");
		convertido = convertido.replaceAll("[����]", "i");
		convertido = convertido.replaceAll("[�����]", "o");
		convertido = convertido.replaceAll("[����]", "u");
		convertido = convertido.replaceAll("\\s+", "-");
		convertido = convertido.replaceAll("_", "");
		convertido = convertido.replaceAll("[^\\w-]", "");
		return convertido;
	}
}
