package bioinformatics_practice.rosalind;

import bioinformatics_practice.utility.NucleotideUtil;

/**
 * http://rosalind.info/problems/rna/
 * @author nehashekhar
 *
 */
public class TranscribingDnaToRna {

	public static void main(String[] args) throws Exception {
		String sequence = "GATGGAACTTGACTACGTAAATT";
		
		if (sequence.length()>1000) {
			throw new Exception("Sequence is over 1000 nt.");
		}
		
		String sRna = "";
		
		for (int i=0; i<=sequence.length()-1; i++) {
			char n = sequence.charAt(i);
			sRna = sRna + NucleotideUtil.dnaToRnaMapping(n);
		}
		
		System.out.println("The RNA equivalent of the sequence " + sequence + " is " + sRna);
	}
	

	
}
