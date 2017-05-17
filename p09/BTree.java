package p09;

public class BTree {

    private Node root;
    private int counter=0;

    public static void main(String Args[]){
        BTree bt = new BTree();
    }

    public BTree(){
        addNode(5,"");
        addNode(15,"");
        addNode(11,"");
        addNode(13,"");
        addNode(1,"");
        addNode(14,"");
        addNode(3,"");
        addNode(19,"");
        addNode(14,"");
        addNode(12,"");

        getDescendingElements(root);
    }

    public void addNode(int occurence, String word){
        Node newNode = new Node(occurence, word);
        Node currentNode = root;

        if(root == null){
            root = newNode;
        } else {

            while(true){
                // Decide which side to traverse
                if(currentNode.getOccurence() > newNode.getOccurence()){
                    // Go left

                    // Check if there is a left child
                    if(currentNode.getLeftChild()!=null){

                        // Start over with childNode
                        currentNode = currentNode.getLeftChild();
                    } else {

                        // Place newNode at the left
                        currentNode.setLeftChild(newNode);
                        break;
                    }
                } else {
                    // Go right

                    // Check if there is a right child
                    if(currentNode.getRightChild()!=null){

                        // Start over with childNode
                        currentNode = currentNode.getRightChild();
                    } else {
                        // Place newNode at the right
                        currentNode.setRightChild(newNode);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Prints Nodes in descending order
     * Requires root node as parameter to start
     * @param currentNode
     */
    public void getDescendingElements(Node currentNode){

        while(true){

            // Try to go as far right as possible
            if(currentNode.getRightChild()!=null){
                getDescendingElements(currentNode.getRightChild());
            }

            // Back from higher values - print current value
            System.out.println(currentNode.getOccurence());

            // Check for lower values
            if(currentNode.getLeftChild()!=null){
                getDescendingElements(currentNode.getLeftChild());
            }

            break;
        }
    }

    private class Node {

        private int occurence=0;
        private String word = null;

        private Node leftChild = null;
        private Node rightChild = null;

        public Node(int occurence, String word){
            this.occurence = occurence;
            this.word = word;
        }

        public void setLeftChild(Node left){
            leftChild = left;
        }

        public void setRightChild(Node right){
            rightChild = right;
        }

        public Node getLeftChild(){
            return leftChild;
        }

        public Node getRightChild(){
            return rightChild;
        }

        public String getWord(){
            return word;
        }

        public int getOccurence(){
            return occurence;
        }
    }

}
