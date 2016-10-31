package br.com.gumga.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public static final Integer MINIMUM_REQUIREMENTS = 4;
	public static final Integer MINIMUM_LENGTH_PASSWORD = 8;
	public static final String PACKAGE_ADDITION = "br.com.gumga.implementation.addition";
	public static final String PACKAGE_DEDUCTION = "br.com.gumga.implementation.deduction";
	public static final String METHOD_EXECUTE_REFLECTION_BONUS = "getValueBonus";
	public static final String SEQUENCIAL_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String SEQUENCIAL_NUMBERS = "01234567890";
	public static final String SEQUENCIAL_SYMBOLS = ")!@#$%^&*()";
	
	public static final List<String> CLASSES_ADDITIONS = Arrays.
			asList("LowerCaseLetter", "MiddleNumberOrSymbol", "Number", "Symbol", "UpperCaseLetter", "NumberCharacter" );
	
	public static final List<String> CLASSES_DEDUCTIONS = Arrays.
			asList("LetterOnly", "LetterConsecutiveLowerCaseSequence", "LetterConsecutiveUpperCaseSequence", 
					"LetterSequenceThreeMore", "NumberOnly", "NumberConsecutiveSequence", 
					"NumberSequenceThreeMore", "RepeatedCharacterInsensitive", "SymbolSequenceThreeMore" );
	public static final String LENGTH = "length";
	public static final String BONUS = "bonus";

}
