package referenceBasedTreeImplementation;

import java.io.Serializable;

public class BSTreeNode<E extends Comparable<? super E>> implements Serializable {
	
	private E element;
	private BSTreeNode<E> left, right;
	
	public BSTreeNode(E elem) {
		this.element = elem;
		this.left = null;
		this.right = null;
	}
	
	public BSTreeNode(E elem, BSTreeNode<E> left, BSTreeNode<E> right) {
		this.element = elem;
		this.left = left;
		this.right = right;
	}
	
	public E getElement() {
		return this.element;
	}
	
	public void setElement(E elem) {
		this.element = elem;
	}
	
	public BSTreeNode<E> getLeft() {
		return this.left;
	}
	
	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}
	
	public BSTreeNode<E> getRight() {
		return this.right;
	}
	
	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}
	
	public boolean hasLeftChild(){
		if(this.left != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean hasRightChild() {
		if(this.right != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isLeaf() {
		if(this.right == null && this.left == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getNumberNodes() {
		return getNumberNodes(this);
	}
	
	public int getHeight() {
		return getHeight(this);
	}
	
	private int getHeight(BSTreeNode<E> toGet) {
		//if the node needed is null, return -1
		if(toGet == null) {
			return -1;
		}
		
		int leftHeight = getHeight(toGet.getLeft());
		int rightHeight = getHeight(toGet.getLeft());
		
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		else {
			return rightHeight + 1;
		}
	} 
	
	private int getNumberNodes(BSTreeNode<E> toGet) {
		if(toGet == null) {
			System.out.println("0 nodes");
			return 0;
		}
		else {
			System.out.println("more than 0 nodes");
			return getNumberNodes(toGet.getLeft()) + 1 + getNumberNodes(toGet.getRight());
		}
	}
	
}
