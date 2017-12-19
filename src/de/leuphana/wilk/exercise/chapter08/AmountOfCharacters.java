package de.leuphana.wilk.exercise.chapter08;

import de.leuphana.wilk.exercise.In;
import de.leuphana.wilk.exercise.Out;

public class AmountOfCharacters {
	static int[] freq = new int[128]; // initially 0

	// Count the frequencies of characters in a text
	static void readText() {
		In.open("input.txt");
		char ch = In.read();
		while (In.done()) {
			freq[ch]++;
			ch = In.read();
		}
		In.close();
	}

	// Print the frequency table
	static void printTable() {
		for (int i = 0; i < 128; i++)
			if (freq[i] > 0) {
				if (i <= ' ' || i == 127) {
					Out.print("(char)" + i + ": ");
				} else
					Out.print((char) i + ": ");
				for (int j = 0; j < freq[i]; j++)
					Out.print("*");
				Out.println();
			}
	}

	public static void main(String args[]) {
		readText();
		printTable();
	}
}

/*
 * Sample input: Nobody knows the age of human race, but everybody agrees that
 * it is old enough to know better. (Anonymous)
 */