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
public class ValidationBonusRequirementsTest {

	@Test
	public void regexTest() {
		String password = "lariS";
		int length = getBonusLowerCase(password);
		Assert.assertSame(8, length);
	}

	private int getBonusLowerCase(String password) {
		int lowercase = password.replaceAll(RegexAdditionEnum.UPPER_CASE.getRegex(), "").length();
		return (password.length() - lowercase) * 2;
	}

}
