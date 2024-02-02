package exercise2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class improvisedETL {
    
    private String filename;
    private ArrayList<personInformation> peopleList;

    public improvisedETL(String filename) {
        this.filename = filename;
        this.peopleList = new ArrayList<>();
        completeExercise();
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

    private boolean writeFile() {
        boolean written = false;
        String newFilename = getNewFilename();
        newFilename += ".csv";
        newFilename = "exercise2/" + newFilename;

        try {
            // creates the new file
            PrintWriter writer = new PrintWriter(newFilename, "UTF-8");
            // For each person
            for (personInformation info : peopleList) {
                // if there is a name and creditcard
                String name = info.getName();
                String card = info.getCreditcard();
                if (!name.equals("") && card != null) {
                    // write in the file name,creditcard
                    String line = name + "," + card;
                    writer.println(line);
                    writer.flush();
                }
            } 
            written = true;
            writer.close();        
        } catch (IOException e) {
            System.out.println(e);
        }
        return written;
    }

    private boolean readData() {
        boolean read = false;
        // read the file here
        try {
            FileReader file = new FileReader(this.filename);
            JSONParser parser = new JSONParser();
    
            JSONArray arr = (JSONArray) parser.parse(file);
            for(Object per : arr) {
                JSONObject person = (JSONObject) per;
                String name = (String) person.get("name");
                String email = (String) person.get("email");
                String city = (String) person.get("city");
                String mac = (String) person.get("mac");
                String timestamp = (String) person.get("timestamp");
                String creditcard = (String) person.get("creditcard");
                
                personInformation info = new personInformation(name, email, city, mac, timestamp, creditcard);
                this.peopleList.add(info);
            }

        } catch (IOException | ParseException e) {
            System.out.println(e);
        }

        return read;
    }

    public boolean completeExercise() {
        boolean completed = false;
        readData();
        writeFile();
        return completed;
    }

    public static void main(String[] args) {
        new improvisedETL("exercise2/data.json");
    }
}
