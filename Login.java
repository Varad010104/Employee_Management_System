package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * Step 12: Implementing ActionListener to handle button clicks
 * ActionListener is used to define the actions when buttons are clicked.
 */
public class Login extends JFrame implements ActionListener {

    // Step 4: Declaring text fields for username and password globally
    JTextField tusername;
    JPasswordField tpassword;

    // Step 7: Declaring buttons for login, back, and sign-up
    JButton login, back, signUp;

    // Constructor to set up the login UI
    Login(){

        // Step 2: Creating and setting the "Enter The UserName" label
        JLabel username = new JLabel("Enter The UserName:");
        username.setBounds(40, 20, 200, 30); // Setting label position and size
        add(username); // Adding the label to the frame

        // Step 5: Creating a text field for the username input
        tusername = new JTextField();
        tusername.setBounds(200, 23, 200, 30); // Setting the text field's position and size
        add(tusername); // Adding the text field to the frame

        // Step 3: Creating and setting the "Enter The Password" label
        JLabel password = new JLabel("Enter The Password:");
        password.setBounds(40, 70, 200, 30); // Setting label position and size
        add(password); // Adding the label to the frame

        // Step 6: Creating a password field for the password input
        tpassword = new JPasswordField();
        tpassword.setBounds(200, 73, 200, 30); // Setting password field's position and size
        add(tpassword); // Adding the password field to the frame

        // Step 8: Creating the Login button
        login = new JButton("LOGIN");
        login.setBounds(100, 150, 100, 30); // Setting button position and size
        login.setBackground(Color.BLACK); // Setting button background color
        login.setForeground(Color.WHITE); // Setting button text color
        login.addActionListener(this); // Adding ActionListener to handle button click
        add(login); // Adding button to the frame

        // Step 9: Creating the Sign-Up button
        signUp = new JButton("SIGN-UP");
        signUp.setBounds(230, 150, 100, 30); // Setting button position and size
        signUp.setBackground(Color.DARK_GRAY); // Setting background color
        signUp.setForeground(Color.WHITE); // Setting text color
        signUp.addActionListener(this); // Adding ActionListener
        add(signUp); // Adding button to the frame

        // Step 10: Creating the Back button
        back = new JButton("Back");
        back.setBounds(350, 150, 100, 30); // Setting button position and size
        back.setBackground(Color.BLUE); // Setting button background color
        back.setForeground(Color.WHITE); // Setting button text color
        back.addActionListener(this); // Adding ActionListener
        add(back); // Adding button to the frame

        // Step 11: Adding the Login image (a background image for the Login page)
        ImageIcon LoginIcon1 = new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image LoginIcon2 = LoginIcon1.getImage().getScaledInstance(800, 300, Image.SCALE_DEFAULT);
        ImageIcon LoginIcon3 = new ImageIcon(LoginIcon2);
        JLabel LoginImage = new JLabel(LoginIcon3);
        LoginImage.setBounds(500, 10, 800, 300); // Setting image position and size
        add(LoginImage); // Adding image to the frame

        // Adding a background image to the Login page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 300); // Setting background image position and size
        add(image); // Adding the background image to the frame

        // Step 1: Setting up the Login frame
        setSize(800, 300); // Setting the size of the window
        setLocation(400, 300); // Setting the position of the window on screen
        setLayout(null); // Setting layout manager to null (absolute positioning)
        setVisible(true); // Making the frame visible
    }

    // Step 13: Overriding the actionPerformed method to define actions on button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Step 16: Handling the action when the login button is clicked
        if (e.getSource() == login) {
            // Getting the values entered in the username and password fields
            try {
                String username = tusername.getText();  // Fetching entered username
                String password = new String(tpassword.getPassword());  // Fetching entered password

                // Step 17: Creating a new connection to the database
                conn conn = new conn();
                // Step 18: Defining the SQL query to check if the username and password exist in the Admin table
                String Query = "select * from Admin where username = '" + username + "' and userPassword = '" + password + "'";

                // Step 19: Executing the query
                ResultSet result = conn.statement.executeQuery(Query);

                // Step 20: If the result is valid, login is successful, and the Home page is shown
                if (result.next()) {
                    new Home();  // Opening the Home page
                    setVisible(false);  // Closing the login frame
                } else {
                    // If username or password is incorrect, show an error message
                    JOptionPane.showMessageDialog(null, "Invalid UserName and Password\nCheck If You Signed Up or Not");
                }
            } catch (Exception exception) {
                exception.printStackTrace(); // Handling any exceptions that occur
            }

        } else if (e.getSource() == signUp) {
            // Step 21: If the Sign-Up button is clicked, open the Sign-Up page
            new SignUp();
            setVisible(false); // Closing the login frame

        } else if (e.getSource() == back) {
            // Step 22: If the Back button is clicked, exit the program
            System.exit(209);
        }
    }

    // Main method to run the Login class
    public static void main(String[] args) {
        new Login(); // Creating an instance of the Login class (this opens the login window)
    }
}
