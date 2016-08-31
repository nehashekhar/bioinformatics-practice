package bioinformatics_practice.rosalind;

/**
 * Reversing and finding the complement of a nucleotide sequence
 * http://rosalind.info/problems/revc/
 * 
 * @author nehashekhar
 *
 */
public class ComplementingStrandOfDna {

	//TODO: Tests for these methods
	public static void main(String[] args) {
		String sequence = "AAAACCCGGT";
		String sC = "";

		for (int i = sequence.length() - 1; i >= 0; i--) {
			char n = sequence.charAt(i);
			char nC = returnComplement(n);
			sC = sC + nC;
		}

		System.out.println("The reverse complement of " + sequence + " is " + sC);
	}

	public static char returnComplement(char n) {
		char complement = 'N';

		switch (n) {
		case 'A': {
			complement = 'T';
			break;
		}
		case 'C': {
			complement = 'G';
			break;
		}
		case 'G': {
			complement = 'C';
			break;
		}
		case 'T': {
			complement = 'A';
			break;
		}
		}

		return complement;
	}
}
