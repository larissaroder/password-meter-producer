package br.com.gumga.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gumga.exception.ScoreException;
import br.com.gumga.implementation.score.ScoreValidation;
import br.com.gumga.infrastructure.domain.ScoreDomain;

@RestController
@EnableAutoConfiguration
public class PasswordValidationService {
	private static final Logger LOGGER = Logger.getLogger(PasswordValidationService.class);
	@Autowired
	private Environment env;
	
	@RequestMapping(value = "/validation",method={RequestMethod.POST})
	public ResponseEntity<Object> getResponseValidationPassword(@RequestParam String password) {
		LOGGER.info(">>>> Início - Método getResponseValidationPassword >>>>");
		try {
			ScoreValidation validation = new ScoreValidation();
			ScoreDomain score = validation.getScoreValidation(password);
			LOGGER.info(">>>> Fim - Método getResponseValidationPassword >>>>");
			return new ResponseEntity<Object>(score, HttpStatus.OK);
		} catch (ScoreException e) {
			LOGGER.error("Ocorreu um erro ao retornar o resultado do serviço: "+e.getMessage());
			return new ResponseEntity<Object>(env.getProperty("erro"), HttpStatus.OK);
		}
		
	}

}
