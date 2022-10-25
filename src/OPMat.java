
public class OPMat {

	public static int[][] mult(int a[][], int b[][]) {

		int retour[][] = new int[a.length][a.length];
		int temp = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {

				for (int k = 0; k < a.length; k++) {
					temp = temp + a[i][k] * b[k][j];
				}
				retour[i][j] = temp;
				temp = 0;
			}

		}

		return retour;
	}

	public static int[][] add(int a[][], int b[][]) {
		int retour[][] = new int[a.length][a.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				 retour[i][j] = a[i][j] + b[i][j];
			}
		}
		
		return retour;

	}
	
	public static int[][] sous(int a[][], int b[][]) {
		int retour[][] = new int[a.length][a.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				 retour[i][j] = a[i][j] - b[i][j];
			}
		}
		
		return retour;

	}
	
	public static int[][] genererPair(int l, int c) {
		
		int mat[][] = new int[l][c];
		int nbPair[] = new int[c*l];
		
		int temp = 0;
		int indice = 0;
		while(indice < l*c) {
			if(temp % 2 == 0) {
				nbPair[indice] = temp;
				indice++;
			}
			temp++;
		}
		
		indice = 0;
		for(int i = 0;i < l;i++) {
			for(int j = 0;j < c;j++) {
				mat[i][j] = nbPair[indice];
				indice++;
			}
		}
		
		return mat;
		
	}
	
	
public static int[][] genererImpair(int l, int c) {
		
		int mat[][] = new int[l][c];
		int nbPair[] = new int[c*l];
		
		int temp = 0;
		int indice = 0;
		while(indice < l*c) {
			if(temp % 2 == 1) {
				nbPair[indice] = temp;
				indice++;
			}
			temp++;
		}
		
		indice = 0;
		for(int i = 0;i < l;i++) {
			for(int j = 0;j < c;j++) {
				mat[i][j] = nbPair[indice];
				indice++;
			}
		}
		
		return mat;
		
	}
	
	
}
