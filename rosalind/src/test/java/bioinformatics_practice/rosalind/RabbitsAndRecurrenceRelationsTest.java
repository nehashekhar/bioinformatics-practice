package bioinformatics_practice.rosalind;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RabbitsAndRecurrenceRelationsTest {

	@Test
	public void fibonacciTest() throws Exception {
		int x = RabbitsAndRecurrenceRelations.fibonacciSequence(3, 5);
		Assert.assertEquals(x, 19);
	}
	
	@Test
	public void fibonacciPositiveTest() throws Exception {
		int x = RabbitsAndRecurrenceRelations.fibonacciSequence(1, 9);
		Assert.assertEquals(x, 34);
	}
	
	@Test
	public void fibonacciSeedValueZero() throws Exception {
		int x = RabbitsAndRecurrenceRelations.fibonacciSequence(1, 0);
		Assert.assertEquals(x, 0);
	}
	
	@Test
	public void fibonacciSeedValueOne() throws Exception {
		int x = RabbitsAndRecurrenceRelations.fibonacciSequence(1, 1);
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
	
	@Test (expectedExceptions = Exception.class)
	public void lowKValue() throws Exception {
		RabbitsAndRecurrenceRelations.fibonacciSequence(-1, 1);
	}
	
	@Test (expectedExceptions = Exception.class)
	public void highKValue() throws Exception {
		RabbitsAndRecurrenceRelations.fibonacciSequence(6, 1);
	}

}
