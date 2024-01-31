import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class exercise2 {
    private String filename;
    
    public exercise2(String filename) {
        this.filename = filename;
    }

    public ArrayList<personInformation> readData() {
        ArrayList<personInformation> people = new ArrayList<>();
        JReader read = new JReader(this.filename);
        people = read.parseJSON();  
        return people;
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
        newFilename += ".csv";

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

    public static void main(String[] args) {
        exercise2 ex = new exercise2("smaller.json");

        personInformation p1 = new personInformation("one", null, null, null, null, "123-123-1234");
        personInformation p2 = new personInformation("two", null, null, null, null, "321-321-4321");
        ArrayList<personInformation> test = new ArrayList<>();
        test.add(p1);
        test.add(p2);

        ArrayList<personInformation> test2 = ex.readData();
        ex.writeReport(test2);
    }
}   