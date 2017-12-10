package de.leuphana.wilk.uebung.kapitel07;

import de.leuphana.wilk.uebung.In;
import de.leuphana.wilk.uebung.Out;

public class GameOfLife {

	// Read the initial population into a matrix
	static boolean[][] readPopulation() {
		In.open("input.txt");
		int lines = In.readInt();
		int cols = In.readInt();
		In.read();
		In.read(); // CR, LF
		boolean[][] cell = new boolean[lines][cols];
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < cols; j++)
				cell[i][j] = In.read() == 'x';
			In.read();
			In.read(); // CR, LF
		}
		In.close();
		return cell;
	}

	// Print the matrix cell
	static void printPopulation(boolean[][] cell) {
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[0].length; j++)
				if (cell[i][j])
					Out.print('x');
				else
					Out.print('.');
			Out.println();
		}
		Out.println();
	}

	// Return the number of neighbors of cell[i][j]
	static int neighbors(boolean[][] cell, int i, int j) {
		int n = 0;
		int il = i == 0 ? cell.length - 1 : i - 1;
		int ir = (i + 1) % cell.length;
		int jl = j == 0 ? cell[0].length - 1 : j - 1;
		int jr = (j + 1) % cell[0].length;
		if (cell[il][jl])
			n++;
		if (cell[il][j])
			n++;
		if (cell[il][jr])
			n++;
		if (cell[i][jl])
			n++;
		if (cell[i][jr])
			n++;
		if (cell[ir][jl])
			n++;
		if (cell[ir][j])
			n++;
		if (cell[ir][jr])
			n++;
		return n;
	}

	// Compute the next generation of the population in cell
	static boolean[][] nextGeneration(boolean[][] cell) {
		boolean[][] newCell = new boolean[cell.length][cell[0].length];
		for (int i = 0; i < cell.length; i++)
			for (int j = 0; j < cell[0].length; j++) {
				int n = neighbors(cell, i, j);
				newCell[i][j] = n == 3 || cell[i][j] && n == 2;
			}
		return newCell;
	}

	public static void main(String[] arg) {
		boolean[][] cell = readPopulation();
		printPopulation(cell);
		for (int i = 1; i < 10; i++) {
			cell = nextGeneration(cell);
			printPopulation(cell);
		}
	}
}

/*
 * Sample input: 7 7 ....... .xxx... ....... ....... .xxx... ....... .......
 */
