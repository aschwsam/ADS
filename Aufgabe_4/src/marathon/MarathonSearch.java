package marathon;


import java.util.ArrayList;


/**
 * @author Stephan Graf
 * @version 16.3.2017
 */
public class MarathonSearch {
    public static void main() {
        BinarySearchTree searchTree = new BinarySearchTree();
        ArrayList<Competitor> athlets;
        athlets = CSVParser.readFile();
        for(Competitor at : athlets){
            searchTree.add(at);
        }
    }
}
