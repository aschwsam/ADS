/**
 * Class for modeling a node of a binary search tree.
 */
public final class TreeNodeASD<E extends Comparable<E>> {

    private E element;
    private TreeNode<E> left;
    private TreeNode<E> right;


    /**
     * Creates a new node which stores the given element.
     *
     * @param element the element which the node contains
     */
    public TreeNode(E element) {
        this.element = element;
    }


    /**
     * Returns a string representing the node.
     *
     * @return the string representation of the node
     */
    @Override
    public String toString() {
        return (getClass().getName() + "[" + "element=" + element + "]");
    }


    /**
     * Returns the element contained by the node.
     *
     * @return the element of the node
     */
    public E getElement() {
        return element;
    }


    /**
     * Sets the element, which the node contains.
     *
     * @param element the new element for the node
     */
    public void setElement(E element) {
        this.element = element;
    }


    /**
     * Returns the left child of the node.
     *
     * @return the left child node or <code>null</code> if none exists
     */
    public TreeNode<E> getLeft() {
        return left;
    }


    /**
     * Sets the left child of the node.
     *
     * @param left the left child node, may be set to <code>null</code> to signify that no left child exists
     */
    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }


    /**
     * Returns the right child of the node.
     *
     * @return the right child node, or <code>null</code> if none exists
     */
    public TreeNode<E> getRight() {
        return right;
    }


    /**
     * Sets the right child of the node
     *
     * @param left the right child node, may be set to <code>null</code> to signify that no right child exists
     */
    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    /**
     * Check if the current node has a left child
     * @return
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * Check if the current node has a right child
     * @return
     */
    public boolean hasRight() {
        return right != null;
    }
}
