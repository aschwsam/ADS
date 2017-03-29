package p05;

/**
 * @author Stephan Graf
 * @version 2017-03-29
 *
 * Represents an Edge in a weighted Graph
 */
public class Edge {
    private Node destination;
    private int weight;
    private int index;

    public Edge(Node destination, int weight){
        this.destination = destination;
        this.weight = weight;
    }


    public Node getDestination() {
        return destination;
    }

    public int getIndex(){
        return index;
    }

    public int getWeight() {
        return weight;
    }
}
