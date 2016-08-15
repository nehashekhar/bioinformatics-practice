package bioinformatics_practice.rosalind;

import java.util.HashMap;

public class WrightFisherModel {

	public static void main(String[] args) {
		try {
			int N = 4;
			int m = 6; // dominant allele
			int g = 2;
			int k = 1;
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

			// double p = calculateProbability(N, m); //dominant allele
			double p = calculateProbability(N, (2 * N - m)); // recessive allele
			double y = atLeastKCopiesOverGenerations(k, N, p, g);
			System.out.println("The probability of finding at least " + k + " copy(ies)"
					+ " of this gene \nin a population of " + N + " individuals \nover " + g
					+ " generations \nwith an initial probability of " + p + " is: \n" + y);

			System.out.println("Another approach: " + probabilityOverGenerationsAndCopyNumbers(k, N, p, g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static double atLeastKCopiesOverGenerations(int k, int N, double p, int g) throws Exception {
		double x = 0;

		for (int i = k; i <= (2 * N); i++) {
			x = x + WFMoverGenerations(i, N, p, g);
			System.out.println(
					"Probability of observing " + k + " to " + i + " copies: " + x + " over " + g + " generations.");
		}
		return x;
	}

	/*
	 * This function calculates the WFM probability over g generations
	 */
	static double WFMoverGenerations(int k, int N, double p, int g) throws Exception {
		double probabilityOverGenerations = p;

		for (int i = 1; i <= g; i++) {
			probabilityOverGenerations = wrightFisherModel(k, N, probabilityOverGenerations);
			System.out.println("Generation: " + i + " | " + probabilityOverGenerations);
		}

		return probabilityOverGenerations;
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

	/*********
	 * 
	 */

	private static double probabilityOverGenerationsAndCopyNumbers(int k, int N, double p, int g) throws Exception {
		System.out.println("------");
		// For each generation, we have allelelic frequency given alleleic
		// frequency of previous generation
		// Loop over alleleic frequencies by generation
		// E.g. g0=p0, g1=p|p0, p2|p0, p3|p0, etc. until pN
		// g2=p|p0 from g1, p|p1 from g1, etc.
		// g3=p|p0 from g2

		// HashMap where key=number of alleles in a generation, p=probability of
		// getting k in a generation (changes generationally)
		HashMap<Integer, Double> allelicFreqVsProbability = new HashMap<Integer, Double>();

		// First generation
		double g1sum = 0;
		for (int allelicFreq = 0; allelicFreq <= 2 * N; allelicFreq++) {
			double pN = wrightFisherModel(allelicFreq, N, p);
			System.out.println(
					"G1 probability of getting " + allelicFreq + " copies given p(previous gen) = " + p + "| " + pN);
			allelicFreqVsProbability.put(allelicFreq, pN);
			g1sum = g1sum + pN;
		}
		System.out.println("G1SUM: " + g1sum);

		// Second generation
		for (int k2 = 0; k2 <= 2 * N; k2++) {
			double pN2 = 0;
			for (int allelicFreq = 0; allelicFreq <= 2 * N; allelicFreq++) {
				double pPreviousGen = allelicFreqVsProbability.get(allelicFreq);
				double pN = wrightFisherModel(k2, N, calculateProbability(N, allelicFreq));
				System.out.println("G2 probability of getting " + k2 + " copies given previous gen had " + allelicFreq
						+ " copies and p " + pPreviousGen + " | " + pN);

				//Probability of getting X copies (variable) given Y in previous gen (fixed) sums to 1
				//NOT probability of getting X copies (fixed) given Y in previous gen (variable)
				//Weighted sum? Probability of A given B times probability of B
				pN2 = pN2 + pN*pPreviousGen;
			}
			allelicFreqVsProbability.put(k2, pN2);
			System.out.println("Cumulative probability of getting " + k2 + " copies: " + pN2);
		}
		
		double G2SUM = 0;
		for (int allelicFreq = 1; allelicFreq <= 2 * N; allelicFreq++) {
			G2SUM = G2SUM + allelicFreqVsProbability.get(allelicFreq);
		}
		System.out.println("G2SUM: " + G2SUM);

		System.out.println("allelicFreqVsProbability.get(k): " + allelicFreqVsProbability.get(k));
		return allelicFreqVsProbability.get(k);

	}

}
