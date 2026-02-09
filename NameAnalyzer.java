import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

/**
 * Part 2: the logic class
 * Handles the file i/o and the data analysis
 *
 * @author mr callaghan
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
     * Uses the nextLine() and split() methods to parse data in a file.
     * 
     * @param fileName the name of the file to load
     * @throws IOException if the file cannot be loaded
     */
    public void loadFile(String fileName) throws IOException
    {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        
        // skip the header line (for now)
        if (reader.hasNextLine())
        {
            // reads the first line of the text file and return the line as a String
            //    consumes the next token(s) until the new line character
            reader.nextLine();
        }
        
        while (reader.hasNextLine())
        {
            String line = reader.nextLine();
            
            // removes any leading or trailing whitespace around the line
            String trimmedLine = line.trim();
            // split() breaks the String into an array based on a specified delimiter
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
                
                // for simplicity, we'll only do boys names (for now...)
            }
            
            
        }
        
        // best practice is to close the scanner when done
        reader.close();

    }
    
    
    public static void main() throws IOException
    {
        NameAnalyzer app = new NameAnalyzer();
        app.loadFile("babynames2010s.txt");
    }
    
    
}
