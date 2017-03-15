import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;


public class BinaryTree<Integer> {

    private TreeNode head = new TreeNode(null);
    private TreeNode nullNode = new TreeNode(null);
    private ArrayList<Integer> ElementList;


    public static void main(String Args[]) {

    }


    /**
     * Constructor for empty tree
     * Head (null) points to leaf (null)
     */
    public BinaryTree() {
        head.setRight(nullNode);
        head.setLeft(nullNode);

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
        return newPostorder();
        /*
        ElementList = new ArrayList<Integer>();
		traversePostorder( head);
		return ElementList;*/
    }


    /*
	 * Postorder traversal
	 */
    public void traversePostorder(TreeNode currentNode) {
        // End of  treeleft side
        if (!currentNode.equals(nullNode)) {
            if (!currentNode.getLeft().equals(null)) {
                traversePostorder(currentNode.getLeft());

                // End of tree right side
                traversePostorder(currentNode.getRight());
            } else {
                ElementList.add((Integer)currentNode.getElement());
            }
        }

    }


    public ArrayList<Integer> traversePreorder() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traversePreorder(head, list);
        return list;
    }


    public ArrayList<Integer> traversePreorder(TreeNode node, ArrayList<Integer> list) {
        if (node.hasElement()) {
            list.add((Integer)node.getElement());
        }
        if (node.hasLeft()) {
            list = traversePreorder(node.getLeft(), list);
        }
        if (node.hasRight()) {
            list = traversePreorder(node.getRight(), list);
        }
        return list;
    }


    public ArrayList<Integer> traverseInorder() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traverseInorder(head, list);
        return list;
    }


    public ArrayList<Integer> traverseInorder(TreeNode node, ArrayList<Integer> list) {
        if (node.hasLeft()) {
            list = traverseInorder(node.getLeft(), list);
        }
        if (node.hasElement()) {
            list.add((Integer)node.getElement());
        }
        if (node.hasRight()) {
            list = traverseInorder(node.getRight(), list);
        }
        return list;
    }


    public ArrayList<Integer> newPostorder() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        newPostorder(head, list);
        return list;
    }


    public ArrayList<Integer> newPostorder(TreeNode node, ArrayList<Integer> list) {
        if (node.hasLeft()) {
            list = newPostorder(node.getLeft(), list);
        }

        if (node.hasRight()) {
            list = newPostorder(node.getRight(), list);
        }
        if (node.hasElement()) {
            list.add((Integer)node.getElement());
        }
        return list;
    }


    public ArrayList<Integer> traverseLevelorder() {
        ArrayList<Integer> list = new ArrayList<>();
        MyQueue queue = new MyQueue();
        TreeNode node;
        queue.add(head);
        while (!queue.isEmpty()) {
            node = (TreeNode)queue.remove();
            if(node.hasElement()){list.add((Integer)node.getElement());}
            if (node.hasLeft()) {
                queue.add(node.getLeft());
            }
            if (node.hasRight()) {
                queue.add(node.getRight());
            }
        }
        return list;
    }


    public void setRoot(TreeNode rootNode) {
        head = rootNode;
    }
}
