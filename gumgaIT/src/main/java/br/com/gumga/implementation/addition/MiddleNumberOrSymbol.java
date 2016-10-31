package br.com.gumga.implementation.addition;

import java.util.HashMap;
import java.util.Map;

import br.com.gumga.implementation.checker.CheckCalculateStrongPassword;
import br.com.gumga.implementation.interfaces.BonusInterface;
import br.com.gumga.utils.Constants;

public class MiddleNumberOrSymbol extends CheckCalculateStrongPassword implements BonusInterface {

	@Override
	public Map<String , Integer> getValueBonus(String password) {
		Integer valueCount = getMiddleValue(password);
		Map<String , Integer> values = new HashMap<>();
		values.put(Constants.LENGTH, valueCount);
		values.put(Constants.BONUS, getValueBonus(valueCount, 2));
		return values;
	}
}
