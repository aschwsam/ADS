package p05;


import java.io.File;
import java.util.Queue;


/**
 * @author Stephan Graph
 * Created by stephan on 29.03.17.
 */
public class Main {
    public static void main(String[] args) {

        /*

        System.out.println("--- Directed weighted Graph ---");
        for (String[] item: p05.CSVParser.readFile(new File("p05/cities.csv"))
             ) {
            System.out.println(item[0]+item[1]+item[2]);
        }

        */

        Graph graph = new Graph();
        graph.main();

        Breitensuche bsearch = new Breitensuche();
        Queue<Node> bstree = bsearch.buildQueue(graph.getNodeList(), 0);
        System.out.println("asd");

    }
}
