package br.com.gumga.implementation.addition;

import br.com.gumga.implementation.interfaces.AdditionInterface;
import br.com.gumga.utils.CalculateStrongPassword;

/**
 * Classe que representa a implementação das regras para letras maiúsculas
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class UpperCaseLetter implements AdditionInterface {

	@Override
	public int getValueBonusPositive(String password) {
		Integer valueCount = getValueLengthPositive(password);
		return CalculateStrongPassword.getValueBonus(password.length(), valueCount, 2);
	}

	@Override
	public int getValueLengthPositive(String password) {
		return CalculateStrongPassword.getValueUpperCase(password);
	}
}
