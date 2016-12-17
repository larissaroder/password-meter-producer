package br.com.gumga.enums;

public enum RegexAdditionEnum {

	UPPER_CASE ("[^A-Z]"),
	LOWER_CASE ("[^a-z]"),
	NUMBER_LENGTH ("[^0-9]"),
	SYMBOL_LENGTH ("[0-9A-Za-z]"),
	SYMBOL_NUMBER_MIDDLE_LENGTH ("[a-zA-Z]");
	
	private String regex;

	private RegexAdditionEnum( String regex){
		this.regex = regex;
	}

	public String getRegex() {
		return regex;
	}
}
