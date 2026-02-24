/**
 * Cereal.java  
 *
 * @author – Your name
 * @author – Class period 
 * 
 */
public class Cereal
{
   private String name; 
   private int calories; 
   private double fiber, carbs, cups; 

   public Cereal(String initName, int initCal, double initFiber, 
                 double initCarbs,  double initCups)
   {
      this.name = initName; 
      this.calories = initCal; 
      this.fiber = initFiber; 
      this.carbs = initCarbs;
      this.cups = initCups; 
   }
   /* Accessor method returns the value stored in the instance variable name. */
   public String getName()
   {
      return this.name;
   }

   /* Accessor method returns the value stored in the instance variable carbs. */      
   public double getCarbs()
   {
      return this.carbs;
   }

   /* Accessor method returns the value stored in the instance variable cups. */       
   public double getCups()
   { 
      return this.cups;
   }

   /* Accessor method returns the value stored in the instance variable fiber. */
   public double getFiber() 
   { 
      return this.fiber;
   }

   /* Accessor method returns the value stored in the instance variable calories.  
    */
   public int getCalories()
   {
      return this.calories;
   }

   /* toString method returns the values stored in the instance variables   
      concatenated in a sentence. */
   @Override
   public String toString()
   {
      return "Cereal: " + this.name + " has: " + this.calories 
              + "calories, in a " + this.cups + " cup serving, with "
              + this.fiber + "grams of fiber and "
              + this.carbs +"grams of carbohydrates";
   }
}