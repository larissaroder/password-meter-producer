package br.com.gumga.implementation.addition;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import br.com.gumga.implementation.interfaces.AdditionInterface;
import br.com.gumga.utils.Constants;

/**
 * Classe que representa a regra de calculo de requerimento mínimo de senha
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class Requirement implements AdditionInterface {

	private static final Logger LOGGER = Logger.getLogger(Requirement.class);
	@Override
	public int getValueBonusPositive(String password) {
		int requirementsBonus = getRequirementsValue(password);
		return (requirementsBonus > Constants.MINIMUM_REQUIREMENTS) ? ( (requirementsBonus-1) * 2) : 0;
	}

	@Override
	public int getValueLengthPositive(String password) {
		int requirementsBonus = getRequirementsValue(password);
		return (requirementsBonus > Constants.MINIMUM_REQUIREMENTS) ? (requirementsBonus-1) : 0;
	}

	private int getRequirementsValue(String password) {
		Integer requirementsBonus = 0;
		try {
			if (StringUtils.isBlank(password)) {
				return requirementsBonus;
			}
			for (String className : Constants.CLASSES_ADDITIONS) {

				Object classReflection = Class.forName(Constants.PACKAGE_ADDITION.concat(".").concat(className))
						.newInstance();
				Method method = classReflection.getClass().getDeclaredMethod(Constants.METHOD_EXECUTE_REFLECTION_LENGTH_POSITIVE,
						new Class[] { String.class });
				Integer value = (Integer) method.invoke(classReflection, password);
				if (value > 0) {
					requirementsBonus++;
				}
			}
			int passwordLength = new NumberCharacter().getValueLengthPositive(password);
			if ((passwordLength < Constants.MINIMUM_LENGTH_PASSWORD)) {
				requirementsBonus = 0;
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SecurityException
				| IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
			LOGGER.error("Ocorreu um erro ao obter o valor score do requerimento: "+e.getMessage());
		}
		return requirementsBonus;
	}
}
