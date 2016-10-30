package br.com.gumga.enums;

public enum VerificationStrongEnum {

	VERY_WEAK(0, "Muito Fraco"), WEAK(20, "Fraco"), GOOD(40, "Boa"), STRONG(60, "Forte"), VERY_STRONG(81, "Muito Forte");

	private final Integer range;
	private final String message;

	VerificationStrongEnum(Integer range, String message) {
		this.range = range;
		this.message = message;
	}

	public static String score(Integer score) {
		if (score > VERY_WEAK.getRange() && score <= WEAK.getRange()) {
			return VERY_WEAK.getMessage();
		} else if (score > WEAK.getRange() && score <= GOOD.getRange()) {
			return WEAK.getMessage();
		} else if (score > GOOD.getRange() && score <= STRONG.getRange()) {
			return GOOD.getMessage();
		} else if (score > STRONG.getRange() && score <= VERY_STRONG.getRange()) {
			return STRONG.getMessage();
		}
		return VERY_STRONG.getMessage();
	}

	public Integer getRange() {
		return range;
	}

	public String getMessage() {
		return message;
	}

}
