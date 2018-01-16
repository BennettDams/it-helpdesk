package de.leuphana.wilk.exercise.chapter12;

import de.leuphana.wilk.exercise.In;
import de.leuphana.wilk.exercise.Out;

class Node {
	int val;
	Node next;

	Node(int v, Node n) {
		val = v;
		next = n;
	}
}

public class SearchMaximum {

	// Read a sequence of integers and link them into a list
	static Node readList() {
		In.open("input.txt");
		Node head = null;
		int val = In.readInt();
		while (In.done()) {
			head = new Node(val, head);
			val = In.readInt();
		}
		In.close();
		return head;
	}

	// Return the maximum value from the list p
	static int max(Node p) {
		int m = Integer.MIN_VALUE;
		while (p != null) {
			if (p.val > m)
				m = p.val;
			p = p.next;
		}
		return m;
	}

	public static void main(String args[]) {
		Node list = readList();
		int m = max(list);
		Out.println("max = " + m);
	}
}

/*
 * Sample input: 6 27 67 52 -3 8 98 3 37 2 97 46 2
 */