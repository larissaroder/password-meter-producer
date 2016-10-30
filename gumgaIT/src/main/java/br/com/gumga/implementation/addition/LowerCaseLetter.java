package br.com.gumga.implementation.addition;

import br.com.gumga.implementation.interfaces.AdditionInterface;
import br.com.gumga.utils.CalculateStrongPassword;

/**
 * Classe que representa implementação de regras para letras minúsculas
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class LowerCaseLetter implements AdditionInterface {

	@Override
	public int getValueBonusPositive(String password) {
		Integer valueCount = getValueLengthPositive(password);
		return CalculateStrongPassword.getValueBonus(password.length(), valueCount, 2);
	}

	@Override
	public int getValueLengthPositive(String password) {
		return CalculateStrongPassword.getValueLowerCase(password);
	}
}
