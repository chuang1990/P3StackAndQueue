
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * FileEditor class
 *
 */
public final class FileEditor {

    // instance variables

    private File file;
    private Scanner scanText;
    private FileReader readText;
    private final ArrayList<String> text;
    private Writer writer;

    public FileEditor(File file) {
        text = new ArrayList<>();
        fileReader();
    }

    /**
     * read from the textFile
        *
     */
    public void fileReader() {
        try {
            //set up variables
            file = new File("hiker.txt");
            readText = new FileReader(file);
            scanText = new Scanner(readText);

            while (scanText.hasNextLine()) {
                String info = scanText.nextLine();
                if (!info.isEmpty()) {
                    text.add(info);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * write hiker info into text file
 *
     */
    public void fileWriter() {
        //need add more
         try{
            //store the time that the file is created into a string
            time = new Date();
            timeStamp = time.toString();
            //create new file
            //file = new File("Hiker"+timeStamp+".txt");
            //creates a writer that uses buffered Writer to writer to the newly created file.
            //timeStamp prevent files to overwrite each other.
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("Hiker"+timeStamp+".txt"), "utf-8"));
                //create a loop that takes in all the created hikers and write them in.
                writer.write("Something");
            } catch (IOException ex) {
                // report
            } finally {
                try {writer.close();} catch (Exception ex) {}
            }
    }
}
