package utilities;

import java.util.NoSuchElementException;

import referenceBasedTreeImplementation.*;

public class preorderIterator<E extends Comparable<? super E>> extends BSTIterator{
	public preorderIterator(BSTreeNode<E> root) {
		getAllNodes(root);
	}
	
	private void getAllNodes(BSTreeNode<E> p) {
		if(p!=null) {
			
			super.queue.add(p); //V
			getAllNodes(p.getLeft()); //L
			getAllNodes(p.getRight()); //R
		}
	}
}
