
import java.util.Scanner;
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
    }
}
