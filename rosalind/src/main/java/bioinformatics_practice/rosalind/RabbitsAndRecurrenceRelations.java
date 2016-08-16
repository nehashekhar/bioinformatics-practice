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
			int k = defineK();
			int n = defineN();
			
			System.out.println("Rabbit pairs after " + n + " months if each pair produces " + k + " more pairs: " + fibonacciSequence(k, n));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//This function can be extended to read from another source, e.g. file or user input
	//Currently, the number is hardcoded
	public static int defineK() {
		return 3;
	}

	//This function can be extended to read from another source, e.g. file or user input
	//Currently, the number is hardcoded
	public static int defineN() {
		return 5;
	}

	public static int fibonacciSequence(int k, int n) throws Exception {
		// Calculating the sum of a number requires three numbers:
		// Fn, Fn-1, Fn-2
		// Index starts at 0 so that F0=0 and F1=F2=1

		if (n < 0 | n > 40) {
			throw new Exception("n should be a positive integer less than or equal to 40");
		}

		if (k < 0 | k > 5) {
			throw new Exception("k should be a positive integer less than or equal to 5");
		}

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		int Fn = 0;

		for (int i = 0; i <= n; i++) {
			Fn = fibonacciSequence(k, n - 1) + fibonacciSequence(k, n - 2) * k;
		}

		return Fn;
	}

}
