package br.com.gumga.implementation.deduction;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.enums.RegexDeductionEnum;
import br.com.gumga.implementation.interfaces.DeductionInterface;

/**
 * Classe que representa a regra de numeros repetidos sequenciais
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class NumberConsecutiveSequence implements DeductionInterface {

	@Override
	public int getValueBonusNegative(String password) {
		return getRepeatedNumber(password) * -2;
	}

	@Override
	public int getValueLengthNegative(String password) {
		return getRepeatedNumber(password);
	}

	private int getRepeatedNumber(String password) {
		int number = 0;
		if (StringUtils.isBlank(password)) {
			return number;
		}
		number = password.replaceAll(RegexDeductionEnum.REPEATED_NUMBER.getRegex(), "").length();
		return (number > 0) ? number-1 : 0;
	}
}
