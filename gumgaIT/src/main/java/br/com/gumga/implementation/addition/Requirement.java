package br.com.gumga.implementation.addition;

import java.util.Map;

import br.com.gumga.implementation.checker.CheckCalculateStrongPassword;
import br.com.gumga.implementation.interfaces.BonusInterface;

/**
 * Classe que representa a regra de calculo de requerimento mínimo de senha
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class Requirement extends CheckCalculateStrongPassword implements BonusInterface {

	@Override
	public Map<String, Integer> getValueBonus(String password) {
		Map<String, Integer> values = getRequirementsValue(password);
		return values;
	}
}
