package br.com.gumga.implementation.deduction;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.enums.RegexDeductionEnum;
import br.com.gumga.implementation.interfaces.DeductionInterface;

/**
 * Classe que representa a implementação das regras de letras minusculas
 * sequenciais
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class LetterConsecutiveLowerCaseSequence implements DeductionInterface {

	@Override
	public int getValueBonusNegative(String password) {
		return getRepeatedLettersLowerCase(password) * -2;
	}

	@Override
	public int getValueLengthNegative(String password) {
		return getRepeatedLettersLowerCase(password);
	}

	private int getRepeatedLettersLowerCase(String password) {
		int letters = 0;
		if (StringUtils.isBlank(password)) {
			return letters;
		}
		letters = password.replaceAll(RegexDeductionEnum.REPEATED_LETTER_LOWER.getRegex(), "").length();
		return letters-1 > 0 ? letters : 0;
	}
}
