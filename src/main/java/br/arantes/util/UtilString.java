package br.arantes.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class UtilString {

	public static boolean isEmpty(final String... strings) {
		if ((Object[]) strings == null) {
			return Boolean.TRUE;
		}

		for (final String string : strings) {
			if (UtilString.isEmpty(string)) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	public static String maiuscula(final String string) {
		String strMaiuscula = string;
		if (!UtilString.isEmpty(string)) {
			strMaiuscula = string.toUpperCase();
		}

		return strMaiuscula;
	}

	public static String minuscula(final String string) {
		String strMinuscula = string;
		if (!UtilString.isEmpty(string)) {
			strMinuscula = string.toLowerCase();
		}

		return strMinuscula;
	}

	public static List<String> split(final String string, final String delimitador) {
		final List<String> result = new ArrayList<String>();

		if (!UtilString.isEmpty(string, delimitador)) {
			final StringTokenizer st = new StringTokenizer(string, delimitador);
			while (st.hasMoreTokens()) {
				result.add(st.nextToken());
			}
		}

		return result;
	}

	public static String removerAcentuacao(final String string) {
		String result = string;

		if (!UtilString.isEmpty(string)) {
			result = UtilString.substituir(result, "[ÁÀÂÃ]", "A");
			result = UtilString.substituir(result, "[áàâãª]", "a");
			result = UtilString.substituir(result, "[ÉÈÊ]", "E");
			result = UtilString.substituir(result, "[éèê]", "e");
			result = UtilString.substituir(result, "[ÍÌÎÏ]", "I");
			result = UtilString.substituir(result, "[íìîï]", "i");
			result = UtilString.substituir(result, "[ÓÒÔÕÖ]", "O");
			result = UtilString.substituir(result, "[óòôõºö]", "o");
			result = UtilString.substituir(result, "[ÚÙÛÜ]", "U");
			result = UtilString.substituir(result, "[úùûü]", "u");
			result = UtilString.substituir(result, "[Ç]", "C");
			result = UtilString.substituir(result, "[ç]", "c");
			result = UtilString.substituir(result, "[~\\d^Ž`]", "");
			result = UtilString.substituir(result, "[\\dš]", "");
		}

		return string;
	}

	public static String removerCaracteres(final String string) {
		String result = string;
		if (!UtilString.isEmpty(string)) {
			result = UtilString.remover(string, "[^0-9]");
		}

		return result;
	}

	public static String remover(final String srcString, final String localizar) {
		String result = srcString;
		if (!UtilString.isEmpty(srcString, localizar)) {
			result = srcString.replaceAll(localizar, "");
		}

		return result;
	}

	public static String substituir(final String srcString, final String localizar, final String novaString) {
		String result = srcString;
		if (!UtilString.isEmpty(srcString, localizar)) {
			result = srcString.replaceAll(localizar, novaString);
		}

		return result;
	}

	public static String substituirSe(final boolean condicao, final String srcString, final String localizar,
			final String seVerdadeiro, final String seFalso) {
		String result = srcString;

		if (condicao) {
			result = UtilString.substituir(srcString, localizar, seVerdadeiro);

		} else {
			result = UtilString.substituir(srcString, localizar, seFalso);
		}

		return result;
	}

	public static int getTamanho(final String string) {
		return !UtilString.isEmpty(string) ? string.length() : 0;
	}

	public static String newLine() {
		return "\n";
	}

	public static boolean soContemNumero(final String valor) {
		final char[] dados = valor.toCharArray();

		for (final char item : dados) {
			if (!Character.isDigit(item)) {
				return false;
			}
		}

		return true;
	}

	public static String log(final String texto) {
		return MessageFormat.format("\n\n********\n\n{0}\n\n********\n", texto);
	}

	public static String completarZeroAEsquerda(int completar, String valor) {
		int size = valor.length();
		int total = completar - size;
		String zero = "";
		for (int i = 0; i < total; i++) {
			zero = zero + 0;
		}

		String ultima = zero + valor;
		return ultima.toString();
	}

	public static boolean isAlphaNumerico(String s) {
		String pattern = "^[a-zA-Z0-9]*$";
		if (s.matches(pattern)) {
			return true;
		}

		return false;
	}

	public static boolean isNumerico(String s) {
		String pattern = "^[0-9]*$";
		if (s.matches(pattern)) {
			return true;
		}

		return false;
	}

	public static String concatenarStrings(final String str1, final String str2) {
		String result = "";
		if (!UtilString.isEmpty(str1)) {
			result = result + str1;
		}
		if (!UtilString.isEmpty(str1) && !UtilString.isEmpty(str2)) {
			result = result + " - ";
		}
		if (!UtilString.isEmpty(str2)) {
			result = result + str2;
		}

		return result;

	}
}
