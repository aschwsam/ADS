package marathon;

import binarytree.TreeNode;

public class BinarySearchTree<E extends Comparable<E>> extends binarytree.BinaryTree {

    public BinarySearchTree() {
        super();
    }

    public void add(E element) {
        if (this.getRoot() != null) {
            TreeNode node = this.getRoot();
            while (node != null) {
                if (node.getElement().compareTo(element) > 0) {
                    if (node.getLeft() == null) {
                        node.setLeft(new TreeNode<E>(element));
                    } else {
                        node = node.getLeft();
                    }
                } else if (node.getElement().compareTo(element) < 0) {
                    if (node.getRight() == null) {
                        node.setRight(new TreeNode<E>(element));
                    } else {
                        node = node.getRight();
                    }
                }
                else{
                    node=node.getLeft();
                }
            }
        } else {
            this.setRoot(new TreeNode(element));
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
