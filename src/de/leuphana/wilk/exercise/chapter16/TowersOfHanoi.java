package de.leuphana.wilk.exercise.chapter16;

import de.leuphana.wilk.exercise.Out;

// Three stacks are used to visualize the poles
class Stack {
	int[] val = new int[32];
	int top = 0;

	void push(int x) {
		val[top++] = x;
	}

	int pop() {
		return val[--top];
	}

	void print() {
		for (int i = 0; i < top; i++)
			Out.print(val[i] + " ");
	}
}

public class TowersOfHanoi {

	static final int n = 7; // the number of disks to be moved
	static Stack[] pole = new Stack[3]; // the 3 poles

	// print the poles
	static void print() {
		pole[0].print();
		Out.println();
		pole[1].print();
		Out.println();
		pole[2].print();
		Out.println();
		Out.println("-----");
	}

	// Move n disks from "from" to "to"
	static void move(int n, int from, int to) {
		if (n > 0) {
			int free = 3 - (from + to);
			move(n - 1, from, free);
			int disk = pole[from].pop();
			pole[to].push(disk); // move last disk from "from" to "to"
			print();
			move(n - 1, free, to);
		}
	}

	public static void main(String args[]) {
		for (int i = 0; i < 3; i++)
			pole[i] = new Stack();
		for (int i = n; i > 0; i--)
			pole[0].push(i);
		move(n, 0, 1);
	}
}
