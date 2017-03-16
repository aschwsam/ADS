package marathon;

import binarytree.TreeNode;

public class BinarySearchTree<E extends Comparable<E>> extends binarytree.BinaryTree {

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


    public E find(E needle, TreeNode haystack){
        // check if names match
        if(needle.equals(haystack.getElement())){
            return needle;
        } else {
            // bigger => right, smaller => left
            if(needle.compareTo((E)haystack.getElement())>0){
                return find(needle,haystack.getRight());
            } else {
                return find(needle,haystack.getLeft());
            }
        }
    }
}
