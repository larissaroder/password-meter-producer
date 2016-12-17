package br.com.gumga;

import org.junit.Assert;
import org.junit.Test;

/**
 * Classe de teste para validação das regras negociais
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class ValidationBonusNumberCharacterTest {

	@Test
	public void regexTest() {
		String password = "lariS1";
		int length = getBonusNumberCharacter(password);
		Assert.assertSame(4, length);
	}

	private int getBonusNumberCharacter(String password) {
		return password.length() * 4;
	}
}
