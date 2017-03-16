package marathon;


import binarytree.TreeNode;


/**
 * Created by stephan on 16.03.17.
 */
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
            }
        } else {
            this.setRoot(new TreeNode(element));
        }
    }


    public void find() {

    }
}
