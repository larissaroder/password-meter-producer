package br.com.gumga.implementation.addition;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.enums.RegexAdditionEnum;
import br.com.gumga.implementation.interfaces.AdditionInterface;

public class MiddleNumberOrSymbol implements AdditionInterface {

	@Override
	public int getValueBonusPositive(String password) {
		return getMiddleValue(password) * 2;
	}

	@Override
	public int getValueLengthPositive(String password) {
		return getMiddleValue(password);
	}

	private int getMiddleValue(String password) {
		int middleLength = 0;
		if (StringUtils.isBlank(password) || password.length() <= 2) {
			return middleLength;
		}
		String middle = password.substring(1, password.length() - 1);
		middleLength = middle.replaceAll(RegexAdditionEnum.SYMBOL_NUMBER_MIDDLE_LENGTH.getRegex(), "").length();
		return middleLength;
	}

}
