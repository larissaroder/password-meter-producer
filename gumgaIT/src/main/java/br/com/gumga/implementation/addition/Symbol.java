package br.com.gumga.implementation.addition;

import org.apache.commons.lang3.StringUtils;

import br.com.gumga.enums.RegexAdditionEnum;
import br.com.gumga.implementation.interfaces.AdditionInterface;

/**
 * Classe responsável por implementar a regra de bonus dos simbolos
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class Symbol implements AdditionInterface {

	@Override
	public int getValueBonusPositive(String password) {
		return getValueSymbol(password) * 6;
	}

	@Override
	public int getValueLengthPositive(String password) {
		return getValueSymbol(password);
	}
	
	private int getValueSymbol(String password) {
		int symbol = 0;
		if (StringUtils.isBlank(password)) {
			return symbol;
		}
		symbol = password.replaceAll(RegexAdditionEnum.SYMBOL_LENGTH.getRegex(), "").length();
		return symbol;
	}

}
