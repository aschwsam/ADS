package p05;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author Stephan Graf
 */
public class Graph implements DirectedGraph {
    private HashMap<String, Node> nodelist = new HashMap<String, Node>();
    private int[][] matrix;


    public void main() {
        read(new File("cities.csv"));
    }

    public Graph(){
        main();
    }

    public void createMatrix() {

        matrix = new int[nodelist.size()][nodelist.size()];

        for (Node node : nodelist.values()) {
            for (Edge edge : node.getEdges()) {
                System.out.println(edge.getDestination().getIndex());
                matrix[node.getIndex()][edge.getDestination().getIndex()] = edge.getWeight();
            }
        }
    }


    @Override
    public void read(File file) {
        ArrayList<String[]> fileinput = CSVParser.readFile(new File("p05/cities.csv"));

        for (String[] line : fileinput) {

            if (!nodelist.containsKey(line[1])) {
                nodelist.put(line[1], new Node(line[1], nodelist.size()));
            }

            if (!nodelist.containsKey(line[0])) {
                nodelist.put(line[0], new Node(line[0], nodelist.size()));
            }

            nodelist.get(line[0]).addEdge(new Edge(nodelist.get(line[1]), Integer.parseInt(line[2])));
        }

        createMatrix();

    }

    @Override
    public int getNumberofNodes() {

        return matrix.length;
    }

    @Override
    public int getNumberOfEdges() {
        int edges = 0;
        for (int i = 0; i < nodelist.size(); i++) {
            for (int k = 0; k < nodelist.size(); k++) {
                if (matrix[i][k] != 0) {
                    edges++;
                }
            }
        }

        return edges;
    }

    @Override
    public ArrayList<Node> getNodeList() {
        ArrayList<Node> toreturn = new ArrayList<>();
        for(Node node : nodelist.values()){
            toreturn.add(node);
        }
        return toreturn;
        //return (ArrayList<Node>)nodelist.values();
    }

    @Override
    public ArrayList<Edge> getEdgeListForNode(Node node) {
        return node.getEdges();
    }


    /*@Override
    public void addNode(Node node) {
        resizeMatrix(+1);
        matrix[matrix.length][matrix.length] = node.getIndex();
    }*/


    @Override
    public void addEdge(Node from, Node to) {
        matrix[from.getIndex()][to.getIndex()] = 1;
    }

    @Override
    public void addEdge(Node from, Node to, int weight) {
        matrix[from.getIndex()][to.getIndex()] = weight;
    }

    @Override
    public void removeEdge(Node from, Node to) {
        matrix[from.getIndex()][to.getIndex()] = 0;
    }


    private void resizeMatrix(int changeSize) {
        int[][] temp = new int[matrix.length + changeSize][matrix.length + changeSize];
        for (int i = 0; i < matrix.length && i < matrix.length + changeSize; i++) {
            for (int j = 0; j < matrix.length && i < matrix.length + changeSize; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
    }
/*

    private void removeFromMatrix(int index) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == index)
                    iftemp[i][j] = matrix[i][j];
            }
        }
    }*/
}
