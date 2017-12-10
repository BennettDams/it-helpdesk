package de.leuphana.wilk.exercise.chapter07;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 4, 1, 3, 2 };

		System.out.println("Eingabe:");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		int help = 0;
		int x = 0;
		int y = 1;
		boolean swapped = false;

		int length = array.length;

		// exchange
		do {
			for (int i = 0; i < length - 1; ++i) {
				if (array[i] > array[i + 1]) {
					help = array[i];
					array[i] = array[i + 1];
					array[i + 1] = help;
					swapped = true;
				} else {
					swapped = false;
				}
				length--;
			}
		} while (swapped);

		// print
		System.out.println();
		System.out.println("Ausgabe:");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}
