import java.util.ArrayList;

/**
 * Created by stephan on 16.03.17.
 */
public class MarathonReader {
	
	private ArrayList<Competitor> athlets;
	
	public static void main (String Args[]){
		MarathonReader asd = new MarathonReader();
	}
	
	public MarathonReader(){
		athlets = CSVParser.readFile();
		
		for(Competitor at : athlets){
			System.out.println(at.getFirstName());
		}
	}
}
