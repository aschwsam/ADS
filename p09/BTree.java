package p09;

public class BTree {

    private Node root;
    private int limit=10;   // Default to Top10

    public BTree(){

        // DEBUG
        /*
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

        getDescendingElements(5);
        */
    }

    /**
     * Add a new node to the tree
     * @param occurrence weight for node (occurrence)
     * @param word node value (word)
     */
    public void addNode(int occurrence, String word){
        Node newNode = new Node(occurrence, word);
        Node currentNode = root;

        if(root == null){
            root = newNode;
        } else {

            while(true){
                // Decide which side to traverse
                if(currentNode.getOccurrence() > newNode.getOccurrence()){
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
     * --> Causes Stackoverflow!
     * TODO: Fix Stackoverflow
     */
    public void getDescendingElements(){
        getDescendingElements(root);
    }

    /**
     * Prints top n nodes in descending order
     * @param limit user defined limit for n
     */
    public void getDescendingElements(int limit){
        this.limit = limit;
        getDescendingElementsLimited(root);
    }

    /**
     * Internal handler for getDescendingElements
     * @param currentNode root node
     */
    private void getDescendingElements(Node currentNode){

        while(true){

            // Try to go as far right as possible
            if(currentNode.getRightChild()!=null){
                getDescendingElements(currentNode.getRightChild());
            }

            // Back from higher values - print current value
            System.out.println(currentNode.getOccurrence()+" "+currentNode.getWord());

            // Check for lower values
            if(currentNode.getLeftChild()!=null){
                getDescendingElements(currentNode.getLeftChild());
            }

            break;
        }
    }

    /**
     * Print limited amount of nodes in descending order
     * @param currentNode root node
     */
    private void getDescendingElementsLimited(Node currentNode){

        while(true){

            // Try to go as far right as possible
            if(currentNode.getRightChild()!=null){
                getDescendingElementsLimited(currentNode.getRightChild());
            }

            // Start countdown
            if(limit>0){
                // Back from higher values - print current value
                System.out.println(currentNode.getOccurrence()+" "+currentNode.getWord());
                limit--;
            } else {
                break;
            }

            // Check for lower values
            if(currentNode.getLeftChild()!=null){
                getDescendingElementsLimited(currentNode.getLeftChild());
            }
            break;
        }
    }

    private class Node {

        private int occurrence =0;
        private String word = null;

        private Node leftChild = null;
        private Node rightChild = null;

        /**
         * Node constructor
         * @param occurrence (int) occurrence
         * @param word (String) word
         */
        public Node(int occurrence, String word){
            this.occurrence = occurrence;
            this.word = word;
        }

        /**
         * Set left child
         * @param left (Node)
         */
        public void setLeftChild(Node left){
            leftChild = left;
        }

        /**
         * Set right child
         * @param right (Node)
         */
        public void setRightChild(Node right){
            rightChild = right;
        }

        /**
         * Get left child
         * @return (Node) left child of current node
         */
        public Node getLeftChild(){
            return leftChild;
        }

        /**
         * Get right child
         * @return (Node) right child of current node
         */
        public Node getRightChild(){
            return rightChild;
        }

        /**
         * Get word value of current node
         * @return (String) word
         */
        public String getWord(){
            return word;
        }

        /**
         * Get occurrence of word held by this node
         * @return (int) occurrence
         */
        public int getOccurrence(){
            return occurrence;
        }
    }

}
