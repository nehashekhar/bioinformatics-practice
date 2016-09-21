package bioinformatics_practice.rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * http://rosalind.info/problems/cons/
 * TODO: Checks for sequence lengths
 * TODO: Account for N's (nt that are not A/C/G/T)
 * @author nehashekhar
 *
 */
public class ConsensusAndProfile {

	public static void main(String[] args) {
		System.out.println("Reading from input file");
		ArrayList<String> sequences = new ArrayList<String>(); // Array of arbitrary size
		String consensus = "";

		try {
			// Get all the nt sequences as 1D array
			sequences = getInput("ConsensusAndProfileInput.txt");

			// 2D array for nt x frequency in each spot
			// Let order of rows be ACGT (hardcoded, alphabetical order)
			// Assuming no N's
			int[][] matrixATGC = new int[4][sequences.get(0).length()];

			// Initialize with zero values
			for (int j = 0; j <= matrixATGC.length - 1; j++) {
				matrixATGC[0][j] = 0;
				matrixATGC[1][j] = 0;
				matrixATGC[2][j] = 0;
				matrixATGC[3][j] = 0;
			}
			System.out.println("Matrix initialized");

			// Loop over all the sequences
			for (int k=0; k <= sequences.size()-1; k++) {
				String sequence1 = sequences.get(k);
				// Loop over length of sequence (should all be same)
				for (int i=0; i <= sequence1.length()-1; i++) {
					String nt = Character.toString(sequence1.charAt(i));
					switch (nt) {
					case "A": {
						matrixATGC[0][i]++;
						break;
						}
					case "C": {
						matrixATGC[1][i]++;
						break;
						}
					case "G": {
						matrixATGC[2][i]++;
						break;
						}
					case "T": {
						matrixATGC[3][i]++;
						break;
						}
					}
				}
			}
			
			//Print out the first element array for test
			System.out.println("Matrix populated\nGenerating consensus sequence");
			
			//Next, generate consensus sequence
			for (int l=0; l<=sequences.get(0).length()-1; l++) {
				//Get one column in the matrix
				int A = matrixATGC[0][l];
				int C = matrixATGC[1][l];
				int G = matrixATGC[2][l];
				int T = matrixATGC[3][l];
				//Find the max value of that column
				//Map that max value back to nt
				//Append to consensus sequence
				consensus = consensus + findConsensusNt(A, C, G, T);
			}
			System.out.println("Generated consensus");
			
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(consensus);
	}

	private static String findConsensusNt(int A, int C, int G, int T) {		
		if (A > G & A > C & A > T) {
			return "A";
		} else if (C > A & C > G & C > T) {
			return "C";
		} else if (G > A & G > C & G > T) {
			return "G";
		} else if (T > A & T > C & T > G) {
			return "T";
		} else {
			return "N";
		}
			
		
	}
	
	private static ArrayList<String> getInput(String filename) throws FileNotFoundException {
		// https://coderanch.com/t/323966/java/java/Loading-resource-static-method
		ClassLoader classLoader = ConsensusAndProfile.class.getClassLoader();
		File file = new File(classLoader.getResource(filename).getFile());
		Scanner scan = new Scanner(file);
		// Creating array of arbitrary size for now
////		String[] fileContents = new String[100]; 
		ArrayList<String> fileContentsA = new ArrayList<String>();
		int i = 0;

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if (!line.startsWith(">")) {
				System.out.println(line);
////				fileContents[i] = line;
				fileContentsA.add(line);
				i=i+1;
////				System.out.println("Array | " + fileContents[i]);
//				System.out.println("ArrayList | " + fileContentsA.get(0));
			}
		
		}

		return fileContentsA;
	}

}
