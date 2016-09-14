package bioinformatics_practice.utility;

import java.util.HashMap;

public class NucleotideUtil {

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
}
