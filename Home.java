package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    // Step 1: Declare buttons for various actions
    JButton AddEmployee, ViewEmployee, RemoveEmployee, LogOut;

    // Constructor to initialize the home page UI
    public Home() {

        // Step 2: Adding background image to the home page
        // Create an ImageIcon for the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
        // Scale the image to fit the frame
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        // Create a new ImageIcon from the scaled image
        ImageIcon i3 = new ImageIcon(i2);
        // Create a JLabel to hold the image
        JLabel img = new JLabel(i3);
        // Set the position and size of the JLabel to cover the frame
        img.setBounds(0, 0, 1120, 630);
        // Add the image to the frame
        add(img);

        // Step 3: Adding a heading to the page
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340, 155, 400, 40); // Set position and size of heading
        heading.setFont(new Font("Raleway", Font.BOLD, 25)); // Set font for heading
        img.add(heading); // Add heading to the image (background panel)

        // Step 4: Adding "Add Employee" button
        AddEmployee = new JButton("Add Employee");
        AddEmployee.setBounds(335, 270, 150, 40); // Set position and size of button
        AddEmployee.setForeground(Color.WHITE); // Set text color of the button
        AddEmployee.setBackground(Color.BLACK); // Set background color of the button
        AddEmployee.addActionListener(this); // Add ActionListener to handle button click
        img.add(AddEmployee); // Add button to the image panel

        // Step 5: Adding "View Employee" button
        ViewEmployee = new JButton("View Employee");
        ViewEmployee.setBounds(565, 270, 150, 40); // Set position and size of button
        ViewEmployee.setForeground(Color.WHITE); // Set text color
        ViewEmployee.setBackground(Color.BLACK); // Set background color
        ViewEmployee.addActionListener(this); // Add ActionListener to handle button click
        img.add(ViewEmployee); // Add button to the image panel

        // Step 6: Adding "Remove Employee" button
        RemoveEmployee = new JButton("Remove Employee");
        RemoveEmployee.setBounds(440, 370, 150, 40); // Set position and size of button
        RemoveEmployee.setForeground(Color.WHITE); // Set text color
        RemoveEmployee.setBackground(Color.BLACK); // Set background color
        RemoveEmployee.addActionListener(this); // Add ActionListener to handle button click
        img.add(RemoveEmployee); // Add button to the image panel

        // Step 7: Adding "Log Out" button
        LogOut = new JButton("Log Out");
        LogOut.setBounds(870, 20, 150, 40); // Set position for the Log Out button
        LogOut.setFont(new Font("Serif", Font.PLAIN, 20)); // Set font style and size
        LogOut.setForeground(Color.WHITE); // Set button text color
        LogOut.setBackground(new Color(255, 56, 56)); // Set red background color for Log Out
        LogOut.setFocusPainted(false); // Remove focus border around the button
        LogOut.addActionListener(this); // Add ActionListener to handle button click
        img.add(LogOut); // Add Log Out button to the image panel

        // Step 8: Setting up the frame
        setSize(1120, 630); // Set the size of the window
        setLocation(250, 100); // Set the location of the window on the screen
        setLayout(null); // Set layout manager to null (absolute positioning)
        setVisible(true); // Make the window visible
    }

    // Step 9: Handling button clicks by overriding the actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) {
        // Step 10: Check which button was clicked and perform the corresponding action
        if (e.getSource() == AddEmployee) {
            // If "Add Employee" button is clicked, open the Add Employee page
            new AddEmployee();
            setVisible(false); // Hide the current Home page

        } else if (e.getSource() == ViewEmployee) {
            // If "View Employee" button is clicked, open the View Employee page
            new View_Employee();
            setVisible(false); // Hide the current Home page

        } else if (e.getSource() == LogOut) {
            // If "Log Out" button is clicked, log the user out and open the Login page
            new Login();
            setVisible(false); // Hide the current Home page
        } else{
            new Remove_Employee();
            setVisible(false);
        }
    }

    // Step 11: Main method to launch the Home page
    public static void main(String[] args) {
        new Home(); // Create an instance of the Home page (this opens the home window)
    }
}
