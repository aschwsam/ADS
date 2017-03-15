import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class BinaryTree<Integer> {

    private TreeNode head = new TreeNode(null);
    private TreeNode nullNode = new TreeNode(null);


    public static void main(String Args[]) {

    }


    /**
     * Constructor for empty tree
     * Head (null) points to leaf (null)
     */
    public BinaryTree() {
        head.setRight(nullNode);
        nullNode.setLeft(nullNode);
        nullNode.setRight(nullNode);
    }


    /**
     * Construtor for Tree with nodes
     * Head (Integer) points to first Node which points
     * to leaf (null)
     */
    public BinaryTree(int element) {
        head.setRight(new TreeNode(element));
        head.getRight().setLeft(nullNode);
        head.getRight().setRight(nullNode);
    }


    public TreeNode getRoot() {
        return head.getRight();
    }


    public ArrayList<Integer> traversePostorder() {
        ArrayList<Integer> elements = new ArrayList<Integer>();
        TreeNode node = head.getRight();
        TreeNode parent = head.getRight();

        // Go to the far left side of the tree
        while (!node.getLeft().equals(nullNode)) {
            parent = node;
            node = node.getLeft();
        }

        while (!parent.equals(head)) {


        }
        elements.add((Integer)node.getElement());


        return elements;
    }


    public ArrayList<Integer> traversePreorder() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traversePreorder(head, list);
        return list;
    }


    public ArrayList<Integer> traversePreorder(TreeNode node, ArrayList<Integer> list) {
        list.add((Integer)node.getElement());
        if (node.hasLeft()) {
           list = traversePreorder(node.getLeft(), list);
        } if (node.hasRight()) {
            list = traversePreorder(node.getRight(), list);
        }
        return list;
    }


    public ArrayList<java.lang.Integer> traverseInorder() {
        return null;
    }


    public ArrayList<Integer> traverseLevelorder() {
        return null;
    }


    public void setRoot(TreeNode rootNode) {
        head=rootNode;
    }
}
