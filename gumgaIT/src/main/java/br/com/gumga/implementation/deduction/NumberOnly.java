package br.com.gumga.implementation.deduction;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.enums.RegexDeductionEnum;
import br.com.gumga.implementation.interfaces.DeductionInterface;

/**
 * Classe que representa implementação de regras para quando a senha possui
 * apenas letras
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class NumberOnly implements DeductionInterface {

	@Override
	public int getValueBonusNegative(String password) {
		return getValueNumbersOnly(password) * -1;
	}

	@Override
	public int getValueLengthNegative(String password) {
		return getValueNumbersOnly(password) * -1;
	}

	private int getValueNumbersOnly(String password) {
		int numbers = 0;
		if (StringUtils.isBlank(password)) {
			return numbers;
		}
		numbers = password.replaceAll(RegexDeductionEnum.NUMBER_ONLY.getRegex(), "").length();
		if (numbers > 0) {
			return 0;
		}
		return password.length();
	}
}
