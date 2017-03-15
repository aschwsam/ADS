import java.util.ArrayList;

public class BinaryTree <Integer>{

	private TreeNode head = new TreeNode(null);
	private TreeNode nullNode =  new TreeNode(null);
	private ArrayList<Integer> ElementList;
	public static void main (String Args[]){
		
	}

	/**
	 * Constructor for empty tree
	 * Head (null) points to leaf (null)
	 */
	public BinaryTree(){
		head.setRight(nullNode);
		head.setLeft(nullNode);

	}


	/** * Construtor for Tree with nodes
	 * Head (Integer) points to first Node which points
	 * to leaf (null)
	 */
	public BinaryTree(int element){
		head.setRight(new TreeNode(element));
		head.getRight().setLeft(nullNode);
		head.getRight().setRight(nullNode);
	}

	public TreeNode getRoot(){
		return head.getRight();
	}

	public ArrayList<Integer> traversePostorder(){
		ElementList = new ArrayList<Integer>();
		traversePostorder( head);
		return ElementList;
		}
		/*
	 * Postorder traversal
	 */
	public void traversePostorder(TreeNode currentNode){
		// End of  treeleft side
		if(!currentNode.equals(nullNode))
			{
			if(!currentNode.getLeft().equals(null)){
		traversePostorder(currentNode.getLeft());

		// End of tree right side
			traversePostorder(currentNode.getRight());
			} else {
		ElementList.add((Integer)currentNode.getElement());
		}
		}

	}public ArrayList<Integer> traversePreorder() {
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
