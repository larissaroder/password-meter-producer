package br.com.gumga.implementation.addition;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.enums.RegexAdditionEnum;
import br.com.gumga.implementation.interfaces.AdditionInterface;

/**
 * Classe que representa a implementação das regras para letras maiúsculas
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class UpperCaseLetter implements AdditionInterface {

	@Override
	public int getValueBonusPositive(String password) {
		return (getValueUpperCase(password) > 0) ? (password.length() - getValueUpperCase(password)) * 2 : 0;
	}

	@Override
	public int getValueLengthPositive(String password) {
		return getValueUpperCase(password);
	}

	private int getValueUpperCase(String password) {
		int upperCaseBonus = 0;
		if (StringUtils.isBlank(password)) {
			return upperCaseBonus;
		}
		int upperCaseLength = password.replaceAll(RegexAdditionEnum.UPPER_CASE.getRegex(), "").length();
		return upperCaseLength;
	}

}
