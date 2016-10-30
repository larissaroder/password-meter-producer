package br.com.gumga.implementation.deduction;

import java.util.HashMap;
import java.util.Map;

import br.com.gumga.implementation.interfaces.DeductionInterface;
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
		Map<String, Integer> values = getValueRepeated(password);
		return values.get(Constants.BONUS) * -1;
	}

	@Override
	public int getValueLengthNegative(String password) {
		Map<String, Integer> values = getValueRepeated(password);
		return values.get(Constants.LENGTH);
	}

	private Map<String, Integer> getValueRepeated(String password) {
		Map<String, Integer> values = new HashMap<String, Integer>();
		double repeatedComplexity = 0;
		int repeatedCount = 0;
		for (int i = 0; i < password.length(); i++) {
			boolean exist = false;
			for (int j = 0; j < password.length(); j++) {
				if (password.charAt(i) == password.charAt(j) && (i != j)) {
					exist = true;
					repeatedComplexity += Math.abs((double)password.length() / (j - i));
					break;
				}
			}
			if (exist) {
				repeatedCount++;
				int unique = password.length() - repeatedCount;
				if (unique > 0) {
					repeatedComplexity = Math.ceil(repeatedComplexity / unique);
				} else {
					repeatedComplexity = Math.ceil(repeatedComplexity);
				}
			}
		}
		values.put(Constants.BONUS, repeatedCount > 0 ? (int) repeatedComplexity : 0);
		values.put(Constants.LENGTH, repeatedCount);
		
		return values;
	}
}
