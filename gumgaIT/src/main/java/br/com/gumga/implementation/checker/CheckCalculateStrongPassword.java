package br.com.gumga.implementation.checker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import br.com.gumga.enums.RegexAdditionEnum;
import br.com.gumga.enums.RegexDeductionEnum;
import br.com.gumga.utils.Constants;

/**
 * Classe que representa as contas para o valor do bonus
 * 
 * @author Larissa
 * @since 30 de out de 2016
 */
public class CheckCalculateStrongPassword {

	private static final Logger LOGGER = Logger.getLogger(CheckCalculateStrongPassword.class);

	protected static Integer getValueBonus(Integer passwordLength, Integer valueCount, Integer valueMultiplication) {
		return (valueCount.equals(0)) ? 0 : (passwordLength - valueCount) * valueMultiplication;
	}

	protected static Integer getValueBonus(Integer valueCount, Integer valueMultiplication) {
		return valueCount * valueMultiplication;
	}

	protected static Integer getValueSymbol(String password) {
		Integer symbol = 0;
		if (StringUtils.isBlank(password)) {
			return symbol;
		}
		symbol = password.replaceAll(RegexAdditionEnum.SYMBOL_LENGTH.getRegex(), "").length();
		return symbol;
	}

	protected static Integer getMiddleValue(String password) {
		Integer middleLength = 0;
		if (StringUtils.isBlank(password) || password.length() <= 2) {
			return middleLength;
		}
		String middle = password.substring(1, password.length() - 1);
		middleLength = middle.replaceAll(RegexAdditionEnum.SYMBOL_NUMBER_MIDDLE_LENGTH.getRegex(), "").length();
		return middleLength;
	}

	protected static Integer getValueUpperCase(String password) {
		Integer upperCaseBonus = 0;
		if (StringUtils.isBlank(password)) {
			return upperCaseBonus;
		}
		Integer upperCaseLength = password.replaceAll(RegexAdditionEnum.UPPER_CASE.getRegex(), "").length();
		return upperCaseLength;
	}

	protected static Integer getValueLowerCase(String password) {
		Integer lowerCaseBonus = 0;
		if (StringUtils.isBlank(password)) {
			return lowerCaseBonus;
		}
		Integer lowerCaseLength = password.replaceAll(RegexAdditionEnum.LOWER_CASE.getRegex(), "").length();
		return lowerCaseLength;
	}

	protected static Integer getNumber(String password) {
		Integer number = 0;
		if (StringUtils.isBlank(password)) {
			return number;
		}
		number = password.replaceAll(RegexAdditionEnum.NUMBER_LENGTH.getRegex(), "").length();
		return number;
	}

	protected static Integer getConsecutiveLettersLowerCase(String password) {
		Integer letters = 0;
		if (StringUtils.isBlank(password)) {
			return letters;
		}
		letters = password.replaceAll(RegexDeductionEnum.CONSECUTIVE_LETTER_LOWER.getRegex(), "").length();
		return password.length() - letters;
	}

	protected static Integer getConsecutiveLettersUpperCase(String password) {
		Integer letters = 0;
		if (StringUtils.isBlank(password)) {
			return letters; 
		}
		letters = password.replaceAll(RegexDeductionEnum.CONSECUTIVE_LETTER_UPPER.getRegex(), "").length();
		return password.length() - letters;
	}

	protected static Integer getValueLettersOnly(String password) {
		Integer letters = 0;
		if (StringUtils.isBlank(password)) {
			return letters;
		}
		letters = password.replaceAll(RegexDeductionEnum.LETTERS_ONLY.getRegex(), "").length();
		if (letters > 0) {
			return 0;
		}
		return password.length();
	}

	protected static Integer getConsecutiveNumber(String password) {
		Integer number = 0;
		if (StringUtils.isBlank(password)) {
			return number;
		}
		number = password.replaceAll(RegexDeductionEnum.CONSECUTIVE_NUMBER.getRegex(), "").length();
		return password.length() - number;
	}

	protected static Integer getValueNumbersOnly(String password) {
		Integer numbers = 0;
		if (StringUtils.isBlank(password)) {
			return numbers;
		}
		numbers = password.replaceAll(RegexDeductionEnum.NUMBER_ONLY.getRegex(), "").length();
		if (numbers > 0) {
			return 0;
		}
		return password.length();
	}

	protected static Map<String, Integer> getValueRepeated(String password) {
		Map<String, Integer> values = new HashMap<String, Integer>();
		double repeatedComplexity = 0;
		Integer repeatedCount = 0;
		for (Integer i = 0; i < password.length(); i++) {
			boolean exist = false;
			for (Integer j = 0; j < password.length(); j++) {
				if (password.charAt(i) == password.charAt(j) && (i != j)) {
					exist = true;
					repeatedComplexity += Math.abs((double) password.length() / (j - i));
					break;
				}
			}
			if (exist) {
				repeatedCount++;
				Integer unique = password.length() - repeatedCount;
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

	protected Integer getNumberCharacter(String password) {
		Integer length = StringUtils.isNotBlank(password) ? password.length() : 0;
		return length;
	}

	@SuppressWarnings("unchecked")
	protected Map<String, Integer> getRequirementsValue(String password) {
		Map<String, Integer> values = new HashMap<>();
		Integer requirementsBonus = 0;
		Integer requirementsCount = 0;
		try {
			if (StringUtils.isBlank(password)) {
				values.put(Constants.LENGTH, 0);
				values.put(Constants.BONUS, 0);
				return values;
			}
			for (String className : Constants.CLASSES_ADDITIONS) {

				Object classReflection = Class.forName(Constants.PACKAGE_ADDITION.concat(".").concat(className))
						.newInstance();
				Method method = classReflection.getClass().getDeclaredMethod(
						Constants.METHOD_EXECUTE_REFLECTION_BONUS, new Class[] { String.class });
				Map<String, Integer> value = (Map<String, Integer>) method.invoke(classReflection, password);
				if (value.get(Constants.LENGTH) > 0) {
					requirementsBonus++;
					requirementsCount++;
				}
			}
			if ((password.length() < Constants.MINIMUM_LENGTH_PASSWORD)) {
				requirementsBonus = 0;
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SecurityException
				| IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
			LOGGER.error("Ocorreu um erro ao obter o valor score do requerimento: " + e.getMessage());
		}
		requirementsCount = requirementsCount > 0 ? requirementsCount-1 : requirementsCount; 
		values.put(Constants.LENGTH, requirementsCount);
		requirementsBonus = requirementsBonus > Constants.MINIMUM_REQUIREMENTS ? (requirementsBonus - 1) * 2 : 0;
		values.put(Constants.BONUS, requirementsBonus);
		return values;
	}
}
