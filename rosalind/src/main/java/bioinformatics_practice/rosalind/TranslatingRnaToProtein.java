package bioinformatics_practice.rosalind;

import bioinformatics_practice.utility.NucleotideUtil;

/**
 * http://rosalind.info/problems/prot/
 * 
 * @author nehashekhar
 *
 */
public class TranslatingRnaToProtein {

	public static void main(String[] args) {
		String s = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA";
		String protein = "";

		try {
			for (int i = 0; i <= s.length() - 1; i=i+3) {
				String codon = s.substring(i, i + 3);	
				String aminoAcid = NucleotideUtil.rnaToAminoAcidMapping(codon);
				if (aminoAcid!="Stop") {
					protein = protein + aminoAcid;
				} else {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(protein);
	}
}
