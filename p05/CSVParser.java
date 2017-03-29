package p05;


import java.io.*;
import java.util.ArrayList;


public abstract class CSVParser {

    public static ArrayList<String[]> readFile(File csvFile) {

        ArrayList<String[]> result = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                try {
                    String[] temp =new String [3];
                    temp[0]=data[0];
                    temp[1]=data[1];
                    if (data.length < 2) {
                       temp[2]="0";
                    }else{
                        temp[2]=data[2];
                    }

                    result.add(temp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
        return result;
    }

}