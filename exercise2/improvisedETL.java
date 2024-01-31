package exercise2;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class improvisedETL {
    
    private String filename;

    public improvisedETL(String filename) {
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

    private boolean writeFile() {
        boolean written = false;
        String newFilename = getNewFilename();
        newFilename += ".csv";

        try {
            // creates the new file
            PrintWriter writer = new PrintWriter(newFilename, "UTF-8");

            // check if the name and the creditcard are not null / blank
                // true add it to the file

                // false do not add to the file 

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

}
