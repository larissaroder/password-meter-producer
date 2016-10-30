package br.com.gumga.implementation.addition;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.enums.RegexAdditionEnum;
import br.com.gumga.implementation.interfaces.AdditionInterface;

/**
 * Classe responsável por implementar a regra de bônus de números
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class Number implements AdditionInterface {

	@Override
	public int getValueBonusPositive(String password) {
		return getNumber(password) * 4;
	}

	@Override
	public int getValueLengthPositive(String password) {
		return getNumber(password);
	}

	private int getNumber(String password) {
		int number = 0;
		if (StringUtils.isBlank(password)) {
			return number;
		}
		number = password.replaceAll(RegexAdditionEnum.NUMBER_LENGTH.getRegex(), "").length();
		return number;
	}

}
