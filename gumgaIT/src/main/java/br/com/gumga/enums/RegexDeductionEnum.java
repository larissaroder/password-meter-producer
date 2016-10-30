package br.com.gumga.enums;

public enum RegexDeductionEnum {

	REPEATED_LETTER_UPPER ("[^A-Z{2,}]"),
	CONSECUTIVE_LETTER_LOWER ("[^a-z{2,}]"),
	REPEATED_NUMBER ("[^0-9{2,}]"),
	NUMBER_ONLY ("[0-9]"),
	LETTERS_ONLY ("[a-zA-Z]"),
	LETTERS_ONLY_SEQUENCE ("[^a-zA-Z]"),
	NUMBERS_ONLY_SEQUENCE ("[^0-9]"),
	SYMBOL_ONLY_SEQUENCE ("[A-Za-z0-9]");
	
	private String regex;

	private RegexDeductionEnum( String regex){
		this.regex = regex;
	}

	public String getRegex() {
		return regex;
	}
}
