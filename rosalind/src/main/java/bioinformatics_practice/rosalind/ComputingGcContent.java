package bioinformatics_practice.rosalind;

import java.util.HashMap;
import bioinformatics_practice.utility.NucleotideUtil;

/**
 * http://rosalind.info/problems/gc/
 * @author nehashekhar
 *
 */
public class ComputingGcContent {

	public static void main(String[] args) {
		String fastaFile = ">Rosalind_6404\nCCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCCTCCCACTAATAATTCTGAGG\n"
				+ ">Rosalind_5959\nCCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAGGCGCTCCGCCGAAGGTCTATATCCATTTGTCAGCAGACACGC\n"
				+ ">Rosalind_0808\nCCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGACTGGGAACCTGCGGGCAGTAGGTGGAAT";
				
		String[] lines = fastaFile.split("\n>");
		double highestGcContent = 0;
		String lineWithHighestContent = "";
		
		for (int i=0; i<=lines.length-1; i++) {
			String line = lines[i];
			String[] lineValues = line.split("\n");
			double gcContentOfLine = calculateGcContent(lineValues[1]);
			if (gcContentOfLine > highestGcContent) {
				highestGcContent = gcContentOfLine;
				lineWithHighestContent=line;
			}
		}
		
		System.out.println(lineWithHighestContent + "\n" + highestGcContent);
	}
	
	private static double calculateGcContent(String l) {
		HashMap<String, Integer> nt = NucleotideUtil.countNucleotides(l);
		
		double gC = ((double) (nt.get("C") + nt.get("G"))/l.length())*100;
		
		return gC;
	}
}
