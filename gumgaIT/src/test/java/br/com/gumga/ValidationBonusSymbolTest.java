package br.com.gumga;

import org.junit.Assert;
import org.junit.Test;

import br.com.gumga.enums.RegexAdditionEnum;

/**
 * Classe de teste para validação das regras negociais
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class ValidationBonusSymbolTest {

	@Test
	public void regexTest() {
		String password = "lariS2ç{}^";
		int length = getBonusSymbol(password);
		Assert.assertSame(16, length);
	}

	private int getBonusSymbol(String password) {
		int symbol = password.replaceAll(RegexAdditionEnum.SYMBOL_LENGTH.getRegex(), "").length();
		return symbol * 6;
	}

}
