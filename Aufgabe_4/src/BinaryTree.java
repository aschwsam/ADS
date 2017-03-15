import java.util.ArrayList;

public class BinaryTree <Integer>{

	private TreeNode head = new TreeNode(null);
	private TreeNode nullNode =  new TreeNode(null);
	private ArrayList<Integer> ElementList = new ArrayList<Integer>();
	
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
	
	/**
	 * Construtor for Tree with nodes
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
		traversePostorder(head);
		System.out.println(ElementList.size());
		return ElementList;
	}
	
	/* 
	 * Postorder traversal
	 */
	public void traversePostorder(TreeNode currentNode){
		// End of tree left side
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
	}
}
