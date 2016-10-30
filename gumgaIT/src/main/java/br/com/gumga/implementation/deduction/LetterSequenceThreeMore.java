package br.com.gumga.implementation.deduction;

import java.util.Arrays;

import br.com.gumga.enums.RegexDeductionEnum;
import br.com.gumga.implementation.checker.CheckSequenceDeductionAbstract;
import br.com.gumga.implementation.interfaces.DeductionInterface;
import br.com.gumga.utils.Constants;

public class LetterSequenceThreeMore extends CheckSequenceDeductionAbstract implements DeductionInterface {

	@Override
	public int getValueBonusNegative(String password) {
		String arrayLetter[] = password.replaceAll(RegexDeductionEnum.LETTERS_ONLY_SEQUENCE.getRegex(), "-")
				.split("-");
		int result = Arrays.stream(arrayLetter).filter(letters -> letters.length() >= 4)
				.mapToInt(letter -> finalResultBonus(letter, Constants.SEQUENCIAL_LETTERS)).sum();
		return result * -3;
	}

	@Override
	public int getValueLengthNegative(String password) {
		String arrayLetter[] = password.replaceAll(RegexDeductionEnum.LETTERS_ONLY_SEQUENCE.getRegex(), "-")
				.split("-");
		int result = Arrays.stream(arrayLetter).filter(letters -> letters.length() >= 4)
				.mapToInt(letter -> finalResultBonus(letter, Constants.SEQUENCIAL_LETTERS)).sum();
		return result;
	}

}
