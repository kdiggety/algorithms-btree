package klewis3.algorithms.btree;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import klewis3.algorithms.btree.model.TreeNode;
import klewis3.algorithms.btree.util.BinaryTreeFixer;
import klewis3.algorithms.btree.util.BinaryTreePrinter;

@SpringBootTest
class ApplicationTest {
	private static Logger logger = Logger.getLogger(ApplicationTest.class.getName());
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void test2() {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		
		three.setLeft(one);
		three.setRight(four);
		four.setLeft(two);
		
		logger.info("TEST 1");
		BinaryTreePrinter.print(three);
		logger.info("");
		BinaryTreeFixer.fix(three);
		logger.info("");
		BinaryTreePrinter.print(three);
	}
	
	@Test
	void test1() {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		
		one.setLeft(three);
		three.setRight(two);
		
		logger.info("TEST 2");
		BinaryTreePrinter.print(one);
		logger.info("");
		BinaryTreeFixer.fix(one);
		logger.info("");
		BinaryTreePrinter.print(one);
	}
	
	@Test
	void test3() {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		
		one.setRight(six);
		three.setLeft(one);
		three.setRight(four);
		five.setLeft(seven);
		two.setRight(five);
		four.setLeft(two);
		
		logger.info("TEST 3");
		BinaryTreePrinter.print(three);
		logger.info("");
		BinaryTreeFixer.fix(three);
		logger.info("");
		BinaryTreePrinter.print(three);
	}
}
