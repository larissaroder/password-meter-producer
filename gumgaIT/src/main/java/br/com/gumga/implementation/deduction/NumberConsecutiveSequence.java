package br.com.gumga.implementation.deduction;

import java.util.HashMap;
import java.util.Map;

import br.com.gumga.implementation.checker.CheckCalculateStrongPassword;
import br.com.gumga.implementation.interfaces.BonusInterface;
import br.com.gumga.utils.Constants;

/**
 * Classe que representa a regra de numeros repetidos sequenciais
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class NumberConsecutiveSequence extends CheckCalculateStrongPassword implements BonusInterface {

	@Override
	public Map<String, Integer> getValueBonus(String password) {
		Map<String , Integer> values = new HashMap<>();
		Integer valueCount = getConsecutiveNumber(password);
		values.put(Constants.LENGTH, valueCount);
		values.put(Constants.BONUS, getValueBonus(valueCount, -2));
		return values;
	}
}
