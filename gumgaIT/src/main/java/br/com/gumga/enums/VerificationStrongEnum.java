package br.com.gumga.enums;

import java.util.Arrays;

public enum VerificationStrongEnum {

	VERY_WEAK(0, 20, "Muito Fraco"), WEAK(21, 40, "Fraco"), GOOD(41, 60, "Boa"), STRONG(61, 80, "Forte"), VERY_STRONG(81, 100,"Muito Forte");

	private final Integer initialRange;
	private final Integer endRange;
	private final String message;

	VerificationStrongEnum(Integer initialRange, Integer endRange, String message) {
		this.initialRange = initialRange;
		this.endRange = endRange;
		this.message = message;
	}

	public static String score(Integer score) {
		return Arrays.stream(values())
				.filter(value -> score >= value.getInitialRange() && score <= value.getEndRange())
				.findAny().map(value -> value.getMessage()).get();
	}

	public Integer getInitialRange() {
		return initialRange;
	}

	public Integer getEndRange() {
		return endRange;
	}

	public String getMessage() {
		return message;
	}

}
