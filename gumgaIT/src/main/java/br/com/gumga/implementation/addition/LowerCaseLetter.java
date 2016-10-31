package br.com.gumga.implementation.addition;

import java.util.HashMap;
import java.util.Map;

import br.com.gumga.implementation.checker.CheckCalculateStrongPassword;
import br.com.gumga.implementation.interfaces.BonusInterface;
import br.com.gumga.utils.Constants;

/**
 * Classe que representa implementação de regras para letras minúsculas
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class LowerCaseLetter extends CheckCalculateStrongPassword implements BonusInterface {

	@Override
	public Map<String , Integer>  getValueBonus(String password) {
		Map<String , Integer> values = new HashMap<>();
		Integer valueCount = getValueLowerCase(password);
		values.put(Constants.LENGTH, valueCount);
		values.put(Constants.BONUS, getValueBonus(password.length(), valueCount, 2));
		return values;
	}
}
