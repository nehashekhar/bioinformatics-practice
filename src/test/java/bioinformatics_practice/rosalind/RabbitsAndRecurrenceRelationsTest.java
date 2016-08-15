package bioinformatics_practice.rosalind;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RabbitsAndRecurrenceRelationsTest {

	@Test
	public void fibonacciTest() throws Exception {
		int x = RabbitsAndRecurrenceRelations.fibonacciSequence(5, 3);
		Assert.assertEquals(x, 19);
	}
	
	@Test
	public void fibonacciPositiveTest() throws Exception {
		int x = RabbitsAndRecurrenceRelations.fibonacciSequence(1, 10);
		Assert.assertEquals(x, 34);
	}
	
	@Test
	public void fibonacciSeedValueZero() throws Exception {
		int x = RabbitsAndRecurrenceRelations.fibonacciSequence(1, 1);
		Assert.assertEquals(x, 0);
	}
	
	@Test
	public void fibonacciSeedValueOne() throws Exception {
		int x = RabbitsAndRecurrenceRelations.fibonacciSequence(1, 2);
		Assert.assertEquals(x, 1);
	}
	
	@Test (expectedExceptions = Exception.class)
	public void lowNValue() throws Exception {
		RabbitsAndRecurrenceRelations.fibonacciSequence(1, -1);
	}
	
	@Test (expectedExceptions = Exception.class)
	public void highNValue() throws Exception {
		RabbitsAndRecurrenceRelations.fibonacciSequence(1, 41);
	}
	
	@Test
	public void lowKValue() {
		Assert.fail("Test to be written");		
	}
	
	@Test
	public void highKValue() {
		Assert.fail("Test to be written");
	}

}
