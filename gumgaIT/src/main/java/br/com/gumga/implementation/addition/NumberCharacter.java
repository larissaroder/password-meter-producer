package br.com.gumga.implementation.addition;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.implementation.interfaces.AdditionInterface;

/**
 * Classe que representa a contagem de bônus da quantidade de caracteres
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class NumberCharacter implements AdditionInterface {

	@Override
	public int getValueBonusPositive(String password) {
		int length = getNumberCharacter(password);
		return length * 4;
	}

	@Override
	public int getValueLengthPositive(String password) {
		int length = getNumberCharacter(password);
		return length;
	}
	
	private int getNumberCharacter (String password) {
		int length = StringUtils.isNotBlank(password) ? password.length() : 0;
		return length;
	}

}
