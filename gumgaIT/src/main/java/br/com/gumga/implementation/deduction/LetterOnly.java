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
public class LetterOnly implements DeductionInterface {

	@Override
	public int getValueBonusNegative(String password) {
		return getValueLettersOnly(password) * -1;
	}

	@Override
	public int getValueLengthNegative(String password) {
		return getValueLettersOnly(password);
	}

	private int getValueLettersOnly(String password) {
		int letters = 0;
		if (StringUtils.isBlank(password)) {
			return letters;
		}
		letters = password.replaceAll(RegexDeductionEnum.LETTERS_ONLY.getRegex(), "").length();
		if (letters > 0) {
			return 0;
		}
		return password.length();
	}
}
