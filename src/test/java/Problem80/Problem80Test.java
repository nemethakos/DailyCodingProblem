package Problem80;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import data.binarytree.BinaryTree;
import data.binarytree.BinaryTreeNode;

class Problem80Test {

	@Test
	void testGetDeepestNode() {
		BinaryTree bt = BinaryTree.fromArray(10,20,30,40,50,60,70);
		bt.findOneNodeByValue(50).setRight(BinaryTreeNode.builder().withValue(55).build());
		System.out.println(bt) ;
		
		var deepestNode = Problem80.getDeepestNode(bt);
		
		System.out.println("deepestNode:"+ deepestNode);
	}

}
