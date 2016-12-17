package br.com.gumga.implementation.deduction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import br.com.gumga.enums.RegexDeductionEnum;
import br.com.gumga.implementation.checker.CheckSequenceDeduction;
import br.com.gumga.implementation.interfaces.BonusInterface;
import br.com.gumga.utils.Constants;

/**
 * Classe responsável pelas regras de numeros sequenciais quantidade maior que 4
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class NumberSequenceThreeMore extends CheckSequenceDeduction implements BonusInterface {
	
	@Override
	public Map<String, Integer> getValueBonus(String password) {
		Map<String, Integer> values = new HashMap<>();
		String arrayLetter[] = password.replaceAll(RegexDeductionEnum.NUMBERS_ONLY_SEQUENCE.getRegex(), "-").split("-");
		Integer result = Arrays.stream(arrayLetter).filter(letters -> letters.length() >= 4)
				.mapToInt(letter -> finalResultBonus(letter, Constants.SEQUENCIAL_NUMBERS)).sum();
		result = (result > 0) ? result : 0;
		values.put(Constants.LENGTH, result);
		values.put(Constants.BONUS, result * -3);
		return values;
	}
}
