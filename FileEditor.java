
import java.util.Scanner;
import java.io.*;
import java.util.Date;

/**
 * FileEditor class
 * 
 * @Catherine
 * @version 10/18/2014
 */
public final class FileEditor {

    // instance variables

    private File file;
    private Scanner scanText;
    private FileReader readText;
    private Date time;
    private Writer writer = null;

    public FileEditor(String s){
        fileWriter(s);
    }

   
    /**
     * Create a file and write hiker info into it.
     */
    public void fileWriter(String s) {
        //need add more
         try{
            //store the time that the file is created into a string
            time = new Date();
            String timeStamp = time.toString();
            //create new file
            //file = new File("Hiker"+timeStamp+".txt");
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("Hiker"+timeStamp+".txt"), "utf-8"));
                
                writer.write(s);
                
            } catch (IOException ex) {
                // report
            } finally {
                try {writer.close();} catch (Exception ex) {}
            }
    }
}
