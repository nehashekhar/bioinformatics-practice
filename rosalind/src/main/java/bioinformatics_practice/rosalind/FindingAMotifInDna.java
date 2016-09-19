package bioinformatics_practice.rosalind;

/**
 * http://rosalind.info/problems/subs/
 * @author nehashekhar
 *
 */
public class FindingAMotifInDna {

	public static void main(String[] args) {
		String s = "GATATATGCATATACTT";
		String t = "ATAT";

		int index = 0;

		for (int i = 0; i <= s.length() - 1; i++) {
			try {
				if ((s.substring(i, i + t.length()).equals(t))) {
					System.out.println("Index of match (index starts at 1): " + (i + 1));
				}
			} catch (Exception e) {
				break;
			}
		}
	}

}
