package br.com.gumga.implementation.addition;

import br.com.gumga.implementation.interfaces.AdditionInterface;
import br.com.gumga.utils.CalculateStrongPassword;

/**
 * Classe responsável por implementar a regra de bônus de números
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class Number implements AdditionInterface {

	@Override
	public int getValueBonusPositive(String password) {
		Integer valueCount = getValueLengthPositive(password);
		return CalculateStrongPassword.getValueBonus(valueCount, 4);
	}

	@Override
	public int getValueLengthPositive(String password) {
		return CalculateStrongPassword.getNumber(password);
	}
}
