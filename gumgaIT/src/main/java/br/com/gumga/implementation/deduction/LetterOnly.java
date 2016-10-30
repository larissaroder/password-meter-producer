package br.com.gumga.implementation.deduction;

import br.com.gumga.implementation.interfaces.DeductionInterface;
import br.com.gumga.utils.CalculateStrongPassword;

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
		Integer valueCount = getValueLengthNegative(password);
		return CalculateStrongPassword.getValueBonus(valueCount, -1);
	}

	@Override
	public int getValueLengthNegative(String password) {
		return CalculateStrongPassword.getValueLettersOnly(password);
	}
}
