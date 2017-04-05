package p06;
import p05.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Our Implementation of the Dijkstra algorithm
 */
public class Dijkstra {

    private HashMap<Node,Integer> path = new HashMap<>();

    public static void main(String Args[]){

        // initialize the mash
        Graph graph = new Graph();
    }

    private void getNonVisitedNodes(Node origin){

        // Temporary store for neighbours
        HashMap<Node,Integer> candidate = new HashMap<>();

        for(Edge edge : origin.getEdges()){
            if(!path.containsKey(edge.getDestination()) || !path.containsValue(edge.getDestination())){

                // Temporary store all neighbours
                candidate.put(edge.getDestination(),edge.getWeight());
            }
        }

        // TODO: Select the neighbour with the shortest distance

    }
}
