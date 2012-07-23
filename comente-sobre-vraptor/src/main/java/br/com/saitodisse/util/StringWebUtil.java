package br.com.saitodisse.util;

public class StringWebUtil {
	public static String converterParaUrlAmigavel(String texto){
		String convertido = texto;
		convertido = convertido.toLowerCase();
		convertido = convertido.replaceAll("[דגאבה]", "a");
		convertido = convertido.replaceAll("[ךטיכ]", "e");
		convertido = convertido.replaceAll("[מלםן]", "i");
		convertido = convertido.replaceAll("[ץפעףצ]", "o");
		convertido = convertido.replaceAll("[ûתשü]", "u");
		convertido = convertido.replaceAll("\\s+", "-");
		convertido = convertido.replaceAll("_", "");
		convertido = convertido.replaceAll("[^\\w-]", "");
		return convertido;
	}
}
