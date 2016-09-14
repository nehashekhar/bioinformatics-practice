package bioinformatics_practice.rosalind;

import java.util.HashMap;

import bioinformatics_practice.utility.NucleotideUtil;

/**
 * http://rosalind.info/problems/rna/
 * @author nehashekhar
 *
 */
public class CountingDnaNucleotides {
	
	//TODO: Tests for these methods
	public static void main(String[] args) {
		String sequence = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
		
		HashMap<String, Integer> counter = NucleotideUtil.countNucleotides(sequence);
		int counterA = counter.get("A");
		int counterC = counter.get("C");
		int counterG = counter.get("G");
		int counterT = counter.get("T");
		
		System.out.println("A: " + counterA + " | C: " + counterC + " | G: " + counterG + " | T: " + counterT);
	}

}
