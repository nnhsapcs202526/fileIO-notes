import java.util.Scanner;

/**
 * Examples and notes on File I/O
 *
 * @author 
 * @version 
 */
public class Notes
{
    public static void main()
    {
        Scanner reader = new Scanner("17\nAlex");
        int age = reader.nextInt();
        String name = reader.nextLine();
        
        System.out.println("Age: " + age);
        System.out.println("Name: " + name);
        
    }
}