package Problem83;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Problem80.Problem80;
import data.binarytree.BinaryTree;
import data.binarytree.BinaryTreeNode;

class Problem83Test {

	@Test
	void testInvert() {
		BinaryTree bt = BinaryTree.fromArray(10,20,30,40,50,60,70);
		bt.findOneNodeByValue(50).setRight(BinaryTreeNode.builder().withValue(55).build());
		System.out.println(bt);
		
		var inverted = Problem83.invert(bt);
		
		System.out.println(inverted);
	}

}
