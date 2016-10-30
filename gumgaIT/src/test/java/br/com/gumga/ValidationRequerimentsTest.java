package br.com.gumga;

import org.junit.Test;

import br.com.gumga.utils.Constants;

/**
 * Classe de teste para validação das regras negociais
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class ValidationRequerimentsTest {

	@Test
	public void requirementsTest() {
		Constants.CLASSES_ADDITIONS.forEach(className -> System.out.println(className));
	}

}
