package p05;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stephan on 29.03.17.
 */
    public class Graph {

        public static void main (){
            ArrayList<String[]>  fileinput = CSVParser.readFile(new File("p05/cities.csv"));

            for(String[] asd : fileinput){
                System.out.println(asd[0]);
                System.out.println(asd[1]);
                System.out.println(asd[2]);
            }



        }
        /*
        public void createMatrix () {
            HashMap<String, Node> nodelist = new HashMap<String, Node>();

            int[][] matrix = new int[nodelist.size()][nodelist.size()];

            for (Map.Entry<String, Node> entry : nodelist.entrySet()) {
                matrix[entry.getValue().getIndex()];
                for (Edge edge : entry.getValue().getEdges()) {
                    matrix[entry.getValue().getIndex()][edge.getIndex()] = edge.getWeight();
                }
            }
        }*/

}
