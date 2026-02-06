import java.util.Scanner;

/**
 * Models a form to be completed by a visitor to the University
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Form
{
    private boolean isValid;
    private int streetNum;
    private int age;

    /**
     * Constructor for objects of class Form.
     * 
     * Prompts the user via the terminal to complete each field in the form.
     */
    public Form()
    {
        // asumme the form is valid
        this.isValid = true;
        
        Scanner in = new Scanner(System.in);
        
        // collect the user's street number
        System.out.print("Enter the street number of your address: ");
        String streetNumStr = in.nextLine();
        this.streetNum = validateAndConvertStreetNum(streetNumStr);
        if(!this.isValid)
        {
            return;
        }

        // Collect the user's age
        System.out.println("Enter your age: ");
        String ageStr = in.nextLine();
        this.age = validateAndConvertAge(ageStr); // TODO: finish this method
        if(!this.isValid)
        {
            return;
        }

        // TODO: collect more pieces of information

        
    }
    
    /**
     * Returns true if the form is valid (i.e., all fields are completed and validated)
     * @return true if the form is valid (i.e., all fields are completed and validated)
     */
    public boolean isValid()
    {
        return this.isValid;
    }
    
    /**
     * Returns a string containing each field and the user's value for that field.
     * @return a string containing each field and the user's value for that field.
     */
    public String toString()
    {
        String str = "=====================\n";
        str += "We've collected the following information:\n";
        str += "- Street Number:" + streetNum + "\n";
        str += "- Age:" + age + "\n";
        // add more
        str += "=====================\n";
        str += "Form complete!";
        
        return str;
    }

    /**
     * Validates the string representing a street number against each of the specified test cases for the street number field.
     * 
     * @param streetNumStr the string representing a street number
     * @return if valid, the street number as an int; otherwise, -1
     */
    private int validateAndConvertStreetNum(String streetNumStr)
    {

        // Check to see if it's empty!
        if(streetNumStr.equals(""))
        {
            this.isValid = false;
            System.out.println("SORRY! You forgot to enter your number!");
            return -1;
        }

        // Check to see if it's a number!
        int streetNum = convertStringToPositiveInt(streetNumStr);
        if(streetNum == -1)
        {
            this.isValid = false;
            System.out.println("SORRY! Your number should be a positive number");
            return -1;
        }

        return streetNum;
    }

    /**
     * Validates the string representing an age against each of the specified test cases for the agefield.
     * 
     * @param ageStr the string representing an age
     * @return if valid, the age as an int; otherwise, -1
     */
    private int validateAndConvertAge(String ageStr)
    {
        return 0;
    }
    
    /**
     * Attempts to convert the specified string to a positive integer.
     * 
     * @param potentialInt the string representing a potential postive integer
     * @return if valid, the integer as an int; otherwise, -1
     */
    private static int convertStringToPositiveInt(String potentialInt)
    {
        int val = -1;
        
        try
        {
            val = Integer.parseInt(potentialInt);
            if(val < 0 )
            {
                val = -1;
            }
        }
        catch(NumberFormatException e)
        {
        }
        
        return val;
    }
    
    /**
     * The main method that creates a new Form, checks if it is valid, and prints the form.
     */
    public static void main(String[] args)
    {
        Form form = new Form();
        if(form.isValid())
        {
            System.out.println(form);
        }
        else
        {
            System.out.println("Form failed: Restart the form!");
        }
    }
}
