package employee.management.system;

// Importing necessary classes for creating the frame
import javax.swing.*;
import java.awt.*;

// Extending JFrame to create a custom Splash screen window
public class Splash extends JFrame {

    // Constructor for the Splash class
    Splash() {

        // Step 1: Load the animated image (GIF) for the splash screen
        // Using ClassLoader to locate the resource (image in this case)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/front.gif"));

        // Step 2: Scale the image to fit the window size
        // Get the image and resize it to fit the desired dimensions (1170x650)
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);

        // Step 3: Create a new ImageIcon using the scaled image
        ImageIcon i3 = new ImageIcon(i2);

        // Step 4: Create a JLabel to hold the image
        // JLabel is a component that can hold an image or text, or both.
        JLabel image = new JLabel(i3);

        // Step 5: Set the size and position of the image within the frame using setBounds(x, y, width, height)
        image.setBounds(0, 0, 1170, 650);

        // Step 6: Add the image to the JFrame
        add(image);

        // Step 7: Set the size of the frame (the splash window)
        // The splash window will be 1170 pixels wide and 650 pixels high
        setSize(1170, 650);

        // Step 8: Position the splash window on the screen (200 pixels from the left, 80 pixels from the top)
        setLocation(200, 80);

        // Step 9: Set the layout manager of the frame to null (no layout manager is used here)
        setLayout(null);

        // Step 10: Make the splash window visible
        setVisible(true);

        /**
         * Step 11: Adding a delay before the splash screen disappears and the login page opens
         * Use Thread.sleep() to pause the execution for 6 seconds (6000 milliseconds)
         * After the pause, the splash screen will be hidden and the login page will be shown.
         */
        try {
            // Step 12: Pause the thread (splash screen remains visible for 6 seconds)
            Thread.sleep(6000);

            // Step 13: After 6 seconds, hide the splash screen
            setVisible(false);

            // Step 14: Create and show the login window after the splash screen disappears
            // The Login class should be the class that handles the login functionality
            new Login();

        } catch (Exception e) {
            // Step 15: Handle any exceptions that might occur (for example, if the image is not found)
            e.printStackTrace();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Step 16: Create an instance of the Splash class, which will automatically display the splash screen
        new Splash();
    }
}
