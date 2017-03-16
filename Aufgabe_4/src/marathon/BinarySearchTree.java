package marathon;


import binarytree.TreeNode;


/**
 * Created by stephan on 16.03.17.
 */
public class BinarySearchTree<E extends Comparable<E>> extends binarytree.BinaryTree {

    public BinarySearchTree(){
        super();
    }
    public void add(E element){
       TreeNode node = this.getRoot();
       if(node.getElement().compareTo(element)>0&&node.getLeft()==null){
           node.setLeft(new TreeNode<E>(element));
       }else if(node.getElement().compareTo(element)<0&& node.getRight()==null){
           node.setRight(new TreeNode<E>(element));
       }
    }
    public void find(){

    }
}
