package bioinformatics_practice.rosalind;

public class WrightFisherModel {

	
	static int factorial(int N) throws Exception{
		if (N > 1) {
			N = N * factorial(N-1);
			return N;
		} else if (N==0 | N==1) {
			return 1;
		} else {
			throw new Exception("Factorial for " + N + " is undefined.");
		}
	}
}
