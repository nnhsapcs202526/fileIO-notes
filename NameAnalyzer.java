import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

/**
 * Part 2: The logic class
 * Handles the file i/o and the data analysis algorthms.
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
        this.girlRecords = new ArrayList<NameRecord>();
    }
    
    /**
     * Uses the nextLine() and the split() method to parse the data in a text file.
     * 
     * @param fileName the name of the file to load
     * @throws IOException if the fiel cannot be loaded
     */
    public void loadFile(String fileName) throws IOException
    {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        
        // Skip the header line
        if (reader.hasNextLine())
        {
            // nextLine() cosumes (reads) the next line in teh text file and return it as a String
            reader.nextLine();
        }
        
        while (reader.hasNextLine())
        {
            String line = reader.nextLine();
            
            // trim() removes any leading or trailing whitespace from the String
            String trimmedLine = line.trim();
            //split() breaks the line into an array based on some specified delimiter
            // "\\s+" is a regular expression that matches one or more whitespace characters
            String[] parts = trimmedLine.split("\\s+");
            
            if (parts.length >= 3)
            {
                int rank = Integer.parseInt(parts[0]);
                String name = parts[1];
                String countStr = parts[2].replace(",", "");
                int count = Integer.parseInt(countStr);
                
                NameRecord boyName = new NameRecord(rank, name, count);
                boyRecords.add(boyName);
                
                // for simplicity we'll stop with just boys for now...
                
            }
        }
        
        // best practice is to close the scanner to free resources
        reader.close();
    }
    
    
    public static void main() throws IOException
    {
        NameAnalyzer app = new NameAnalyzer();
        app.loadFile("babynames2010s.txt");
        
    }
    
    
    

}
