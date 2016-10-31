package br.com.gumga.implementation.score;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		ScoreDomain score = new ScoreDomain();
		Constants.CLASSES_ADDITIONS.stream()
				.forEach(className -> getScoreValidationByRule(password, className, Constants.PACKAGE_ADDITION));

		Constants.CLASSES_DEDUCTIONS.stream()
		.forEach(className -> getScoreValidationByRule(password, className, Constants.PACKAGE_DEDUCTION));

		// Regra de Requerimento caso não atenda não continua a execução
		Map<String, Integer> valueRequeriment = new Requirement().getValueBonus(password);
		Integer valueBonusRequirement = valueRequeriment.get(Constants.BONUS);
		Integer valueLengthRequirement = valueRequeriment.get(Constants.LENGTH);
		
		RulesDomain rule = new RulesDomain();
		rule.setRule(Requirement.class.getSimpleName());
		rule.setCount(valueLengthRequirement);
		rule.setBonus(valueBonusRequirement);
		rules.add(rule);

		Integer totalScore = rules.stream().mapToInt(r -> r.getBonus()).sum();
		score.setRules(rules);
		score.setScore(totalScore);
		score.setMessage(VerificationStrongEnum.score(totalScore));
		return score;

	}

	@SuppressWarnings("unchecked")
	private static void getScoreValidationByRule(String password, String className, String packageName) {
		RulesDomain rule = new RulesDomain();
		try {
			Object classReflection = Class.forName(packageName.concat(".").concat(className)).newInstance();
			Method methodBonus = classReflection.getClass().getDeclaredMethod(
					Constants.METHOD_EXECUTE_REFLECTION_BONUS, new Class[] { String.class });
			Map<String, Integer> value = (Map<String, Integer>) methodBonus.invoke(classReflection, password);
			rule.setBonus(value.get(Constants.BONUS));
			rule.setCount(value.get(Constants.LENGTH));
			rule.setRule(className);
			rules.add(rule);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			LOGGER.error("Ocorreu um erro ao obter o valor do score addition: "+e.getMessage());
		}

	}
}
