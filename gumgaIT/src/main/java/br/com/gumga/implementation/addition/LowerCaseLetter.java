package br.com.gumga.implementation.addition;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.enums.RegexAdditionEnum;
import br.com.gumga.implementation.interfaces.AdditionInterface;

/**
 * Classe que representa implementação de regras para letras minúsculas
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class LowerCaseLetter implements AdditionInterface {

	@Override
	public int getValueBonusPositive(String password) {
		return (getValueLowerCase(password)) == 0 ? 0 : (password.length() - getValueLowerCase(password)) * 2;
	}

	@Override
	public int getValueLengthPositive(String password) {
		return getValueLowerCase(password);
	}

	private int getValueLowerCase(String password) {
		int lowerCaseBonus = 0;
		if (StringUtils.isBlank(password)) {
			return lowerCaseBonus;
		}
		int lowerCaseLength = password.replaceAll(RegexAdditionEnum.LOWER_CASE.getRegex(), "").length();
		return lowerCaseLength;
	}
}
