package bioinformatics_practice.utility;

import java.util.HashMap;

public class NucleotideUtil {
	// TODO: Tests for these methods
	public static HashMap<String, Integer> countNucleotides(String sequence) {
		int counterA = 0;
		int counterC = 0;
		int counterG = 0;
		int counterT = 0;

		for (int i = 0; i <= sequence.length() - 1; i++) {
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

		HashMap<String, Integer> count = new HashMap<String, Integer>();
		count.put("A", counterA);
		count.put("C", counterC);
		count.put("G", counterG);
		count.put("T", counterT);
		return count;
	}

	public static char dnaToRnaMapping(char n) {
		try {
			return Constants.dnaToRna.get(n);
		} catch (NullPointerException e) {
			return Constants.dnaToRna.get('N');
		}
	}

	public static String rnaToAminoAcidMapping(String xyz) throws Exception {
		if (xyz.length() != 3) {
			throw new Exception("This is not a codon.");
		}

		try {
			return Constants.rnaToAminoAcids.get(xyz);
		} catch (NullPointerException e) {
			return Constants.rnaToAminoAcids.get("UNKNOWN");
		}
	}

	public static char returnDnaComplement(char n) {
		try {
			return Constants.dnaComplement.get(n);
		} catch (NullPointerException e) {
			return Constants.dnaComplement.get('N');
		}
	}

	public static String returnDnaComplement(String seq) {
		String complement = "";
		for (int i = 0; i < seq.length(); i++) {
			complement = complement + returnDnaComplement(seq.charAt(i));
		}
		return complement;
	}
}
