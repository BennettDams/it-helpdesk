package de.leuphana.wilk.exercise.chapter07;

import de.leuphana.wilk.exercise.In;
import de.leuphana.wilk.exercise.Out;

public class MatrixMultiplication {

	// Read a matrix of integers from the input stream
	static int[][] readMatrix() {
		int n = In.readInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = In.readInt();
		return a;
	}

	// Print a
	static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				Out.print(a[i][j] + " ");
			Out.println();
		}
	}

	// Check if a is symmetric
	static boolean isSymmetric(int[][] a) {
		for (int i = 0; i < a.length; i++)
			for (int j = i + 1; j < a[0].length; j++)
				if (a[i][j] != a[j][i])
					return false;
		return true;
	}

	// Transform a into a triangular matrix
	static void transform(int[][] a) {
		for (int i = 1; i < a.length; i++)
			for (int j = 0; j < i; j++)
				a[i][j] = 0;
	}

	public static void main(String[] arg) {
		In.open("input.txt");
		int[][] a = readMatrix();
		Out.println("Eingabe: ");
		printMatrix(a);
		if (isSymmetric(a)) {
			transform(a);
			Out.println();
			Out.println("Die Matrix ist symmetrisch und wurde konvertiert zu:");
			printMatrix(a);
		}
		In.close();

	}
}

/*
 * Sample input: 4 1 2 3 4 2 4 6 8 3 6 7 1 4 8 1 9
 * 
 * 4 1 2 3 4 2 4 6 8 3 6 7 1 4 8 1 9
 * 
 */
