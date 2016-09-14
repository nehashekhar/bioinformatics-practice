package bioinformatics_practice.rosalind;

import java.util.HashMap;

public class WrightFisherModel {

	public static void main(String[] args) {
		try {
			int N = defineN();
			int m = defineM(); // dominant allele
			int g = defineG();
			int k = defineK();
			
			//Check values
			if (N < 0 | N > 7) {
				throw new Exception("N must be a positive integer less than 7");
			}
			if (m < 0 | m > 2 * N) {
				throw new Exception("m must be a positive integer less than 2*N");
			}
			if (g <= 0 | g > 6) {
				throw new Exception("g must be a positive integer less than 6");
			}
			if (k < 0 | k > 2 * N) {
				throw new Exception("k must be a positive integer less than 2*N");
			}

			//Calculate probability of recessive allele
			double p = 1- calculateProbability(N, m);
			double prob = 0;
			for (int atLeastK = k; atLeastK <= 2 * N; atLeastK++) {
				prob = prob + probabilityOverGenerationsAndCopyNumbers(atLeastK, N, p, g);
			}
			System.out.println("The probability of finding at least " + k + " copy(ies)"
					+ " of this gene \nin a population of " + N + " individuals \nafter " + g
					+ " generations \nwith an initial probability of " + p + " is: \n" + prob);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * These methods below define the parameters used in calculation.
	 * They can be changed to read from file, take user input, etc.
	 */
	public static int defineN() {
		return 4;
	}
	
	public static int defineM() {
		return 6;
	}
	
	public static int defineG() {
		return 2;
	}
	
	public static int defineK() {
		return 1;
	}

	/*
	 * This function returns the probability of finding k copies of an allele N
	 * - number of diploid individuals in population p - frequency of one allele
	 * in previous generation q - frequency of other allele in previous
	 * generation k - expected copies of an allele found in a generation
	 */
	static double wrightFisherModel(int k, int N, double p) throws Exception {
		double q = 1 - p;

		double numerator = factorial(2 * N) * Math.pow(p, k) * Math.pow(q, (2 * N - k));
		double denominator = factorial(k) * factorial(2 * N - k);

		return (numerator / denominator);
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

	static double probabilityOverGenerationsAndCopyNumbers(int k, int N, double p, int g) throws Exception {
		int totalAlleles = 2 * N;
		// For each generation, we have p of allellic frequency given p of allelic
		// frequency of previous generation
		// Loop over allelic frequencies by generation
		// E.g. g0=p0, g1=p|p0, p2|p0, p3|p0, etc. until p2N
		// g2=p|p0 from g1, p|p1 from g1, etc.
		// g3=p|p0 from g2

		// HashMap where key=number of alleles in a generation, p=probability of
		// getting k in a generation (changes generationally)
		HashMap<Integer, Double> allelicFreqVsProbability = new HashMap<Integer, Double>();

		// First generation; seed values
		for (int mAlleles = 0; mAlleles <= totalAlleles; mAlleles++) {
			double pN = wrightFisherModel(mAlleles, N, p);
			allelicFreqVsProbability.put(mAlleles, pN);
		}
		
		// Second generation and onwards
		for (int generation = 2; generation <= g; generation++) {
			for (int k2 = 0; k2 <= totalAlleles; k2++) {
				double pN2 = 0;
				for (int mAlleles = 0; mAlleles <= totalAlleles; mAlleles++) {
					double pPreviousGen = allelicFreqVsProbability.get(mAlleles);
					double pN = wrightFisherModel(k2, N, calculateProbability(N, mAlleles));

					// Weighted sum (total law of probability): Probability of A  =
					// Probability of A given B times probability of B
					// Where A is finding k copies of allele in current generation
					// And B is probability of finding the allele in previous generation
					pN2 = pN2 + (pN * pPreviousGen);
				}
				allelicFreqVsProbability.put(k2, pN2);
				System.out.println("Generation " + generation + " | Cumulative probability of getting " + k2 + " copies: " + pN2);
			}			
		}

		return allelicFreqVsProbability.get(k);
	}

}
