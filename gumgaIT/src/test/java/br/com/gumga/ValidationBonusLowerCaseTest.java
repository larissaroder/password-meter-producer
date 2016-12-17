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
public class ValidationBonusLowerCaseTest {

	@Test
	public void regexTest() {
		String password = "lariS";
		int length = getBonusUpperCase(password);
		Assert.assertSame(2, length);
	}

	private int getBonusUpperCase(String password) {
		int lowerCaseLength = password.replaceAll(RegexAdditionEnum.LOWER_CASE.getRegex(), "").length();
		return (password.length() - lowerCaseLength) * 2;
	}

}
