package marathon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class CSVParser {

    public static ArrayList<Competitor> readFile(){

    	ArrayList<Competitor> athlets = new ArrayList<Competitor>();
        String csvFile = "src/zuerich_marathon_utf_8.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                
                try{
                	athlets.add(new Competitor(
	            		(int)Integer.parseInt(data[0]),
	            		data[1],
	            		data[2],
	            		(int)Integer.parseInt(data[3]),
	            		data[4],
	            		data[5]));
                } catch (Exception e){
                	e.printStackTrace();
                }
                
                // DEBUG
                //System.out.println("Startnummer: "+data[0]+" Vorname: "+data[1]+" Nachname: "+data[2]+" Jahrgang: "+data[3]+" Ortschaft: "+data[4]+" Zeit: "+data[5]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return athlets;
    }

}