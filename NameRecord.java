
/**
 * Part 1: the data model
 * Represents a single name record
 *
 * @author mrcallaghan
 * @version 09feb2026
 */
public class NameRecord
{
    private int rank;
    private String name;
    private int count;

    public NameRecord(int initRank, String initName, int initCount)
    {
        this.rank = initRank;
        this.name = initName;
        this.count = initCount;
    }
    
    // accessor methods
    public int getRank() { return this.rank; }
    public String getName() { return this.name; }
    public int getCount() { return this.count; }

    public String toString()
    {
        return "#" + this.rank + ": " + this.name + " (" + this.count + ")";
        
    }
    

}
