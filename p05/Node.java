package p05;


/**
 * @author Stephan Graf
 * @since 2017-03-29
 * A Node in a Graph
 */
public class Node {
    private String id;

    public Node(String id) {
        this.id = id;
    }
    public String toString(){
        return this.id;
    }
}