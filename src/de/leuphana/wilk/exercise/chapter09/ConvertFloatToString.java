package de.leuphana.wilk.exercise.chapter09;

import de.leuphana.wilk.exercise.In;
import de.leuphana.wilk.exercise.Out;

public class ConvertFloatToString {

	// Convert x to a string representation with n fractional digits
	static String convert(float x, int n) {
		StringBuilder b = new StringBuilder();
		b.append((int) x);
		if (n > 0) {
			b.append('.');
			// shift fractional part to the left by n digits
			int shift = 1;
			for (int i = 0; i < n; i++) {
				shift *= 10;
			}
			int rest = (int) ((Math.abs(x) - Math.floor(Math.abs(x))) * shift);
			// append rest to b taking care of leading zeroes
			int[] tab = new int[n];
			int pos = 0;
			do {
				tab[pos] = rest % 10;
				rest = rest / 10;
				pos++;
			} while (rest != 0);

			while (n > pos) {
				b.append('0');
				n--;
			}
			do {
				pos--;
				b.append((char) ('0' + tab[pos]));
			} while (pos > 0);
		}
		return b.toString();
	}

	public static void main(String args[]) {
		Out.print("Enter a float number (end = CTRL + C): ");

		float x = In.readFloat();

		while (In.done()) {
			Out.println(convert(x, 2));
			Out.print("Enter a float number (end = CTRL + C): ");
			x = In.readFloat();
		}

	}
}