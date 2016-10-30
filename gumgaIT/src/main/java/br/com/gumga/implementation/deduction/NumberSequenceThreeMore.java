package br.com.gumga.implementation.deduction;

import java.util.Arrays;

import br.com.gumga.enums.RegexDeductionEnum;
import br.com.gumga.implementation.checker.CheckSequenceDeductionAbstract;
import br.com.gumga.implementation.interfaces.DeductionInterface;
import br.com.gumga.utils.Constants;

/**
 * Classe responsável pelas regras de numeros sequenciais quantidade maior que 4
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class NumberSequenceThreeMore extends CheckSequenceDeductionAbstract implements DeductionInterface {

	@Override
	public int getValueBonusNegative(String password) {
		String arrayLetter[] = password.replaceAll(RegexDeductionEnum.NUMBERS_ONLY_SEQUENCE.getRegex(), "-").split("-");
		int result = Arrays.stream(arrayLetter).filter(letters -> letters.length() >= 4)
				.mapToInt(letter -> finalResultBonus(letter, Constants.SEQUENCIAL_NUMBERS)).sum();
		return result * -3;
	}

	@Override
	public int getValueLengthNegative(String password) {
		String arrayLetter[] = password.replaceAll(RegexDeductionEnum.NUMBERS_ONLY_SEQUENCE.getRegex(), "-").split("-");
		int result = Arrays.stream(arrayLetter).filter(letters -> letters.length() >= 4)
				.mapToInt(letter -> finalResultBonus(letter, Constants.SEQUENCIAL_NUMBERS)).sum();
		return result;
	}

}