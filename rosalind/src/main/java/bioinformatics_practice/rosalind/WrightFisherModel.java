package bioinformatics_practice.rosalind;

public class WrightFisherModel {

	public static void main(String[] args) {
		try {
			int N = 4;
			int m = 6; //dominant allele
			int g = 2;
			int k = 1;
			if (N < 0 | N > 7) {
				throw new Exception("N must be a positive integer less than 7");
			}
			if (m < 0 | m > 2*N) {
				throw new Exception("m must be a positive integer less than 2*N");
			}
			if (g <= 0 | g > 6) {
				throw new Exception("g must be a positive integer less than 6");
			}
			if (k < 0 | k > 2*N) {
				throw new Exception("k must be a positive integer less than 2*N");
			}

//			double p = calculateProbability(N, m); //dominant allele
			double p = calculateProbability(N, (2*N-m)); //recessive allele
			double y = atLeastKCopiesOverGenerations(k, N, p, g);
			System.out.println("The probability of finding at least " + k + " copy(ies)"
					+ " of this gene \nin a population of " + N + " individuals \nover " + g
					+ " generations \nwith an initial probability of " + p + " is: \n" + y);
			
//			System.out.println("The probability of observing this calculated another way: " + atLeastKCopiesInGGenerations(k, N, p, g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static double atLeastKCopiesOverGenerations(int k, int N, double p, int g) throws Exception {
		double x = WFMoverGenerations(k, N, p, g);
		System.out.println("Probability of observing " + k + " copies: " + x + " over " + g + " generations.");
		
		for (int i = k+1; i<=(2*N); i++) {
			x = x + WFMoverGenerations(i, N, p, g);
			System.out.println("Probability of observing " + k + " to " + i + " copies: " + x + " over " + g + " generations.");
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

		double numerator = factorial(2*N) * Math.pow(p, k) * Math.pow(q, (2*N - k));
		double denominator = factorial(k) * factorial(2*N - k);

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
	
	/*********
	 * 
	 */
	
//	private static double atLeastKCopiesInOneGen(int k, int N, double p) throws Exception {
//		double x = wrightFisherModel(k, N, p);
//		System.out.println("Probability of observing " + k + " copies: " + x);
//		
//		for (int i = k+1; i<=(2*N); i++) {
//			x = x + wrightFisherModel(i, N, p);
//			System.out.println("Probability of observing " + k + " to " + i + " copies: " + x);
//		}
//		return x;
//	}
//	
//	private static double atLeastKCopiesInGGenerations(int k, int N, double p, int g) throws Exception {
//		double x= 0;
//		x = wrightFisherModel(k, N, p);
//		//copies loop then gen loop
//		for (int i=k+1; i<=2*N; i++) {
//			x = wrightFisherModel(i, N, p);
//			System.out.println(x);
//			for (int j=1; j<=g; j++) {
//				x = x + wrightFisherModel(i, N, x);	
//				System.out.println("k,j,x,N: " + k + " | " + j + " | "+ x + " | "+ N);
//			}
//		}
//		return x;
//	}

}
