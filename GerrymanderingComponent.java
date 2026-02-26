import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Class that prompts the user, analyzes data, and vidualizes data on Gerrymandering.
 * 
 * @author 
 * @version  
 */
public class GerrymanderingComponent extends JComponent
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 1000;

    private ArrayList<District> districts;
    private String selectedState;
    private int eligibleVoters;
    private int totalWastedDemocraticVotes;
    private int totalWastedRepublicanVotes;
    private boolean isGerrymanderedForDemocrats;
    private boolean isGerrymanderedForRepublicans;

    public GerrymanderingComponent()
    {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.districts = new ArrayList<District>();

        this.promptForState();

        boolean validState = this.getEligibleVoters();
        if(!validState)
        {
            System.out.println("\"" + this.selectedState + "\" not found.");
        }
        else
        {
            this.analyzeDistrictData();

            System.out.println("Total Wasted Democratic votes: " + this.totalWastedDemocraticVotes);
            System.out.println("Total Wasted Republican votes: " + this.totalWastedRepublicanVotes);

            if(this.isGerrymanderedForDemocrats)
            {
                System.out.println("Gerrymandered benefiting the Democrats");    
            }
            else if(this.isGerrymanderedForRepublicans)
            {
                System.out.println("Gerrymandered benefiting the Republicans");    
            }

            System.out.println(this.eligibleVoters + " eligible voters");
        }

    }

    /**
     * Via the terminal, displays a summary of the program and prompts
     *      the user to enter a state.
     *  @postcondition the selectedState instance variable is set
     *      to the user's input
     */
    private void promptForState()
    {
        // TODO: implement method to meet requirements specified in the
        //      above Javadoc comment

    }

    /**
     * Searches the eligible_voters.txt file for the line corresponding
     *      to the state that was previously specified. If found,
     *      updates the eligibleVoters instance variable accordingly.
     *  @postcondition the eligibleVoters instance variable is set
     *      to the number of eligible voters for the specified state
     *      based on the eligible_voters.txt file
     *  @return true if the specified state was found; otherwise, false
     */
    private boolean getEligibleVoters()
    {
        boolean foundState = false;
        
        try
        {
            File votersFile = new File("eligible_voters.txt");
            Scanner votersScanner = new Scanner(votersFile);
            votersScanner.useDelimiter("[\r\n,]+");
            
            // TODO: implement a looping structure to meet requirements
            //      specified in the above Javadoc comment
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }

        return foundState;
    }

    /**
     * Parses the districts.txt file for all lines that match
     *      the specified state. For each matching district, invoke
     *      the addDistrictData method.
     * @postcondition totalWastedDemocraticVotes reflects the number
     *      of wasted votes based on the algorithm
     * @postcondition totalWastedRepublicanVotes reflects the number
     *      of wasted votes based on the algorithm
     * @postcondition the isGerrymanderedForRepublicans or
     *      isGerrymanderedForDemocrats is set to true if the state
     *      is gerrymandered based on the algorithm defined in the
     *      lab document
     */
    private void analyzeDistrictData()
    {
        this.totalWastedDemocraticVotes = 0;
        this.totalWastedRepublicanVotes = 0;
        int numOfDistricts = 0;

        try
        {
            File districtFile = new File("districts.txt");
            Scanner districtsScanner = new Scanner(districtFile );
            districtsScanner.useDelimiter("[\r\n,]+");
            
            // TODO: implement looping structures to meet requirements
            //      specified in the above Javadoc comment
            
            

            // TODO: implement algorithm to determine if the specified state 
            //      is gerrymandered
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
    }

    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     * 
     * @param g a reference to the Graphics object used for all drawing operations
     *
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        this.drawTableHeader(g2);
        this.drawDistricts(g2);
    }
    
    /**
     * Add the number of democratic votes and republican votes associated with the specified
     *      district number to the list of districts in the state being analyzed.
     *      
     * @postcondition the list of districts in the state being analyzed is updated
     *      with the new district data
     * @param districtNumber the number of the district in the state being analyzed
     * @param democraticVotes the number of democratic votes in the specified district
     * @param republicanVotes the number of republican votes in the specified district
     */
    private void addDistrictData(int districtNumber, int democraticVotes, int republicanVotes)
    {
        // TODO: implement method to meet requirements specified in the
        //      above Javadoc comment
    }

    /**
     * Draws the header for the table that displays the state being analyzed and
     *      the number of democratic and republican votes in each district.
     *      
     * @param g2 a reference to the Graphics2D object used for all drawing operations
     */
    private void drawTableHeader(Graphics2D g2)
    {
        g2.setColor(Color.BLACK);

        Line2D.Double header = new Line2D.Double(0, 20, WIDTH, 20);
        g2.draw(header);

        Line2D.Double centerLine = new Line2D.Double(WIDTH/2, 0, WIDTH/2, HEIGHT);
        g2.draw(centerLine);

        int textHeight = g2.getFontMetrics().getHeight();
        g2.drawString(this.selectedState, 0, textHeight);
        g2.drawString(this.eligibleVoters + " eligible voters", WIDTH - 175, textHeight);

    }
    
    /**
     * Draws the bar visualizaing the number of democratic and republican votes for
     *      each district in state being analyzed.
     *      
     * @param g2 a reference to the Graphics2D object used for all drawing operations
     */
    private void drawDistricts(Graphics2D g2)
    {
        final int BAR_HEIGHT = 25;
        final int BAR_SPACING = 5;
        final int BAR_START_Y = 25;
        
        int y = BAR_START_Y;
        
        for(District district : this.districts)
        {
            double democraticWidth = (double)district.getDemocratVotes() /
                    (district.getDemocratVotes() + district.getRepublicanVotes()) * WIDTH;
            
            Rectangle2D.Double democraticBar =
                    new Rectangle2D.Double(0, y, democraticWidth, BAR_HEIGHT);
            g2.setColor(Color.BLUE);
            g2.fill(democraticBar);

            Rectangle2D.Double republicanBar =
                    new Rectangle2D.Double(democraticWidth, y, WIDTH - democraticWidth, BAR_HEIGHT);
            g2.setColor(Color.RED);
            g2.fill(republicanBar);
            
            y += BAR_HEIGHT + BAR_SPACING;
        }
    }
}
