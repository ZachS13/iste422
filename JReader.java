import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JReader {

    private String filename;

    /**
     * Takes in a JSON file path.
     * @param filename - Path to the JSON file
     */
    public JReader(String filename) {
        this.filename = filename;
    }

    public String getFilename() { return filename; }

    /**
     * With the given file name, it will read and extract the data from the file.
     */
    public void parseJSON() {
        // open the file
        try {
            File myObj = new File(this.filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            System.out.println(this.filename);
        }
    } 
}
