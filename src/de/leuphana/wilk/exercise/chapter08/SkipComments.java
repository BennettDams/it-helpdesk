package de.leuphana.wilk.exercise.chapter08;

import de.leuphana.wilk.exercise.In;
import de.leuphana.wilk.exercise.Out;

public class SkipComments {
	static char ch; // lookahead character

	static void skipBracketComment() {
		ch = In.read();
		while (In.done()) {
			if (ch == '*') {
				ch = In.read();
				if (ch == '/') {
					ch = In.read();
					break;
				}
			} else
				ch = In.read();
		}
		/* ~In.done() || ch holds first character after comment */
	}

	static void skipLineComment() {
		do {
			ch = In.read();
		} while (In.done() && ch != '\r');
		/* ~In.done() || ch == '\r' */
	}

	public static void main(String args[]) {
		In.open("input.txt");
		Out.open("output.txt");
		ch = In.read();
		while (In.done()) {
			if (ch == '/') {
				ch = In.read();
				if (ch == '/')
					skipLineComment();
				else if (ch == '*')
					skipBracketComment();
				else {
					Out.print("/" + ch);
					ch = In.read();
				}
			} else {
				Out.print(ch);
				ch = In.read();
			}
		}
		In.close();
		Out.close();
	}
}

/*
 * Sample input: ... this file ...
 */
