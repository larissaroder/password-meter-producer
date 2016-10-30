package br.com.gumga.implementation.deduction;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.enums.RegexDeductionEnum;
import br.com.gumga.implementation.interfaces.DeductionInterface;

/**
 * Classe que representa a regra de letras maiusculas repetidas sequencialmente
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class LetterConsecutiveUpperCaseSequence implements DeductionInterface {

	@Override
	public int getValueBonusNegative(String password) {
		return getRepeatedLettersUpperCase(password) * -2;
	}

	@Override
	public int getValueLengthNegative(String password) {
		return getRepeatedLettersUpperCase(password);
	}

	private int getRepeatedLettersUpperCase(String password) {
		int letters = 0;
		if (StringUtils.isBlank(password)) {
			return letters;
		}
		letters = password.replaceAll(RegexDeductionEnum.REPEATED_LETTER_UPPER.getRegex(), "").length();
		return letters >0 ? letters-1 : 0;
	}
}
