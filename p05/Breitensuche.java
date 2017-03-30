package p05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sam on 30.03.2017.
 */
public class Breitensuche {
    private Queue<Node> queue = new LinkedList<Node>();

    public Breitensuche(){

    }

    public Queue buildQueue(ArrayList<Node> nodelist, int startnode){

        int counter = 0;

        for(Node nodes : nodelist){
            if(counter<startnode){
                counter++;
            } else {
                queue.offer(nodes);
                for(Edge edges : nodes.getEdges()){
                    queue.offer(edges.getDestination());
                }
            }
        }

        if(startnode<nodelist.size()){
            startnode++;
            buildQueue(nodelist,startnode);
        }

        return queue;
    }
}
