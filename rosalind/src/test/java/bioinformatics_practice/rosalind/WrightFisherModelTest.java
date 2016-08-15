package bioinformatics_practice.rosalind;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class WrightFisherModelTest {

	@Test
	public void factorialTest() throws Exception {
		int x = WrightFisherModel.factorial(5);
		Assert.assertEquals(120, x);
	}
	
	@Test
	public void factorialOne() throws Exception {
		int x= WrightFisherModel.factorial(1);
		Assert.assertEquals(1,  x);
	}
	
	@Test
	public void factorialZero() throws Exception {
		int x= WrightFisherModel.factorial(0);
		Assert.assertEquals(1,  x);
	}
	
	@Test (expectedExceptions = Exception.class)
	public void factorialNegativeNumber() throws Exception {
		WrightFisherModel.factorial(-1);
	}
}
