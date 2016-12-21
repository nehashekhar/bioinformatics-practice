package bioinformatics_practice.utility;

import java.util.HashMap;

public class Constants {

	public static final HashMap<Character, Character> dnaToRna = new HashMap<Character, Character>() {{
		put('A', 'A');
		put('T', 'U');
		put('C', 'C');
		put('G', 'G');
		put('N', 'N');
	}};
	
	public static final HashMap<Character, Character> dnaComplement = new HashMap<Character, Character>() {{
		put('A', 'T');
		put('T', 'A');
		put('G', 'C');
		put('C', 'G');
		put('N', 'N');
	}};
	
	public static final HashMap<String, String> rnaToAminoAcids = new HashMap<String, String>() {
		{
			put("UUU", "F");
			put("CUU", "L");
			put("AUU", "I");
			put("GUU", "V");
			put("UUC", "F");
			put("CUC", "L");
			put("AUC", "I");
			put("GUC", "V");
			put("UUA", "L");
			put("CUA", "L");
			put("AUA", "I");
			put("GUA", "V");
			put("UUG", "L");
			put("CUG", "L");
			put("AUG", "M");
			put("GUG", "V");
			put("UCU", "S");
			put("CCU", "P");
			put("ACU", "T");
			put("GCU", "A");
			put("UCC", "S");
			put("CCC", "P");
			put("ACC", "T");
			put("GCC", "A");
			put("UCA", "S");
			put("CCA", "P");
			put("ACA", "T");
			put("GCA", "A");
			put("UCG", "S");
			put("CCG", "P");
			put("ACG", "T");
			put("GCG", "A");
			put("UAU", "Y");
			put("CAU", "H");
			put("AAU", "N");
			put("GAU", "D");
			put("UAC", "Y");
			put("CAC", "H");
			put("AAC", "N");
			put("GAC", "D");
			put("UAA", "Stop");
			put("CAA", "Q");
			put("AAA", "K");
			put("GAA", "E");
			put("UAG", "Stop");
			put("CAG", "Q");
			put("AAG", "K");
			put("GAG", "E");
			put("UGU", "C");
			put("CGU", "R");
			put("AGU", "S");
			put("GGU", "G");
			put("UGC", "C");
			put("CGC", "R");
			put("AGC", "S");
			put("GGC", "G");
			put("UGA", "Stop");
			put("CGA", "R");
			put("AGA", "R");
			put("GGA", "G");
			put("UGG", "W");
			put("CGG", "R");
			put("AGG", "R");
			put("GGG", "G");
			put("UNKNOWN", "X");
		}
	};

}
