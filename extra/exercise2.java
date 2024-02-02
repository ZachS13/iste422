package extra;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class exercise2 {
    private String filename;
    
    public exercise2(String filename) {
        this.filename = filename;
    }

    private String getNewFilename() {
        // get the time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
        // convert to a string
        String time = dtf.format(now);
        // return the time as a string
        return time;
    }

    public boolean writeReport(ArrayList<personInformation> people) {
        boolean didFileWrite = false;
        // name of the new file
        String newFilename = getNewFilename();
        newFilename += "ex.csv";

        try {
            PrintWriter writer = new PrintWriter(newFilename, "UTF-8");
            // For each person
            for(personInformation info : people) {
                // if there is a name and creditcard
                String name = info.getName();
                String card = info.getCreditcard();
                if(!name.equals("") && !card.equals("null")){
                    // write in the file name,creditcard 
                    String line = name + "," + card;
                    writer.println(line);
                    writer.flush();
                }
            }
            writer.close();        
        } catch (IOException e) {
            System.out.println(e);
        }

        // return if the file is written
        return didFileWrite;
    }

    public ArrayList<personInformation> readData() {
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

    public static void main(String[] args) {
        exercise2 ex = new exercise2("extra/smaller.json");

        personInformation p1 = new personInformation("one", null, null, null, null, "123-123-1234");
        personInformation p2 = new personInformation("two", null, null, null, null, "321-321-4321");
        ArrayList<personInformation> test = new ArrayList<>();
        test.add(p1);
        test.add(p2);

        ArrayList<personInformation> test2 = ex.readData();
        ex.writeReport(test2);
    }
}   