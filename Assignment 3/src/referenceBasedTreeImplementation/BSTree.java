package referenceBasedTreeImplementation;

import java.util.Stack;

import exceptions.TreeException;
import utilities.*;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT{
	
	public BSTreeNode<E> root;
	
	public BSTree() {
		this.root = null;
	}
	
	@Override
	public BSTreeNode getRoot() throws TreeException {
		return root;
	}

	@Override
	public int getHeight() {
		if(this.root == null)
			return 0;
		return root.getHeight();
	}

	@Override
	public int size() {
		if(this.root == null)
			return 0;
		return root.getNumberNodes();
	}

	@Override
	public boolean isEmpty() {
		if(this.root==null) 
			return true;
		else 
			return false;
	}

	@Override
	public void clear() {
		this.root = null;
	}

	@Override
	public boolean contains(Comparable entry) throws TreeException {
		return search(entry) != null;
	}

	@Override
	public BSTreeNode search(Comparable entry) throws TreeException {
		if(root == null) {
			return null;
		}
		
		BSTreeNode<E> currentNode = root;
		while(true) {
			if(entry.compareTo(currentNode.getElement()) < 0) {
				//if newEntry is less than the currentNode then traverse to the left
				//if the left node is null, then there is no match
				if(currentNode.getLeft() != null) {
					currentNode = currentNode.getLeft();
				} else {
					return null;
				}
			} else if(entry.compareTo(currentNode.getElement()) > 0){
				//if newEntry is more than the currentNode then traverse to the right
				//if the right node is null, then there is no match
				if(currentNode.getRight() != null) {
					currentNode = currentNode.getRight(); 
				} else {
					return null;
				}
			} else {
				//if newEntry is equal to the currentNode, don't add it (duplicates not allowed)
				return currentNode;
			}
		}
	}

	@Override
	public boolean add(Comparable newEntry) throws NullPointerException {
		//if empty tree then set newEntry as the root
		if(root == null) {
			root = new BSTreeNode<E>((E)newEntry);
			return true;
		}
		//if tree is not empty
		BSTreeNode<E> currentNode = root;
		while(true) {
			if(newEntry.compareTo(currentNode.getElement()) < 0) {
				//if newEntry is less than the currentNode then traverse to the left
				//if the left node is null, then add newEntry to the left node.
				if(currentNode.getLeft() != null) {
					currentNode = currentNode.getLeft();
				} else {
					currentNode.setLeft(new BSTreeNode<E>((E)newEntry));
					return true;
				}
			} else if(newEntry.compareTo(currentNode.getElement()) > 0){
				//if newEntry is more than the currentNode then traverse to the right
				//if the right node is null, then add newEntry to the right node.
				if(currentNode.getRight() != null) {
					currentNode = currentNode.getRight(); 
				} else {
					currentNode.setRight(new BSTreeNode<E>((E)newEntry));
					return true;
				}
			} else {
				//if newEntry is equal to the currentNode, don't add it (duplicates not allowed)
				return false;
			}
		}
	}

	@Override
	public Iterator inorderIterator() {
		return new inorderIterator(root);
	}

	@Override
	public Iterator preorderIterator() {
		return new preorderIterator(root);
	}

	@Override
	public Iterator postorderIterator() {
		return new postorderIterator(root);
	}

}
