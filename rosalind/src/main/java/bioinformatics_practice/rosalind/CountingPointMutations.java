package bioinformatics_practice.rosalind;

/**
 * http://rosalind.info/problems/hamm/
 * @author nehashekhar
 *
 */
public class CountingPointMutations {
	
	public static void main(String[] args) {
		String s = "GAGCCTACTAACGGGAT";
		String t = "CATCGTAATGACGGCCT";
		
		int dH = 0;
		
		try {
			dH = countHammingDistance(s, t);
			System.out.println("Hamming distance: " + dH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static int countHammingDistance(String s, String t) throws Exception {
		if (s.length()!=t.length()) {
			throw new Exception("Sequence lengths are different.");
		}
		
		if (s.length() > 1000 || t.length() > 1000) {
			throw new Exception("Sequences are longer than 1kbp");
		}
		
		int diffCounter = 0;
		for (int i=0; i <= s.length()-1; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				diffCounter++;
			}
		}
		
		return diffCounter;
	}
}
