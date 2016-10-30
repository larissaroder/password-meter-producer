package br.com.gumga.implementation.deduction;

import br.com.gumga.implementation.interfaces.DeductionInterface;
import br.com.gumga.utils.CalculateStrongPassword;

/**
 * Classe que representa a regra de numeros repetidos sequenciais
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class NumberConsecutiveSequence implements DeductionInterface {

	@Override
	public int getValueBonusNegative(String password) {
		Integer valueCount = getValueLengthNegative(password);
		return CalculateStrongPassword.getValueBonus(valueCount, -2);
	}

	@Override
	public int getValueLengthNegative(String password) {
		return CalculateStrongPassword.getConsecutiveNumber(password);
	}
}
