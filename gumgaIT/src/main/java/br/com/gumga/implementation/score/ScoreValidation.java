package br.com.gumga.implementation.score;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.gumga.enums.VerificationStrongEnum;
import br.com.gumga.exception.ScoreException;
import br.com.gumga.implementation.addition.Requirement;
import br.com.gumga.infrastructure.domain.RulesDomain;
import br.com.gumga.infrastructure.domain.ScoreDomain;
import br.com.gumga.utils.Constants;

/**
 * Classe que representa a junção de todas as regras e preparação do objeto a
 * ser consumido pelo serviço
 * 
 * @author Larissa
 * @since 30 de out de 2016
 */
public class ScoreValidation {
	private static List<RulesDomain> rules = new ArrayList<RulesDomain>();

	private static final Logger LOGGER = Logger.getLogger(ScoreValidation.class);

	public ScoreDomain getScoreValidation(String password) throws ScoreException {
		rules = new ArrayList<RulesDomain>();
		Requirement requirement = new Requirement();
		ScoreDomain score = new ScoreDomain();
		Constants.CLASSES_ADDITIONS.stream()
				.forEach(className -> getScoreValidationByRulePositive(password, className));

		Constants.CLASSES_DEDUCTIONS.stream()
		.forEach(className -> getScoreValidationByRuleNegative(password, className));

		// Regra de Requerimento caso não atenda não continua a execução
		int valueBonusRequirement = requirement.getValueBonusPositive(password);
		int valueLengthRequirement = requirement.getValueLengthPositive(password);
		RulesDomain rule = new RulesDomain();
		rule.setRule(Requirement.class.getSimpleName());
		rule.setCount(valueLengthRequirement);
		rule.setBonus(valueBonusRequirement);
		rules.add(rule);

		int totalScore = rules.stream().mapToInt(r -> r.getBonus()).sum();
		score.setRules(rules);
		score.setScore(totalScore);
		score.setMessage(VerificationStrongEnum.score(totalScore));
		return score;

	}

	private static void getScoreValidationByRulePositive(String password, String className) {
		RulesDomain rule = new RulesDomain();
		Object classReflection;
		try {
			classReflection = Class.forName(Constants.PACKAGE_ADDITION.concat(".").concat(className)).newInstance();
			Method methodLength = classReflection.getClass().getDeclaredMethod(
					Constants.METHOD_EXECUTE_REFLECTION_LENGTH_POSITIVE, new Class[] { String.class });
			Integer valueLength = (Integer) methodLength.invoke(classReflection, password);
			Method methodBonus = classReflection.getClass().getDeclaredMethod(
					Constants.METHOD_EXECUTE_REFLECTION_BONUS_POSITIVE, new Class[] { String.class });
			Integer valueBonus = (Integer) methodBonus.invoke(classReflection, password);
			rule.setBonus(valueBonus);
			rule.setCount(valueLength);
			rule.setRule(className);
			rules.add(rule);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			LOGGER.error("Ocorreu um erro ao obter o valor do score addition: "+e.getMessage());
		}

	}
	
	private static void getScoreValidationByRuleNegative(String password, String className) {
		RulesDomain rule = new RulesDomain();
		Object classReflection;
		try {
			classReflection = Class.forName(Constants.PACKAGE_DEDUCTION.concat(".").concat(className)).newInstance();
			Method methodLength = classReflection.getClass().getDeclaredMethod(
					Constants.METHOD_EXECUTE_REFLECTION_LENGTH_NEGATIVE, new Class[] { String.class });
			Integer valueLength = (Integer) methodLength.invoke(classReflection, password);
			Method methodBonus = classReflection.getClass().getDeclaredMethod(
					Constants.METHOD_EXECUTE_REFLECTION_BONUS_NEGATIVE, new Class[] { String.class });
			Integer valueBonus = (Integer) methodBonus.invoke(classReflection, password);
			rule.setBonus(valueBonus);
			rule.setCount(valueLength);
			rule.setRule(className);
			rules.add(rule);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			LOGGER.error("Ocorreu um erro ao obter o valor do score deduction: "+e.getMessage());
		}

	}


}
