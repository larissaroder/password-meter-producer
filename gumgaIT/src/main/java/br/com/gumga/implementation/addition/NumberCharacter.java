package br.com.gumga.implementation.addition;

import java.util.HashMap;
import java.util.Map;

import br.com.gumga.implementation.checker.CheckCalculateStrongPassword;
import br.com.gumga.implementation.interfaces.BonusInterface;
import br.com.gumga.utils.Constants;

/**
 * Classe que representa a contagem de bônus da quantidade de caracteres
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class NumberCharacter extends CheckCalculateStrongPassword implements BonusInterface {

	@Override
	public Map<String, Integer> getValueBonus(String password) {
		Integer valueCount = getNumberCharacter(password);
		Map<String , Integer> values = new HashMap<>();
		values.put(Constants.LENGTH, valueCount);
		values.put(Constants.BONUS, getValueBonus(valueCount, 4));
		return values;
	}

}
