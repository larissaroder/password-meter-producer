package br.com.gumga;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import br.com.gumga.enums.RegexAdditionEnum;

/**
 * Classe de teste para validação das regras negociais
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class ValidationBonusMiddleTest {

	@Test
	public void regexTest() {
		String password = "lariS2ç{}^";
		int length = getBonusMiddle(password);
		Assert.assertSame(8, length);
	}

	private int getBonusMiddle(String password) {
		int middleBonus = 0;
		if (StringUtils.isBlank(password) || password.length() <= 2) {
			return middleBonus;
		}
		String middle = password.substring(1, password.length() - 1);
		middleBonus = middle.replaceAll(RegexAdditionEnum.SYMBOL_NUMBER_MIDDLE_LENGTH.getRegex(), "").length();
		return middleBonus * 2;
	}

}
