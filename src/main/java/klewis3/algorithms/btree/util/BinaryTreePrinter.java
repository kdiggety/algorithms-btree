package klewis3.algorithms.btree.util;

import java.util.logging.Logger;

import klewis3.algorithms.btree.model.TreeNode;

public class BinaryTreePrinter {
	private static Logger logger = Logger.getLogger(BinaryTreePrinter.class.getName());
	
	public static final void print(TreeNode node) {
		print(node, "*");
	}
	
	private static final void print(TreeNode node, String prefix) {
		if (node == null) return;

		print(node.getLeft(), "/");
		logger.info(String.format("%s%s", prefix, node));
		print(node.getRight(), "\\");
	}
}
