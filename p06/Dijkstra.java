package p06;
import p05.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Our Implementation of the Dijkstra algorithm
 */
public class Dijkstra {

    private static ArrayList<Node> allNodes = new Graph().getNodeList();
    private static ArrayList<PathElement> peArray = new ArrayList<>();
    private static Node destination = null;
    private static boolean done = false;

    public static void main(String Args[]) {

        Node origin = null;

        if(Args.length>0){
            for (Node loop : allNodes) {
                if (loop.toString().equals(Args[0])) {
                    origin = loop;
                }

                if (loop.toString().equals(Args[1])) {
                    destination = loop;
                }
            }
        }


        if (origin == null) {
            System.out.println("Start nicht gefunden");
            origin = allNodes.get(0);
        }

        if (destination == null) {
            System.out.println("Ziel nicht gefunden");
            destination = allNodes.get(allNodes.size()-1);
        }

        // Add starting node to Path
        peArray.add(new PathElement(origin));

        // If starting node has multiple connections - create copies of it
        if(origin.getEdges().size()>1){
            peArray.add(new PathElement(origin));
            // Append the first connection
            peArray.get(1).addStep(getClosestNode(origin));

            // Remove the new discovered node from list
            removeNodeFromList(peArray.get(1).getLastStep());
        } else {
            // Append the first connection
            peArray.get(0).addStep(getClosestNode(origin));

            // Remove the new discovered node from list
            removeNodeFromList(peArray.get(0).getLastStep());
        }

        while(done==false){
            loop();
            System.out.println();
        }

    }

    private static HashMap<Node, Integer> getClosestNode(Node input) {
        HashMap<Node, Integer> connection = new HashMap<>();
        Integer distance = null;
        Node winner = null;

       // System.out.println("looking for connections at node: "+input.toString());


        for (Edge edges : input.getEdges()) {
            if(allNodes.contains(edges.getDestination())){
                if (distance == null) {
                    connection.put(edges.getDestination(), edges.getWeight());
                    distance = edges.getWeight();
                    winner = edges.getDestination();
                } else {
                    if (edges.getWeight() < distance) {
                        connection.remove(winner);
                        connection.put(edges.getDestination(), edges.getWeight());
                        distance = edges.getWeight();
                        winner = edges.getDestination();
                    }
                }
            }
        }

        if(winner!=null){
           // System.out.println("Best connection from "+input.toString()+" goes to "+winner.toString());
            //System.out.println("==========================================");
        } else {
           // System.out.println("No winner found");
            //System.out.println("===================");
        }

        return connection;
    }

    private static void loop(){

        Integer[] quickpath = new Integer[peArray.size()];

       // System.out.println("We're going to check the following nodes");
        for(PathElement node : peArray){
           // System.out.println(node.getLastStep().toString());
        }

        int counter = 0;
        for(PathElement pe : peArray){

            // Check for paths
            HashMap<Node,Integer> tmpMap = getClosestNode(pe.getLastStep());

            if(tmpMap.size()>0){
                for(Integer value : tmpMap.values()){
                    quickpath[counter]=value+pe.getPathcost();
                }
            } else {
               // System.out.println("no values to work with");
                quickpath[counter]=0;
            }

            counter++;
        }

        Integer winner = 0;
        Integer fast = 0;
        Integer k = 0;
        boolean first = true;
        for(Integer fastroute : quickpath){
            if(first){
                if(fastroute==0){
                    fast = 99999;
                } else {
                    fast = fastroute;
                }
                first = false;
            } else {
                if(fastroute<fast && fastroute!=0){
                    fast = fastroute;
                    winner = k;
                }
            }
            k++;
        }

        //System.out.println("XXX");
        for(Map.Entry<Node,Integer> asd : getClosestNode(peArray.get(winner).getLastStep()).entrySet()){
            //System.out.println("the fastest path goes from "+peArray.get(winner).getLastStep().toString()+" to "+asd.getKey().toString());
        }

        // Check if "winner" has multiple edges
        if(peArray.get(winner).getLastStep().getEdges().size()>1){

            PathElement tmpPE = new PathElement();

            for(Node asd : peArray.get(winner).getPath()){
                tmpPE.setPath(asd);
            }

            tmpPE.setPathcost(peArray.get(winner).getPathcost());

            Node nextstep = peArray.get(winner).getLastStep();
            tmpPE.addStep(getClosestNode(nextstep));

            peArray.add(tmpPE);

            if(tmpPE.getLastStep()==destination){
                done = true;
                for(Node showpath : tmpPE.getPath()){
                    System.out.println(showpath.toString());
                }
            }

            // Remove the new connected node
            removeNodeFromList(tmpPE.getLastStep());
        } else {
            // Extend the element
            peArray.get(winner).addStep(getClosestNode(peArray.get(winner).getLastStep()));

            if(peArray.get(winner).getLastStep() == destination){
                done = true;
                for(Node showpath : peArray.get(winner).getPath()){
                    System.out.println(showpath.toString());
                }
            }

            // Remove the new connected node
            removeNodeFromList(peArray.get(winner).getLastStep());
        }


    }

    private static void removeNodeFromList(Node removeit){
        allNodes.remove(removeit);
    }
}
