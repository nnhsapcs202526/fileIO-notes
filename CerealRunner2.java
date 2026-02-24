import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CerealRunner2 
{
   private ArrayList<Cereal> cereals;
		
   public CerealRunner2(String fileName)
   {
      cereals = new ArrayList<Cereal>();

      try 
      {
         FileReader fileRdr = new FileReader(fileName);
         Scanner scan = new Scanner(fileRdr);
         while(scan.hasNext())
         {
            String myStr = scan.nextLine();

            String[] myArray = myStr.split(",");  
				
            String name = myArray[0];
            int calories = Integer.parseInt(myArray[1]);
            double fiber = Double.parseDouble(myArray[2]); 
            double carbs = Double.parseDouble(myArray[3]); 
            double cups = Double.parseDouble(myArray[4]); 
				
            cereals.add(new Cereal(name, calories, fiber, carbs, cups));
				
         } //close while
         scan.close();

      } catch (FileNotFoundException e) 
        {
         System.out.println("An error occurred.");
         e.printStackTrace();
        }

      int numCereals = cereals.size();
      System.out.println( numCereals + " records created.");			
   }
		
      public static void main(String[] args) 
      {
         String fileName = "cerealSubset.csv";
         CerealRunner2 cr = new CerealRunner2(fileName);
      }
}	