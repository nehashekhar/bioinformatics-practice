package bioinformatics_practice.rosalind;

/**
 * http://rosalind.info/problems/iprb/
 * @author nehashekhar
 *
 */
public class MendelsFirstLaw {

	public static void main(String[] args) {
		int k = 2; //homozygous dominant
		int m = 2; //heterozygous
		int n = 2; //homozygous recessive
		
		double pK = (double) k/(k+m+n);
		double pM = (double) m/(k+m+n);
		double pN = (double) n/(k+m+n);
		double totalPopulation = k+m+n;
		
		double Pdominantphenotype = 0;
		
		//k+k
		double pKK = pK * (k-1)/(totalPopulation-1) * 1;
		//k+m
		double pKM = pK * (m)/(totalPopulation-1) * 1;
		//k+n
		double pKN = pK * (n)/(totalPopulation-1) * 1;
		
		//m+k
		double pMK = pM * (k)/(totalPopulation-1) * 1;	
		//m+m
		double pMM = pM * (m-1)/(totalPopulation-1) * 3/4;
		//m+n
		double pMN = pM * (n)/(totalPopulation-1) * 1/2;
		
		//n+k
		double pNK = pN * (k)/(totalPopulation-1) * 1;
		//n+m
		double pNM = pN * (m)/(totalPopulation-1) * 1/2;
		//n+n
		double pNN = pN * (n-1)/(totalPopulation-1) * 0;
		
		
		Pdominantphenotype = (pKK + pKM + pKN + 
		pMK + pMM + pMN + 
		pNK + pNM + pNN);
		
		System.out.println("Probability that an offspring will have dominant phenotype: " + Pdominantphenotype);
	}
	
}
