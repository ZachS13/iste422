package extra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class superProperJSON {

    private String filename;

    /**
     * Takes in a JSON file path.
     * @param filename - Path to the JSON file
     */
    public superProperJSON(String filename) {
        this.filename = filename;
    }

    public String getFilename() { return filename; }

    /**
     * With the given file name, it will read and extract the data from the file.
     */
    public ArrayList<personInformation> parseJSON() {
        ArrayList<personInformation> peopleData = new ArrayList<>();
        try {
            // open the file
            File myObj = new File(this.filename);
            Scanner myReader = new Scanner(myObj);
            // read the file
            int count = 0;
            String name = null, email = null, city = null, mac = null, timestamp = null, creditcard = null;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                line = line.replaceAll(" ", "");
                line = line.replaceAll(",", "");
                char[] value = line.toCharArray();
                // find the first open bracket
                if(value[0] == '{') {
                    count ++;
                    name = null;
                    email = null;
                    city = null;
                    mac = null;
                    timestamp = null;
                    creditcard = null;
                }
                // make sure the bracket gets closed
                else if (value[0] == '}') {
                    count--;
                    personInformation person = new personInformation(name, email, city, mac, timestamp, creditcard);
                    System.out.println(name + " was added to the array");
                    peopleData.add(person);
                }
                // read the data in between the brackets
                else if(count == 1) {
                    String[] keyValue = line.split("\":");
                    String key = keyValue[0].replaceAll("\"", "");
                    String val = keyValue[1].replaceAll("\"", "");
                    // name, email, city, mac, timestamp, creditcard
                    if(key.equals("name")) {
                        name = val;
                    } else if(key.equals("email")){
                        email = val;
                    } else if(key.equals("city")){ 
                        city = val;
                    } else if(key.equals("mac")){
                        mac = val;
                    } else if (key.equals("timestamp")) {
                        timestamp = val;
                    } else if (key.equals("creditcard")) {
                        creditcard = val;
                    }
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            System.out.println(this.filename);
        }
        return peopleData;
    } 
}
