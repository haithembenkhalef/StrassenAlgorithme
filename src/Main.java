import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// System.out.println(s.isPuissence2(n*n));
		// System.out.println(s.Psupp(n*n));

		Strassen s = new Strassen();

		int n = 14;
		int mat[][] = OPMat.genererPair(n, n);
		int mat1[][] = OPMat.genererImpair(n, n);

		System.out.println("Matrice pair :");
		s.afficher(mat);
		System.out.println("Matrice impair :");
		s.afficher(mat1);

		System.out.println("Multiplication en cours.. ");
		long t1 = System.currentTimeMillis();
        
		//Multiplication strassen 
		int mult[][] = s.strassen(mat, mat1);
		if (mult.length > n)
			s.afficher(s.reajusterTaille(mult, n));
		else
			s.afficher(mult);
		
		//Multiplication classique
		 //s.afficher((OPMat.mult(mat, mat1)));

		long t2 = System.currentTimeMillis();
		float finale = (float) ((t2 - t1) / 1000.0);
		System.out.println("Temps d'execution de la multiplication :" + finale+" s");

	}

}
