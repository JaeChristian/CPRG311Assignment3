package utilities;

import referenceBasedTreeImplementation.BSTreeNode;

public class postorderIterator<E extends Comparable<? super E>> extends BSTIterator {
	public postorderIterator(BSTreeNode<E> root) {
		getAllNodes(root);
	}
	
	private void getAllNodes(BSTreeNode<E> p) {
		if(p!=null) {
			getAllNodes(p.getLeft()); //L
			getAllNodes(p.getRight()); //R
			super.queue.add(p); //V
		}
	}
}
