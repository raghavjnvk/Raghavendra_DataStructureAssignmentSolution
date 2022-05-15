/* Java implementation to convert the Binary search tree into a skewed tree */

package com.greatlearning.lab2;

import java.io.*;

// Class of the node
class Node {
	int val;
	Node left, right;


	Node(int item) {
		val = item;
		left = right = null;
	}
}

class BinaryTree {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	// Function to convert the binary search tree into a skewed tree in increasing / decreasing order
	static void flattenBTToSkewed(Node root, int order) {

		if (root == null) {
			return;
		}

		// Condition to check the order in which the skewed tree to maintained
		if (order > 0) {
			flattenBTToSkewed(root.right, order);
		} else {
			flattenBTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		// Condition to check if the root Node of the skewed tree is not defined
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		// Similarly recurse for the left / right subtree on the basis of the order required
		if (order > 0) {
			flattenBTToSkewed(leftNode, order);
		} else {
			flattenBTToSkewed(rightNode, order);
		}
	}

	// Function to traverse the right skewed tree using recursion
	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	// Driver Code
	public static void main(String[] args) {
       BinaryTree tree = new BinaryTree();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.left.left= new Node(10);
		tree.node.right = new Node(55);
		tree.node.right.right = new Node(60);
		


		int order = 0;
		flattenBTToSkewed(node, order);
		traverseRightSkewed(headNode);
	}
}
