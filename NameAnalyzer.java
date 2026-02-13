import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * Part 2: The Logic Class
 * Handles File I/O and Data Analysis algorithms.
 */
public class NameAnalyzer {
    private ArrayList<NameRecord> boyRecords;
    private ArrayList<NameRecord> girlRecords;
    private int totalBoyCount;
    private int totalGirlCount;

    public NameAnalyzer() {
        this.boyRecords = new ArrayList<NameRecord>();
        this.girlRecords = new ArrayList<NameRecord>();
        this.totalBoyCount = 0;
        this.totalGirlCount = 0;
    }

    /**
     * Uses nextLine() and split() to parse data in the file.
     *  
     * @param fileName the name of the file to load
     * @throws IOException if the file cannot be loaded
     */
    public void loadFile(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);

        if (reader.hasNextLine()) {
            this.totalBoyCount = Integer.parseInt(reader.next().replace(",", ""));
            this.totalGirlCount = Integer.parseInt(reader.next().replace(",", ""));
        }

        while (reader.hasNextLine()) {
            // nextLine() reads the entire row as a single String
            String line = reader.nextLine();

            // trim() removes leading and trailing whitespace
            String trimmedLine = line.trim();
            // split() breaks the String into an array based on whitespace
            // "\\s+" is a regular expression that matches one or more whitespace characters
            String[] parts = trimmedLine.split("\\s+");

            // Ensure we have enough data: rank, boy name, boy count
            if (parts.length >= 3) {
                int rank = Integer.parseInt(parts[0]);
                String name = parts[1];
                // Remove commas from numbers before parsing
                String countStr = parts[2].replace(",", "");
                int count = Integer.parseInt(countStr);

                // Create NameRecord object and add to collection
                boyRecords.add(new NameRecord(rank, name, count));

                // For simplicity, we are only processing boy names in this example. 
            }
        }
        // Best practice to close the scanner to free resources
        reader.close();
    }

    public void loadFileGirls(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);

        if (reader.hasNextLine()) {
            this.totalBoyCount = Integer.parseInt(reader.next().replace(",", ""));
            this.totalGirlCount = Integer.parseInt(reader.next().replace(",", ""));
        }

        // use next() and nextInt() to read data in the file
        while (reader.hasNext()) {
            int rank = reader.nextInt();
            reader.next();
            reader.next();
            String name = reader.next();
            String countStr = reader.next().replace(",", "");
            int count = Integer.parseInt(countStr);
            // Create NameRecord object and add to collection
            girlRecords.add(new NameRecord(rank, name, count));
        }
        reader.close();
    }

    /**
     * Search Algorithm: Finding a NameRecord by name and printing it.
     * 
     * @param name name to search for
     */
    public void printCountByName(String name) {
        for (NameRecord record : boyRecords) {
            String recordName = record.getName();
            if (recordName.equalsIgnoreCase(name)) {
                System.out.println(record);
                return;
            }
        }
        for (NameRecord record : girlRecords) {
            String recordName = record.getName();
            if (recordName.equalsIgnoreCase(name)) {
                System.out.println(record);
                return;
            }
        }
        System.out.println("Name not found: " + name);
    }

    /*
        Write the method printRecords(), which should print the data table out for boys and girls records 
        in a similar format as the original data file (rows and columns).
    */
   public void printRecords() {
        System.out.println("\nTotal Boy Count: " + this.totalBoyCount);
        System.out.println("Total Girl Count: " + this.totalGirlCount);
        System.out.println("Rank\tBoy Name\tCount\tGirl Name\tCount");
        int maxRecords = Math.max(boyRecords.size(), girlRecords.size());
        String boyName = "";
        int boyCount = 0;
        String girlName = "";
        int girlCount = 0;
        for (int i = 0; i < maxRecords; i++) {
            // do not use ternary operator, use if statements to check if the index is within bounds for each list
            
            if (i < boyRecords.size()) {
                NameRecord boyRecord = boyRecords.get(i);
                boyName = boyRecord.getName();
                boyCount = boyRecord.getCount();
            }
            if (i < girlRecords.size()) {
                NameRecord girlRecord = girlRecords.get(i);
                girlName = girlRecord.getName();
                girlCount = girlRecord.getCount();
            }
            System.out.println((i + 1) + "\t" + boyName + "\t" + boyCount + "\t" + girlName + "\t" + girlCount);
        }
    }

    /*
        Write a second version of this method, which should print out the top n names, as defined by the parameter n.
     */
    public void printRecords(int n) {
        System.out.println("\nTotal Boy Count: " + this.totalBoyCount);
        System.out.println("Total Girl Count: " + this.totalGirlCount);
        System.out.println("Rank\tBoy Name\tCount\tGirl Name\tCount");
        for (int i = 0; i < n; i++) {
            String boyName = "";
            int boyCount = 0;
            String girlName = "";
            int girlCount = 0;
            if (i < boyRecords.size()) {
                NameRecord boyRecord = boyRecords.get(i);
                boyName = boyRecord.getName();
                boyCount = boyRecord.getCount();
            }
            if (i < girlRecords.size()) {
                NameRecord girlRecord = girlRecords.get(i);
                girlName = girlRecord.getName();
                girlCount = girlRecord.getCount();
            }
            System.out.println((i + 1) + "\t" + boyName + "\t" + boyCount + "\t" + girlName + "\t" + girlCount);
        }

    }

    public static void main(String[] args) throws IOException {
        String[] fileNames = {"babynames60s.txt", "babynames70s.txt", "babynames80s.txt", "babynames90s.txt", 
                          "babynames2000s.txt", "babynames2010s.txt"};
        NameAnalyzer app = new NameAnalyzer();
        app.loadFile("babynames2010s.txt");
        app.loadFileGirls("babynames2010s.txt");
        app.printCountByName("Matthew");
        app.printCountByName("Craig");
        app.printCountByName("Hayes");
        app.printCountByName("Jessica");
        app.printRecords();
        app.printRecords(100);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name to search: ");
        String name = scanner.nextLine();
        for (String fileName : fileNames) {
            app = new NameAnalyzer();
            app.loadFile(fileName);
            app.loadFileGirls(fileName);
            System.out.println("\nSearching in " + fileName + "...");
            app.printCountByName(name);
        }
        
    }
}