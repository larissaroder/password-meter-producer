package br.com.gumga.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.enums.RegexAdditionEnum;
import br.com.gumga.enums.RegexDeductionEnum;

/**
 * Classe que representa as contas para o valor do bonus
 * 
 * @author Larissa
 * @since 30 de out de 2016
 */
public class CalculateStrongPassword {

	public static Integer getValueBonus(Integer passwordLength, Integer valueCount, Integer valueMultiplication) {
		return (valueCount == 0) ? 0 : (passwordLength - valueCount) * valueMultiplication;
	}

	public static Integer getValueBonus(Integer valueCount, Integer valueMultiplication) {
		return valueCount * valueMultiplication;
	}
	
	public static int getValueSymbol(String password) {
		int symbol = 0;
		if (StringUtils.isBlank(password)) {
			return symbol;
		}
		symbol = password.replaceAll(RegexAdditionEnum.SYMBOL_LENGTH.getRegex(), "").length();
		return symbol;
	}
	
	public static int getMiddleValue(String password) {
		int middleLength = 0;
		if (StringUtils.isBlank(password) || password.length() <= 2) {
			return middleLength;
		}
		String middle = password.substring(1, password.length() - 1);
		middleLength = middle.replaceAll(RegexAdditionEnum.SYMBOL_NUMBER_MIDDLE_LENGTH.getRegex(), "").length();
		return middleLength;
	}
	
	public static int getValueUpperCase(String password) {
		int upperCaseBonus = 0;
		if (StringUtils.isBlank(password)) {
			return upperCaseBonus;
		}
		int upperCaseLength = password.replaceAll(RegexAdditionEnum.UPPER_CASE.getRegex(), "").length();
		return upperCaseLength;
	}
	
	public static int getValueLowerCase(String password) {
		int lowerCaseBonus = 0;
		if (StringUtils.isBlank(password)) {
			return lowerCaseBonus;
		}
		int lowerCaseLength = password.replaceAll(RegexAdditionEnum.LOWER_CASE.getRegex(), "").length();
		return lowerCaseLength;
	}
	
	public static int getNumber(String password) {
		int number = 0;
		if (StringUtils.isBlank(password)) {
			return number;
		}
		number = password.replaceAll(RegexAdditionEnum.NUMBER_LENGTH.getRegex(), "").length();
		return number;
	}
	
	public static int getConsecutiveLettersLowerCase(String password) {
		int letters = 0;
		if (StringUtils.isBlank(password)) {
			return letters;
		}
		letters = password.replaceAll(RegexDeductionEnum.CONSECUTIVE_LETTER_LOWER.getRegex(), "").length();
		return letters > 0 ? letters-1 : 0;
	}
	
	public static int getConsecutiveLettersUpperCase(String password) {
		int letters = 0;
		if (StringUtils.isBlank(password)) {
			return letters;
		}
		letters = password.replaceAll(RegexDeductionEnum.REPEATED_LETTER_UPPER.getRegex(), "").length();
		return letters >0 ? letters-1 : 0;
	}
	
	public static int getValueLettersOnly(String password) {
		int letters = 0;
		if (StringUtils.isBlank(password)) {
			return letters;
		}
		letters = password.replaceAll(RegexDeductionEnum.LETTERS_ONLY.getRegex(), "").length();
		if (letters > 0) {
			return 0;
		}
		return password.length();
	}

	public static int getConsecutiveNumber(String password) {
		int number = 0;
		if (StringUtils.isBlank(password)) {
			return number;
		}
		number = password.replaceAll(RegexDeductionEnum.REPEATED_NUMBER.getRegex(), "").length();
		return number > 0 ? number-1 : 0;
	}
	
	public static int getValueNumbersOnly(String password) {
		int numbers = 0;
		if (StringUtils.isBlank(password)) {
			return numbers;
		}
		numbers = password.replaceAll(RegexDeductionEnum.NUMBER_ONLY.getRegex(), "").length();
		if (numbers > 0) {
			return 0;
		}
		return password.length();
	}
	
	public static Map<String, Integer> getValueRepeated(String password) {
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
