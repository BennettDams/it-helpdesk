package de.leuphana.wilk.uebung.kapitel07;

public class BooleanExample {

	public static void main(String[] args) {
		boolean b = true;
		int x = 0;

		while (b) {
			if (x > 5) {
				b = false;
			}
			System.out.println(x);
			x++;
		}

	}

}
