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
			double prob = 0;
			for (int atLeastK = k; atLeastK <= 2 * N; atLeastK++) {
				prob = prob + probabilityOverGenerationsAndCopyNumbers(atLeastK, N, p, g);
			}
			System.out.println("The probability of finding at least " + k + " copy(ies)"
					+ " of this gene \nin a population of " + N + " individuals \nover " + g
					+ " generations \nwith an initial probability of " + p + " is: \n" + prob);

		} catch (Exception e) {
			e.printStackTrace();
		}
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
		System.out.println("------");
		int totalAlleles = 2 * N;
		// For each generation, we have p of allellic frequency given p of allelic
		// frequency of previous generation
		// Loop over allelic frequencies by generation
		// E.g. g0=p0, g1=p|p0, p2|p0, p3|p0, etc. until pN
		// g2=p|p0 from g1, p|p1 from g1, etc.
		// g3=p|p0 from g2

		// HashMap where key=number of alleles in a generation, p=probability of
		// getting k in a generation (changes generationally)
		HashMap<Integer, Double> allelicFreqVsProbability = new HashMap<Integer, Double>();

		// First generation; seed values
		double g1sum = 0;
		for (int mAlleles = 0; mAlleles <= totalAlleles; mAlleles++) {
			double pN = wrightFisherModel(mAlleles, N, p);
			System.out.println(
					"G1 probability of getting " + mAlleles + " copies given p(previous gen) = " + p + "| " + pN);
			allelicFreqVsProbability.put(mAlleles, pN);
			g1sum = g1sum + pN;
		}
		System.out.println("G1SUM: " + g1sum);

		// Second generation and onwards
		for (int generation = 2; generation <= g; generation++) {
			for (int k2 = 0; k2 <= totalAlleles; k2++) {
				double pN2 = 0;
				for (int mAlleles = 0; mAlleles <= totalAlleles; mAlleles++) {
					double pPreviousGen = allelicFreqVsProbability.get(mAlleles);
					double pN = wrightFisherModel(k2, N, calculateProbability(N, mAlleles));

					// Weighted sum (total law of probability): Probability of A
					// given B times probability of B
					pN2 = pN2 + (pN * pPreviousGen);
				}
				allelicFreqVsProbability.put(k2, pN2);
				System.out.println("G2 Cumulative probability of getting " + k2 + " copies: " + pN2);
			}
			
			// Check to ensure that probabilities sum to 1 in each generation
			double GNSUM = 0;
			for (int allelicFreq = 0; allelicFreq <= totalAlleles; allelicFreq++) {
				GNSUM = GNSUM + allelicFreqVsProbability.get(allelicFreq);
			}
			System.out.println("GNSUM: " + GNSUM);
		}

		return allelicFreqVsProbability.get(k);
	}

}
