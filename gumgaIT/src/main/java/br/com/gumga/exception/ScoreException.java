package br.com.gumga.exception;

public class ScoreException extends Exception {

	private static final long serialVersionUID = 1185321013898938937L;

	public ScoreException() {
	}

	// Constructor that accepts a message
	public ScoreException(String message) {
		super(message);
	}
}
