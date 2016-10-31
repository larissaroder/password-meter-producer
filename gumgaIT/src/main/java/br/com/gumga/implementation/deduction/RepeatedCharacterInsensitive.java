package br.com.gumga.implementation.deduction;

import java.util.Map;

import br.com.gumga.implementation.checker.CheckCalculateStrongPassword;
import br.com.gumga.implementation.interfaces.BonusInterface;

/**
 * Classe que representa a implementação da regra de caracteres repetidos
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class RepeatedCharacterInsensitive extends CheckCalculateStrongPassword implements BonusInterface {

	@Override
	public Map<String , Integer> getValueBonus(String password) {
		return getValueRepeated(password);
	}
}
