package br.com.gumga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Classe responsável por iniciar o serviço
 * @author Larissa
 * @since 28 de out de 2016
 * 
 */
@EnableAutoConfiguration
@ComponentScan("br.com.gumga")
public class ApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStarter.class, args);
	}
}
