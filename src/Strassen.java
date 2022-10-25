import java.util.Vector;

public class Strassen {

	public int[][] strassen(int mat1[][], int mat2[][]) {

		int retour[][] = null;
		int n = mat1.length;
		if (!isPuissence2(n)) {
			mat1 = ajusterTaille(mat1, n);
			mat2 = ajusterTaille(mat2, n);
			n = mat1.length;
		}

		if (n == 1)
			return OPMat.mult(mat1, mat2);
		else {
			
			Vector<int[][]> part1 = this.partitionner(mat1);
			Vector<int[][]> part2 = this.partitionner(mat2);

			int[][] A11 = part1.elementAt(0);
			int[][] A12 = part1.elementAt(1);
			int[][] A21 = part1.elementAt(2);
			int[][] A22 = part1.elementAt(3);
			int[][] B11 = part2.elementAt(0);
			int[][] B12 = part2.elementAt(1);
			int[][] B21 = part2.elementAt(2);
			int[][] B22 = part2.elementAt(3);


			int[][] p1 = strassen(OPMat.add(A11, A22), OPMat.add(B11, B22));
			int[][] p2 = strassen(OPMat.add(A21, A22), B11);
			int[][] p3 = strassen(A11, OPMat.sous(B12, B22));
			int[][] p4 = strassen(A22, OPMat.sous(B21, B11));
			int[][] p5 = strassen(OPMat.add(A11, A12), B22);
			int[][] p6 = strassen(OPMat.sous(A21, A11), OPMat.add(B11, B12));
			int[][] p7 = strassen(OPMat.sous(A12, A22), OPMat.add(B21, B22));


			int C11[][] = OPMat.add(OPMat.sous(OPMat.add(p1, p4), p5), p7);
			int C12[][] = OPMat.add(p3, p5);
			int C21[][] = OPMat.add(p2, p4);
			int C22[][] = OPMat.add(OPMat.sous(OPMat.add(p1, p3), p2), p6);

			retour = Combiner(C11, C12, C21, C22);
		}

		return retour;

	}

	private int[][] Combiner(int[][] c11, int[][] c12, int[][] c21, int[][] c22) {
		int sizeDiv2 = c11.length;
		int size = c11.length * 2;

		int[][] retour = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i < sizeDiv2) {
					if (j < sizeDiv2) {
						retour[i][j] = c11[i][j];
					} else {
						retour[i][j] = c12[i][j - sizeDiv2];
					}
				} else {
					if (j < sizeDiv2) {
						retour[i][j] = c21[i - sizeDiv2][j];
					} else {
						retour[i][j] = c22[i - sizeDiv2][j - sizeDiv2];
					}
				}
			}
		}
		return retour;
	}

	public int[][] ajusterTaille(int mat1[][], int n) {

		int x = (int) Psupp(n);
		int temp[][] = new int[x][x];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = mat1[i][j];
			}
		}

		mat1 = temp;

		return mat1;

	}
	
	public int[][] reajusterTaille(int mat[][], int n) {
		
		int temp[][] = new int[n][n];
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				temp[i][j] = mat[i][j];
			}
		}
		mat = temp;
		return mat;
	}

	public boolean isPuissence2(int n) {

		for (int i = 0; i <= n / 2; i++) {
			double p = Math.pow(2, i);
			if (p == n)
				return true;
			else if (p > n)
				break;
		}

		return false;

	}

	public int Psupp(int n) {
		double p = 0;
		for (int i = 0; i < n; i++) {
			p = Math.pow(2, i);
			if (p == n)
				return (int) p;
			else if (p > n)
				break;
		}

		return (int) p;

	}

	public void afficher(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(" " + mat[i][j]);
			}
			System.out.println("\n");
		}
	}

	public Vector<int[][]> partitionner(int a[][]) {
		Vector<int[][]> v = new Vector<int[][]>();
		int m = a.length / 2;
		int temp[][] = new int[m][m];
		int temp1[][] = new int[m][m];
		int temp2[][] = new int[m][m];
		int temp3[][] = new int[m][m];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i < m) {
					if (j < m) {
						temp[i][j] = a[i][j];
					} else {
						temp1[i][j - m] = a[i][j];
					}
				} else {
					if (j < m) {
						temp2[i - m][j] = a[i][j];
					} else {
						temp3[i - m][j - m] = a[i][j];
					}
				}
			}
		}

		
		v.add(temp);
		
		v.add(temp1);
		
		v.add(temp2);
		
		v.add(temp3);
		return v;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
