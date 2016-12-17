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
public class ValidationBonusNumberTest {

	@Test
	public void regexTest() {
		String password = "lariS2";
		int length = getBonusNumber(password);
		Assert.assertSame(4, length);
	}

	private int getBonusNumber(String password) {
		int number = password.replaceAll(RegexAdditionEnum.NUMBER_LENGTH.getRegex(), "").length();
		return number * 4;
	}

}
