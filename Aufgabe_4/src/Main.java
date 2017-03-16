import marathon.BinarySearchTree;
import marathon.CSVParser;
import marathon.Competitor;
import java.util.ArrayList;

/**
 * Created by stephan on 16.03.17.
 */
public class Main {
    public static void main(String args[]) {
        BinarySearchTree<Competitor> searchTree = new BinarySearchTree<Competitor>();
        ArrayList<Competitor> athlets;
        athlets = CSVParser.readFile();
        for(Competitor at : athlets) {
            searchTree.add(at);
        }
        for(Object competitor: searchTree.traverseInorder()){
            System.out.println(competitor.toString());
        }
    }
}
