package br.com.gumga.implementation.addition;

import br.com.gumga.implementation.interfaces.AdditionInterface;
import br.com.gumga.utils.CalculateStrongPassword;

public class MiddleNumberOrSymbol implements AdditionInterface {

	@Override
	public int getValueBonusPositive(String password) {
		Integer valueCount = getValueLengthPositive(password);
		return CalculateStrongPassword.getValueBonus(valueCount, 2);
	}

	@Override
	public int getValueLengthPositive(String password) {
		return CalculateStrongPassword.getMiddleValue(password);
	}

	

}
