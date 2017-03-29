package p05;


import java.util.ArrayList;

/**
 * @author Stephan Graf
 * @since 2017-03-29
 * A Node in a Graph
 */
public class Node {
    private String id;
    private int index;
    private ArrayList<Edge> edges;


    public Node(String id, int index) {
        this.id = id;
        this.index = index;
        this.edges = new ArrayList<Edge>();
    }


    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }


    public String toString() {
        return this.id;
    }


    public ArrayList<Edge> getEdges() {
        return edges;
    }


    public int getIndex() {
        return index;
    }
}