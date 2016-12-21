package bioinformatics_practice.rosalind;

import bioinformatics_practice.utility.NucleotideUtil;

/**
 * Reversing and finding the complement of a nucleotide sequence
 * http://rosalind.info/problems/revc/
 * 
 * @author nehashekhar
 *
 */
public class ComplementingStrandOfDna {

	public static void main(String[] args) {
		String sequence = "AAAACCCGGT";
		String sC = "";

		sC = NucleotideUtil.returnDnaComplement(sequence);

		System.out.println("The reverse complement of " + sequence + " is " + sC);
	}

}
