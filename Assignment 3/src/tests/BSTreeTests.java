package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.TreeException;
import referenceBasedTreeImplementation.*;
import utilities.Iterator;

class BSTreeTests {

	private BSTree<Integer> tree;
	
	@BeforeEach
	void setUp() {
		tree  = new BSTree<Integer>();
	}
	
	@AfterEach
	void end() {
		tree.clear();
	}
	
	@Test
	void testHeight() {
		assertEquals(tree.getHeight(), 0);
	}
	
	@Test
	void testSize() {
		assertEquals(tree.size(), 0);
	}
	
	@Test
	void testEmpty() {
		assertTrue(tree.isEmpty());
	}
	
	@Test 
	void testAdd() throws TreeException {
		tree.add(3);
		//System.out.println(tree.getRoot().getElement());
		tree.add(4);
		tree.add(2);
		tree.add(5);
		//System.out.println(tree.getRoot().getRight().getElement());
		//System.out.println(tree.getRoot().getRight().getRight().getElement());
		//System.out.println(tree.getRoot().getLeft().getElement());
		assertFalse(tree.add(3));
	}
	
	@Test
	void testPreorderIterator() {
		addSet();
		Iterator iterate = tree.preorderIterator();
		System.out.println("Preorder");
		while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}
	}
	
	@Test
	void testPostorderIterator() {
		addSet();
		Iterator iterate = tree.postorderIterator();
		System.out.println("Postorder");
		while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}
	}
	
	private void addSet() {
		tree.add(3);
		tree.add(4);
		tree.add(1);
		tree.add(2);
	}
}
