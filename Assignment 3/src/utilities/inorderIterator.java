package utilities;

import referenceBasedTreeImplementation.BSTreeNode;

public class inorderIterator<E extends Comparable<? super E>> extends BSTIterator {
	public inorderIterator(BSTreeNode<E> root) {
		getAllNodes(root);
	}
	
	private void getAllNodes(BSTreeNode<E> p) {
		if(p!=null) {
			getAllNodes(p.getLeft()); //L
			super.queue.add(p); //V
			getAllNodes(p.getRight()); //R
		}
	}
}
