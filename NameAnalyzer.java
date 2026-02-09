import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

/**
 * Part 2: The Logic Class
 * 
 * Handles File I/O and Data Analysis algorithms.
 *
 * @author mrcallaghan
 * @version 09feb2026
 */
public class NameAnalyzer
{
    private ArrayList<NameRecord> boyRecords;
    private ArrayList<NameRecord> girlRecords;
    
    public NameAnalyzer()
    {
        this.boyRecords = new ArrayList<NameRecord>();
    }
    
    /**
     * Uses nextLine() and split() to parse data in a text file.
     * 
     * @param fileName the name of the file to load
     * @throws IOException if the file cannot be loaded
     */
    public void loadFile(String fileName) throws IOException
    {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        
        // Skips the header and consumes the first line
        if (reader.hasNextLine())
        {
            // reads in the next line of the file as a String
            reader.nextLine();
        }
        
        while (reader.hasNextLine())
        {
            String line = reader.nextLine();
            
            // trim() removes leading and trailing whitespace
            String trimmedLine = line.trim();
            
            // split() breaks the String into an array based on whitespace
            // "\\s+" is a regular expression that matches one or more whitespace characters
            String[] parts = trimmedLine.split("\\s+");
            
            // Ensure we have enough data: rank, boy name, boy count
            if (parts.length >= 3)
            {
                int rank = Integer.parseInt(parts[0]);
                String name = parts[1];
                // Remove commas from numbers before parsing
                String countStr = parts[2].replace(",", "");
                int count = Integer.parseInt(countStr);
                
                // Create a NameRecord object and add it to our collection
                boyRecords.add(new NameRecord(rank, name, count));
                
                // For simplicity, we'll only scan in the boys names for now
            }

        }
        
        // Best practice to close the scanner to free resources
        reader.close();

    }
    
    public static void main() throws IOException
    {
        NameAnalyzer app = new NameAnalyzer();
        app.loadFile("babynames2010s.txt");
        
    }
    
    
    
    
    
    
    
    
    
}
