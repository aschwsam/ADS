package binarytree;
import java.util.ArrayList;

public class BinaryTree<E extends Comparable<E>> {
    private TreeNode root;

    /**
     * Constructor for empty tree
     * Head (null) points to leaf (null)
     */
    public BinaryTree() {
    }

    /**
     * Constructor for Tree with nodes
     * Head (Integer) points to first Node which points
     * to leaf (null)
     */
    public BinaryTree(E element) {
        root = new TreeNode(element);
    }

    public TreeNode getRoot() {
        return root;
    }


    public void setRoot(TreeNode rootNode) {
        root = rootNode;
    }


    public ArrayList<E> traversePostorder() {
        ArrayList<E> list = new ArrayList<>();
        traversePostorder(root, list);
        return list;
    }


    public ArrayList<E> traversePostorder(TreeNode node, ArrayList list) {
        if (node != null) {
            list = traversePostorder(node.getLeft(), list);
            list = traversePostorder(node.getRight(), list);
            list.add(node.getElement());
        }
        return list;
    }


    public ArrayList<E> traversePreorder() {
        ArrayList<E> list = new ArrayList<>();
        traversePreorder(root, list);
        return list;
    }


    public ArrayList<E> traversePreorder(TreeNode node, ArrayList list) {
        if (node != null) {
            list.add(node.getElement());
            traversePreorder(node.getLeft(), list);
            traversePreorder(node.getRight(), list);
        }
        return list;
    }


    public ArrayList<E> traverseInorder() {
        ArrayList<E> list = new ArrayList<>();
        traverseInorder(root, list);
        return list;
    }


    public ArrayList<E> traverseInorder(TreeNode node, ArrayList list) {
        if (node != null) {
            list = traverseInorder(node.getLeft(), list);
            list.add(node.getElement());
            list = traverseInorder(node.getRight(), list);
        }
        return list;
    }

    public ArrayList<E> traverseLevelorder() {
        ArrayList<E> list = new ArrayList<>();
        MyQueue<TreeNode> queue = new MyQueue<>();
        TreeNode node;
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node != null) {
                list.add((E)node.getElement());
                queue.add(node.getLeft());
                queue.add(node.getRight());
            }
        }
        return list;
    }
}
