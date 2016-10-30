package br.com.gumga;

import org.junit.Assert;
import org.junit.Test;

import br.com.gumga.implementation.deduction.RepeatedCharacterInsensitive;

public class ValidationRepeatedInsensitiveCaseTest {

	@Test
	public void insensitive() {
		String password = "lasdl";
		int length = new RepeatedCharacterInsensitive().getValueBonusNegative(password);
		Assert.assertSame(-1, length);
	}
}
