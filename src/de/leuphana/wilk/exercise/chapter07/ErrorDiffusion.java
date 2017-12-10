package de.leuphana.wilk.exercise.chapter07;

import de.leuphana.wilk.exercise.In;
import de.leuphana.wilk.exercise.Out;

public class ErrorDiffusion {

	public static void main(String[] arg) {
		In.open("uebung.uebung07.input.txt");
		Out.open("output.txt");
		int n = In.readInt();
		byte[][] m = new byte[n][n];
		byte val = (byte) In.readInt();
		while (In.done()) {
			// fill the matrix row by row
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (In.done()) {
						m[i][j] = val;
						val = (byte) In.readInt();
					} else
						m[i][j] = 0;
			// write the matrix column by column
			for (int j = 0; j < n; j++)
				for (int i = 0; i < n; i++)
					Out.print(m[i][j] + " ");
		}
		In.close();
		Out.close();
	}
}

/*
 * Sample input: 5 11 3 67 45 102 33 5 78
 */
