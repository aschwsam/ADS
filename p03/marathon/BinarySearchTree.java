package p03.marathon;

import p03.binarytree.TreeNode;

public class BinarySearchTree<E extends Comparable<E>> extends p03.binarytree.BinaryTree {

    public BinarySearchTree() {
        super();
    }

    public void add(E addition) {
        if (this.getRoot() != null) {
            TreeNode currentNode = this.getRoot();
            while (currentNode != null) {
                if (currentNode.getElement().compareTo(addition) > 0) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(new TreeNode<E>(addition));
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else if (currentNode.getElement().compareTo(addition) < 0) {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(new TreeNode<E>(addition));
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
                else{
                    currentNode=currentNode.getLeft();
                }
            }
        } else {
            this.setRoot(new TreeNode(addition));
        }
    }


	public E find(E needle, TreeNode<E> haystack){
		// Check if tree is empty
		if(haystack == null){
			return null;
		} else {
			// Check if needle equals current Element
			if(needle.equals(haystack.getElement())){
				return haystack.getElement();
			} else {
				// Needle > 0 => go right, Needle < 0 go left
				if(needle.compareTo(haystack.getElement())>0){
					return find(needle,haystack.getRight());
				} else {
					return find(needle,haystack.getLeft());
				}				
			}
		}
	}
}
