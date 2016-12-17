package br.com.gumga.implementation.addition;

import java.util.HashMap;
import java.util.Map;

import br.com.gumga.implementation.checker.CheckCalculateStrongPassword;
import br.com.gumga.implementation.interfaces.BonusInterface;
import br.com.gumga.utils.Constants;

/**
 * Classe responsável por implementar a regra de bônus de números
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class Number extends CheckCalculateStrongPassword implements BonusInterface {

	@Override
	public Map<String , Integer> getValueBonus(String password) {
		Integer valueCount = getNumber(password);
		Map<String , Integer> values = new HashMap<>();
		values.put(Constants.LENGTH, valueCount);
		values.put(Constants.BONUS, getValueBonus(valueCount, 4));
		return values;
	}
}
