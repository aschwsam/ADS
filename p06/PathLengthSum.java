package p06;
import p05.*;

import java.util.ArrayList;

/**
 * Return the total of all connections
 */
public abstract class PathLengthSum {

    public static int getPathSum(){
        ArrayList<Node> nodes = new Graph().getNodeList();

        int sum = 0;
        for(Node node : nodes){
            for(Edge edge : node.getEdges()){
                sum += edge.getWeight();
            }
        }

        return sum/2;
    }

}
