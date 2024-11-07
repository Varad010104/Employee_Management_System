package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Remove_Employee extends JFrame implements ActionListener {

    // Step 1: Declare global UI components
    Choice choice_Emp_ID;
    JButton delete, back;
    JLabel text_name, text_phone, text_email;

    // Step 2: Constructor to set up the Remove Employee UI
    public Remove_Employee() {

        // Set the frame title and background color
        setTitle("Remove Employee");
        getContentPane().setBackground(new Color(230, 230, 250)); // Light lavender background

        // Step 3: Create and position "Employee ID" label
        JLabel label = new JLabel("Employee ID:");
        label.setBounds(50, 50, 130, 30);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(label);

        // Step 4: Create choice dropdown for Employee IDs
        choice_Emp_ID = new Choice();
        choice_Emp_ID.setBounds(200, 50, 150, 30);
        add(choice_Emp_ID);

        // Step 5: Fetch Employee IDs from the database and populate the choice dropdown
        try {
            conn connection = new conn();
            ResultSet resultSet = connection.statement.executeQuery("select * from EmployeeTable");
            while (resultSet.next()) {
                choice_Emp_ID.add(resultSet.getString("emp_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Step 6: Create labels for Employee information fields
        JLabel Emp_name = new JLabel("Name:");
        Emp_name.setBounds(50, 100, 100, 30);
        Emp_name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(Emp_name);

        text_name = new JLabel();  // Placeholder for employee name
        text_name.setBounds(200, 100, 200, 30);
        text_name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        text_name.setForeground(Color.BLUE);
        add(text_name);

        JLabel Emp_phone = new JLabel("Phone:");
        Emp_phone.setBounds(50, 150, 100, 30);
        Emp_phone.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(Emp_phone);

        text_phone = new JLabel();  // Placeholder for employee phone number
        text_phone.setBounds(200, 150, 200, 30);
        text_phone.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        text_phone.setForeground(Color.BLUE);
        add(text_phone);

        JLabel Emp_email = new JLabel("Email:");
        Emp_email.setBounds(50, 200, 100, 30);
        Emp_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(Emp_email);

        text_email = new JLabel();  // Placeholder for employee email
        text_email.setBounds(200, 200, 300, 30);
        text_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        text_email.setForeground(Color.BLUE);
        add(text_email);

        // Step 7: Fetch and display the first employee's information by default
        updateEmployeeDetails();

        // Step 8: Add an ItemListener to update the employee details when a different ID is selected
        choice_Emp_ID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateEmployeeDetails();
            }
        });

        // Step 9: Create the "Delete" button
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 120, 40);
        delete.setBackground(new Color(255, 69, 0)); // Orange-red color
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Tahoma", Font.BOLD, 15));
        delete.addActionListener(this);
        add(delete);

        // Step 10: Create the "Back" button
        back = new JButton("Back");
        back.setBounds(220, 300, 120, 40);
        back.setBackground(new Color(100, 149, 237)); // Cornflower blue color
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);

        // Step 11: Configure frame settings
        setSize(600, 450);
        setLayout(null);
        setLocation(300, 150);
        setVisible(true);
    }

    // Step 12: Method to update employee details in the labels based on the selected ID
    private void updateEmployeeDetails() {
        try {
            conn connection = new conn();
            ResultSet result = connection.statement.executeQuery(
                    "select * from EmployeeTable where emp_id = '" + choice_Emp_ID.getSelectedItem() + "'");

            // Update the labels with the employee's details
            if (result.next()) {
                text_name.setText(result.getString("emp_first_name"));
                text_phone.setText(result.getString("emp_contact_no"));
                text_email.setText(result.getString("emp_email"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Step 13: Handle button clicks for "Delete" and "Back" actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            // Step 14: Perform deletion of the selected employee from the database
            try {
                conn connection = new conn();
                String query = "delete from EmployeeTable where emp_id = '" + choice_Emp_ID.getSelectedItem() + "'";
                connection.statement.executeUpdate(query);

                // Show confirmation message
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
                setVisible(false); // Close current window
                new Home(); // Open Home page
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            // Step 15: Navigate back to the Home page
            setVisible(false);
            new Home();
        }
    }

    // Step 16: Main method to run the Remove Employee page
    public static void main(String[] args) {
        new Remove_Employee();
    }
}
