package exercise2;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class improvisedETL {
    
    private String filename;
    private ArrayList<personInformation> peopleList;

    public improvisedETL(String filename) {
        this.filename = filename;
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

        try {
            // creates the new file
            PrintWriter writer = new PrintWriter(newFilename, "UTF-8");
            // For each person
            for (personInformation info : peopleList) {
                // if there is a name and creditcard
                String name = info.getName();
                String card = info.getCreditcard();
                if (!name.equals("") && !card.equals("null")) {
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
        return read;
    }

    public boolean completeExercise() {
        boolean completed = false;
        readData();
        writeFile();
        return completed;
    }

    public static void main(String[] args) {
        new improvisedETL("data.json");
    }
}
