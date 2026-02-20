
public class MatrixMultiplication {

	public MatrixMultiplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[][] A = {{1,2,}, {3,4}};
int[][] B = {{6,7}, {8,9}};

int[][] C = new int[A.length][B[0].length];

for(int i= 0; i< 2; i++) {
	for (int j = 0; j<2; j++) {
		for(int k=0; k<2;k++) {
			C[i][j]+=A[i][k]*B[k][j];
		}
	}
}
for(int i =0; i<2; i++) {
	for(int j=0; j<2; j++) {
		System.out.print(C[i][j]   +  " ");
}
	System.out.println();
	}
}
}
