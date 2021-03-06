package bioinformatics_practice.rosalind;

import java.text.DecimalFormat;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class WrightFisherModelTest {
	DecimalFormat df;

	@Test(description="This test value was pulled from a paper: http://evol.bio.lmu.de/_teaching/evogen/Evo9-Summary.pdf")
	public void wfmOverGenerations() throws Exception {
		df = new DecimalFormat("#.##");
		double x = WrightFisherModel.probabilityOverGenerationsAndCopyNumbers(2, 5, 0.2, 1);
		Assert.assertEquals(df.format(0.3), df.format(x));
	}

	@Test(description="This test value was pulled from a paper: http://evol.bio.lmu.de/_teaching/evogen/Evo9-Summary.pdf")
	public void wfmPositiveTest() throws Exception {
		df = new DecimalFormat("#.##");
		
		double x = WrightFisherModel.wrightFisherModel(2, 5, 0.2);
		Assert.assertEquals(df.format(0.30), df.format(x));
	}
	
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
	
	@Test
	public void calculateProbabilityTest() {
		double p = WrightFisherModel.calculateProbability(2, 1);
		Assert.assertEquals(0.25, p);
	}
}
