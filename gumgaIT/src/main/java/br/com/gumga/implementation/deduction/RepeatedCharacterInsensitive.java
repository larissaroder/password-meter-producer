package br.com.gumga.implementation.deduction;

import java.util.Map;

import br.com.gumga.implementation.interfaces.DeductionInterface;
import br.com.gumga.utils.CalculateStrongPassword;
import br.com.gumga.utils.Constants;

/**
 * Classe que representa a implementação da regra de caracteres repetidos
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class RepeatedCharacterInsensitive implements DeductionInterface {

	@Override
	public int getValueBonusNegative(String password) {
		Map<String, Integer> values = CalculateStrongPassword.getValueRepeated(password);
		return values.get(Constants.BONUS) * -1;
	}

	@Override
	public int getValueLengthNegative(String password) {
		Map<String, Integer> values = CalculateStrongPassword.getValueRepeated(password);
		return values.get(Constants.LENGTH);
	}
}
