package com.akki;


public class MatrixProb {
	int[][] mat = new int[3][3];

	public static void main(String[] args) {

		final int[][] matrix = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		int[][] matrixNew = new int[3][3];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// System.out.print(matrix[i][j] + " ");
				if (matrix[i][j] == 1) {
					for (int n = 0; n < matrix[i].length; n++) {
						matrixNew[i][n] = 1;
					}
					for (int m = 0; m < matrix.length; m++) {
						matrixNew[m][j] = 1;
					}
				}
			}
		}

		for (int i = 0; i < matrixNew.length; i++) {
			for (int j = 0; j < matrixNew[i].length; j++) {
				System.out.print(matrixNew[i][j] + " ");
			}
			System.out.println();
		}
	}
}
