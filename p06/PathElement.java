package p06;
import p05.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class holds the individual path information
 * for the Dijkstra algorithm
 */
public class PathElement {

    private ArrayList<Node> node = new ArrayList<>();
    private Integer pathcost = 0;

    public PathElement(Node origin){
        node.add(origin);
    }

    public PathElement(){

    }

    public void addStep(HashMap<Node,Integer> details){
        for(Map.Entry<Node,Integer> tmp : details.entrySet()){
            node.add(tmp.getKey());
            pathcost+=tmp.getValue();
        }
    }

    public Node getLastStep(){
        return node.get(node.size()-1);
    }

    public Integer getPathcost(){
        return pathcost;
    }

    public void setPathcost(Integer cost){
        pathcost = cost;
    }

    public ArrayList<Node> getPath(){
        return node;
    }

    public void setPath(Node path){
        node.add(path);
    }
}
