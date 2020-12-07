package klewis3.algorithms.btree.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import klewis3.algorithms.btree.model.TreeNode;

public class BinaryTreeFixer {
	private static Logger logger = Logger.getLogger(BinaryTreeFixer.class.getName());
	
	public static final TreeNode fix(TreeNode root) {
		TreeNode rc = null;
		try {
			if (root == null) return null;
			rc = fixAndGetMaxV2(root, null, null);
		} catch (Throwable t) {
			logger.log(Level.WARNING, "Stopping due to the following error:", t);
		}
		return rc;
	}
	
	private static final TreeNode fixAndGetMaxV2(TreeNode node, TreeNode min, TreeNode max) {
		logger.info(String.format("Node: %s, Min: %s, Max: %s", node, min, max));
		// Sanity check
		if (min != null && max != null && min.getValue() > max.getValue()) {
			logger.log(Level.WARNING, String.format("Invalid bounds: [%s, %s]", min, max));
			swap(min, max);
		}
		
		TreeNode tmpMax = null;

		// Fix left side
		TreeNode left = node.getLeft();
		if (left != null) tmpMax = fixAndGetMaxV2(left, min, node);
		
		// Fix this node
		// Check 1: Node is out of bounds
		if (min != null && node.getValue() < min.getValue()) {
			logger.info(String.format("Swap because %s is less than %s", node, min));
			swap(node, min);
		}	
		if (max != null && node.getValue() > max.getValue()) {
			logger.info(String.format("Swap because %s is greater than %s", node, max));
			swap(node, max);
//			swap(min, node);
		}
				
		// Fix right side
		TreeNode right = node.getRight();
		if (right != null) tmpMax = fixAndGetMaxV2(right, node, max);
		
		logger.info(String.format("Returning max: %s", max));
		return max;
	}

//	private static final TreeNode fixAndGetMax(TreeNode root, TreeNode min, TreeNode max) {
//		logger.info(String.format("Root: %s, Min: %s, Max: %s", root, min, max));
//		// Sanity check
//		if (min != null && max != null && min.getValue() > max.getValue()) {
//			logger.log(Level.WARNING, String.format("Invalid bounds: [%s, %s]", min, max));
//			throw new IllegalArgumentException("min > max!");
//		}
//
//		TreeNode tmpMax = null;
//
//		// Fix left side
//		TreeNode left = root.getLeft();
//		if (left != null) tmpMax = fixAndGetMax(left, min, root);
//		
//		if (min != null && min.getValue() > root.getValue()) {
//			logger.info(String.format("%s is out of place with %s", root, min));
//			swap(root, min);
//		}
//		
//		if (max != null && max.getValue() < root.getValue()) {
//			logger.info(String.format("%s is out of place with %s", max, root));
//			swap(max, root);
//		}
//				
//		// Fix right side
//		TreeNode right = root.getRight();
//		if (right != null) tmpMax = fixAndGetMax(right, root, max);
//		
//		logger.info(String.format("Returning max: %s", max));
//		return max;
//	}
	
	private static void swap(TreeNode node1, TreeNode node2) {
		logger.info(String.format("Swap values: %s <=> %s", node1, node2));
		int tmpVal = node1.getValue();
		node1.setValue(node2.getValue());
		node2.setValue(tmpVal);
	}
}