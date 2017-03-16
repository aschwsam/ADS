package binarytree;


import java.util.ArrayList;
import java.util.Comparator;


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
    public BinaryTree(int element) {
        root = new TreeNode(element);
    }


    public TreeNode getRoot() {
        return root;
    }


    public void setRoot(TreeNode rootNode) {
        root = rootNode;
    }


    public ArrayList<Integer> traversePostorder() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traversePostorder(root, list);
        return list;
    }


    public ArrayList<Integer> traversePostorder(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            list = traversePostorder(node.getLeft(), list);
            list = traversePostorder(node.getRight(), list);
            list.add((Integer)node.getElement());
        }
        return list;
    }


    public ArrayList<Integer> traversePreorder() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traversePreorder(root, list);
        return list;
    }


    public ArrayList<Integer> traversePreorder(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            list.add((Integer)node.getElement());
            traversePreorder(node.getLeft(), list);
            traversePreorder(node.getRight(), list);
        }
        return list;
    }


    public ArrayList<Integer> traverseInorder() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traverseInorder(root, list);
        return list;
    }


    public ArrayList<Integer> traverseInorder(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            list = traverseInorder(node.getLeft(), list);
            list.add((Integer)node.getElement());
            list = traverseInorder(node.getRight(), list);
        }
        return list;
    }


    public ArrayList<Integer> traverseLevelorder() {
        ArrayList<Integer> list = new ArrayList<>();
        MyQueue queue = new MyQueue();
        TreeNode node;
        queue.add(root);
        while (!queue.isEmpty()) {
            node = (TreeNode)queue.remove();
            if (node != null) {
                list.add((Integer)node.getElement());
                queue.add(node.getLeft());
                queue.add(node.getRight());
            }
        }
        return list;
    }


}
