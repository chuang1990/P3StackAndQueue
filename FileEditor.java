
import java.util.Date;
import java.util.Scanner;
import java.io.*;
/**
 * The FileEditor class
 * 
 * The Class FileEditor is in charge of the interations with the file. 
 * It has methods that allow it to write in to a file
 * 
 * @author  (Catherine Huang, Hannah Riggs, Maria del Mar Moncaleano) 
 * @version 1/17/14
 */
public final class FileEditor 
{
    private File file;
    private Scanner scanText;
    private FileReader readText;
    private Writer writer;
    private Date time;

    public FileEditor(String s)
    {
        fileWriter(s);
    }

    /**
     * Create a file and write hiker info into it.
     */
    public void fileWriter(String s) 
    {
        try
        {
            //store the time that the file is created into a string
            time = new Date();
            String timeStamp = time.toString();
            //creates a writer that uses buffered Writer to writer to the newly created file.
            //timeStamp prevent files to overwrite each other.
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("Hiker"+timeStamp+".txt"), "utf-8"));
            //create a loop that takes in all the created hikers and write them in.
            writer.write(s);

        } 
        catch (IOException ex) 
        {
            // report
        } 
        finally 
        {
            try
            {
                writer.close();
            } 
            catch (Exception ex) {}
        }
    }
}
