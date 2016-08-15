package bioinformatics_practice.rosalind;

public class WrightFisherModel {

	public static void main(String[] args) {
		try {
			int k = 1;
			int N = 4;
			int m = 6;
			int g = 2;
			double p = 1 - calculateProbability(N, m);
			double y = atLeastKCopiesOverGenerations(k, N, p, g);
			System.out.println("The probability of finding at least " + k + " copy(ies)" +
			" of this gene in a population of " + N + " individuals over " 
		+ g + " generations is with an initial probability of " + p + " is: " + y);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static double atLeastKCopiesOverGenerations(int k, int N, double p, int g) throws Exception {
		double x = 0;
		for (int i = k; i <= (2*N); i++) {
			x = x + WFMoverGenerations(i, N, p, g);
		}
		return x;
	}

	/*
	 * This function calculates the WFM probability over g generations
	 */
	static double WFMoverGenerations(int k, int N, double p, int g) throws Exception {
		double probabilityOverGenerations = p;

		for (int i = 0; i <= g; i++) {
			probabilityOverGenerations = WrightFisherModel(k, N, probabilityOverGenerations);
		}

		return probabilityOverGenerations;
	}

	/*
	 * This function returns the probability of finding k copies of an allele N
	 * - number of diploid individuals in population p - frequency of one allele
	 * in previous generation q - frequency of other allele in previous
	 * generation k - expected copies of an allele found in a generation
	 */
	static double WrightFisherModel(int k, int N, double p) throws Exception {
		double q = 1 - p;

		double numerator = factorial(2 * N) * Math.pow(p, k) * Math.pow(q, (2 * N - k));
		double denominator = factorial(k) * factorial(2 * N - k);

		return numerator / denominator;
	}

	/*
	 * This function calculates the factorial of a number
	 */
	static int factorial(int N) throws Exception {
		if (N > 1) {
			N = N * factorial(N - 1);
			return N;
		} else if (N == 0 | N == 1) {
			return 1;
		} else {
			throw new Exception("Factorial for " + N + " is undefined.");
		}
	}

	static double calculateProbability(int N, int m) {
		double p = ((double) m) / ((double) (N * 2));
		return p;
	}
}
