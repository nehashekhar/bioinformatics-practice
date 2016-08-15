package bioinformatics_practice.rosalind;

/**
 * This class solves the problem delineated here:
 * http://rosalind.info/problems/fib/
 * 
 * @author nehashekhar
 *
 */
public class RabbitsAndRecurrenceRelations {

	public static void main(String[] args) {
		try {
			System.out.println("Fibonacci number:" + fibonacciSequence(1, 5));
			System.out.println("Fibonacci number:" + fibonacciSequence(3, 5));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int fibonacciSequence(int k, int n) throws Exception {
		// Calculating the sum of a number requires three numbers:
		// Fn, Fn-1, Fn-2
		// Index starts at 1

		if (n < 0 | n > 40) {
			throw new Exception("n should be a positive integer less than or equal to 40");
		}

		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}

		int Fn = 0;

		for (int i = 0; i <= n; i++) {
			Fn = (fibonacciSequence(k, n - 1) + fibonacciSequence(k, n - 2))*k;
		}

		return Fn;
	}

}
