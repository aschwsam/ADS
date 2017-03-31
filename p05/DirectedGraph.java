package p05;


import java.io.File;
import java.util.ArrayList;


/**
 * @author Stephan Graf
 * @since 2017-03-29
 * A directed Graph which chan contain weighted or unweighted edges
 */
public interface DirectedGraph {
    public void read(File file);
    public int getNumberofNodes();
    public int getNumberOfEdges();
    public ArrayList<Node> getNodeList();
    public ArrayList<Edge> getEdgeListForNode(Node node);
    //public void addNode(String id);
    //public void removeNode(Node node);
    public void addEdge(Node from, Node to);
    public void addEdge(Node from, Node to, int weight);
    public void removeEdge(Node from,Node to);
}
