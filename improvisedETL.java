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
        // write the file here
        return written;
    }

    private boolean readData() {
        boolean read = false;
        // read the file here
        return read;
    }

}
