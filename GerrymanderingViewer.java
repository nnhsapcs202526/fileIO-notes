import javax.swing.JFrame;

/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author gcschmit
 * @version 14 June 2022
 */
public class GerrymanderingViewer
{
    /**
     * main method for the program which creates and configures the frame for the program
     * 
     * @param args  not used
     *
     */
    public static void main(String[] args)
    {
        // create and configure the frame (window) for the program
        JFrame frame = new JFrame();

        frame.setTitle("Gerrymandering"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // a frame contains a single component
        // create the Gerrymandering component and add it to the frame
        GerrymanderingComponent component = new GerrymanderingComponent();
        frame.add(component);
        frame.pack();

        // make the frame visible which will result in the paintComponent method being
        //  invoked on the component.
        frame.setVisible(true);
    }
}
