package p05;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Breitensuche {

    private Queue<Node> queue = new LinkedList<Node>();
    private HashSet<String> output = new HashSet<String>();

    public Breitensuche (Graph graph){
        // Get first node from list

        queue.offer(graph.getNodeList().get(2));

        while(!queue.isEmpty()){
            // AUSGABE A
            Node currentnode = queue.remove();
            output.add(currentnode.toString());

            System.out.println(currentnode.toString());

            // ADD B AND C TO QUEUE
            for(Edge edges : currentnode.getEdges()) {
                if(!output.contains(edges.getDestination().toString())) {
                    queue.offer(edges.getDestination());
                }
            }
        }

    }
}