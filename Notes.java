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
        reader.nextLine();
        String name = reader.nextLine();
        System.out.println("Age: " + age + "; Name: " + name);

        //What will be the output of the above program?

    }
}
