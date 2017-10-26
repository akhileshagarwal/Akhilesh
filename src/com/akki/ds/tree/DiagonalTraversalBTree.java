package com.akki.ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class DiagonalTraversalBTree {
	// Tree node
	static class Node {
		int data;
		Node left;
		Node right;

		// constructor
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	/*
	 * root - root of the binary tree d - distance of current line from
	 * rightmost -topmost slope. diagonalPrint - HashMap to store Diagonal
	 * elements (Passed by Reference)
	 */
	static void diagonalPrintUtil(Node root, int d, HashMap<Integer, List<Integer>> diagonalPrint) {

		// Base case
		if (root == null)
			return;

		diagonalPrint.compute(d, (key, list) -> diagonalPrint.containsKey(key) ? updateList(root.data, list)
				: createAndUpdateList(root.data));

		// Increase the vertical distance if left child
		diagonalPrintUtil(root.left, d + 1, diagonalPrint);

		// Vertical distance remains same for right child
		diagonalPrintUtil(root.right, d, diagonalPrint);
	}

	// Print diagonal traversal of given binary tree
	static void diagonalPrint(Node root) {
		// create a map of vectors to store Diagonal elements
		HashMap<Integer, List<Integer>> diagonalPrint = new HashMap<>();
		diagonalPrintUtil(root, 0, diagonalPrint);

		System.out.println("Diagonal Traversal of Binnary Tree");
		for (Entry<Integer, List<Integer>> entry : diagonalPrint.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	private static List<Integer> updateList(Integer rootData, List<Integer> list) {
		list.add(rootData);
		return list;

	}

	private static List<Integer> createAndUpdateList(Integer rootData) {
		List<Integer> list = new ArrayList<>();
		return updateList(rootData, list);

	}

	// Driver program
	public static void main(String[] args) {

		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		diagonalPrint(root);
	}
}