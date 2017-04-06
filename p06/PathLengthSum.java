package p06;
import p05.*;

import java.util.ArrayList;

/**
 * Created by Sam on 06.04.2017.
 */
public abstract class PathLengthSum {

    public static void getPathSum(){
        ArrayList<Node> nodes = new Graph().getNodeList();

        int sum = 0;
        for(Node node : nodes){
            for(Edge edge : node.getEdges()){
                sum += edge.getWeight();
            }
        }

        System.out.println("Die Summer aller Strecken ist: "+sum/2+"km");
    }

}
