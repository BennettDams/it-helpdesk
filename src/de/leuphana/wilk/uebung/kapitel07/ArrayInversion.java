package de.leuphana.wilk.uebung.kapitel07;

import de.leuphana.wilk.uebung.In;
import de.leuphana.wilk.uebung.Out;

class ArrayInversion {

	// Invert the array a (in place)
	static void invert(int[] a) {
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			int h = a[i];
			a[i] = a[j];
			a[j] = h;
			i++;
			j--;
		}
	}

	// Read an array of integers from the input stream
	static int[] readArray() {
		int len = In.readInt();
		int[] a = new int[len];
		for (int i = 0; i < len; i++)
			a[i] = In.readInt();
		return a;
	}

	// Print a
	static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			Out.print(a[i] + " ");
		Out.println();
	}

	public static void main(String[] arg) {
		In.open("input.txt");
		int[] a = readArray();
		Out.print("Eingabe: ");
		printArray(a);
		invert(a);
		Out.print("Invertiert: ");
		printArray(a);
		In.close();
	}
}

/*
 * Sample input: 9 1 2 3 4 5 6 7 8 9
 */
