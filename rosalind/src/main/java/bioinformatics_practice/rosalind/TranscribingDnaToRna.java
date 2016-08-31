package bioinformatics_practice.rosalind;

/**
 * http://rosalind.info/problems/rna/
 * @author nehashekhar
 *
 */
public class TranscribingDnaToRna {

	//TODO: Tests for these methods
	public static void main(String[] args) throws Exception {
		String sequence = "GATGGAACTTGACTACGTAAATT";
		
		if (sequence.length()>1000) {
			throw new Exception("Sequence is over 1000 nt.");
		}
		
		String sRna = "";
		
		for (int i=0; i<=sequence.length()-1; i++) {
			char n = sequence.charAt(i);
			sRna = sRna + returnRnaEquivalent(n);
		}
		
		System.out.println("The RNA equivalent of the sequence " + sequence + " is " + sRna);
	}
	
	public static char returnRnaEquivalent(char n) {
		char complement = 'N';

		switch (n) {
		case 'A': {
			complement = 'A';
			break;
		}
		case 'C': {
			complement = 'C';
			break;
		}
		case 'G': {
			complement = 'G';
			break;
		}
		case 'T': {
			complement = 'U';
			break;
		}
		}

		return complement;
	}
	
}
