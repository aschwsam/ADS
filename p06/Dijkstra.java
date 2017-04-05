package p06;
import p05.*;

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

    /**
     * Find the closest edge of a node and return it
     * ==> Edge contains the target node (.destination) and distance (.weight)
     * @param origin
     * @return Edge
     */
    private Edge getClosestNode(Node origin){

        // Temporary store for neighbours
        HashMap<Edge,Integer> candidate = new HashMap<>();
        Edge nexthop = null;
        Integer shortestpath = null;

        for(Edge edge : origin.getEdges()){
            if(!path.containsKey(edge.getDestination()) || !path.containsValue(edge.getDestination())){

                // Temporary store all neighbours
                candidate.put(edge,edge.getWeight());
            }
        }

        // Find the closest node
        for(HashMap.Entry<Edge,Integer> singlepath : candidate.entrySet()) {
            if(singlepath.getValue()<shortestpath || shortestpath==null){
                nexthop = singlepath.getKey();
                shortestpath = singlepath.getValue();
            }
        }

        return nexthop;
    }
}
