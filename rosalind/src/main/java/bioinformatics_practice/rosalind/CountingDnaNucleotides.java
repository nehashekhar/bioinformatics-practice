package bioinformatics_practice.rosalind;

/**
 * http://rosalind.info/problems/rna/
 * @author nehashekhar
 *
 */
public class CountingDnaNucleotides {
	
	//TODO: Tests for these methods
	public static void main(String[] args) {
		int counterA = 0;
		int counterC = 0;
		int counterG = 0;
		int counterT = 0;
		
		String sequence = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
		
		for (int i=0; i<=sequence.length()-1; i++) {
			char j = sequence.charAt(i);
			switch (j) {
			case 'A': {
				counterA++;
				break;
			}
			case 'T': {
				counterT++;
				break;
			}
			case 'C': {
				counterC++;
				break;
			}
			case 'G': {
				counterG++;
				break;
			}
			}
		}
		
		System.out.println("A: " + counterA + " | C: " + counterC + " | G: " + counterG + " | T: " + counterT);
	}

}
