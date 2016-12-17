package br.com.gumga;

import org.junit.Assert;
import org.junit.Test;

import br.com.gumga.enums.VerificationStrongEnum;

public class ValidationEnumStrongTest {

	@Test
	public void getRange () {
		Assert.assertSame("Forte", VerificationStrongEnum.score(80));
	}
}
