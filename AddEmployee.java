package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    // Declare global text fields and components
    JTextField Emp_name, Emp_Last_name, Emp_address, Emp_phone, Emp_email, Emp_salary, Emp_designation;
    JLabel Emp_id;
    JDateChooser Emp_dob;
    JComboBox<String> Emp_education;
    JButton add, back;

    public AddEmployee() {
        // Generate a random employee ID for new entries
        Random ran = new Random();
        int number = ran.nextInt(999999);

        // Set the background color of the frame
        getContentPane().setBackground(new Color(210, 255, 255));

        // Add the heading label
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 25));
        heading.setForeground(new Color(85, 89, 118));
        add(heading);

        // Add fields and labels for employee details
        createLabelAndField("First Name", 50, 150, Emp_name = new JTextField(), 200, 150);
        createLabelAndField("Last Name", 500, 150, Emp_Last_name = new JTextField(), 650, 150);
        createLabelAndField("Salary", 500, 250, Emp_salary = new JTextField(), 650, 250);
        createLabelAndField("Address", 50, 350, Emp_address = new JTextField(), 200, 350);
        createLabelAndField("Contact No.", 500, 350, Emp_phone = new JTextField(), 650, 350);
        createLabelAndField("E-mail", 50, 450, Emp_email = new JTextField(), 200, 450);
        createLabelAndField("Designation", 500, 450, Emp_designation = new JTextField(), 650, 450);

        // Date of birth field with date picker
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 250, 150, 30);
        dob.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(dob);
        Emp_dob = new JDateChooser();
        Emp_dob.setBounds(200, 250, 150, 30);
        Emp_dob.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(Emp_dob);

        // Education dropdown list
        JLabel education = new JLabel("Higher Education");
        education.setBounds(50, 550, 200, 30);
        education.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(education);
        String[] items = {" ", "BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD", "Others"};
        Emp_education = new JComboBox<>(items);
        Emp_education.setBounds(250, 550, 200, 30);
        Emp_education.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(Emp_education);

        // Employee ID label
        JLabel emp_id = new JLabel("Employee Id");
        emp_id.setBounds(500, 550, 150, 30);
        emp_id.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(emp_id);
        Emp_id = new JLabel(String.valueOf(number));
        Emp_id.setBounds(650, 550, 150, 30);
        Emp_id.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Emp_id.setForeground(new Color(255, 56, 56));
        add(Emp_id);

        // Add and Back buttons with enhanced styling
        add = new JButton("Add");
        add.setBounds(250, 650, 150, 30);
        add.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        add.setBackground(new Color(0, 123, 255));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(550, 650, 150, 30);
        back.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        back.setBackground(new Color(255, 87, 34));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Set the frame properties
        setSize(900, 750);
        setLocation(380, 20);
        setLayout(null);
        setVisible(true);
    }

    // Helper function to create labels and text fields
    private void createLabelAndField(String labelText, int labelX, int labelY, JTextField textField, int fieldX, int fieldY) {
        JLabel label = new JLabel(labelText);
        label.setBounds(labelX, labelY, 150, 30);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(label);
        textField.setBounds(fieldX, fieldY, 150, 30);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(textField);
    }

    // Validation functions for user inputs (checks for empty fields and formats)
    private void validateName(String name, String fieldName) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the " + fieldName);
        } else if (!name.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, fieldName + " must contain only letters");
        }
    }

    private void validatePhoneNumber(String phone) {
        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the Phone Number");
        } else if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone number must be 10 digits");
        }
    }

    private void validateEmail(String email) {
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the Email");
        } else if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Email Format");
        }
    }

    private void validateSalary(String salary) {
        if (salary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the Salary");
        } else if (!salary.matches("\\d+(\\.\\d{1,2})?")) {
            JOptionPane.showMessageDialog(this, "Enter a valid salary amount");
        }
    }

    private void validateDOB(String dob) {
        if (dob.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the Date of Birth");
        }
    }

    private void validateDesignation(String designation) {
        if (designation.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the Designation");
        }
    }

    private void validateEducation(String education) {
        if (education.equals(" ")) {
            JOptionPane.showMessageDialog(this, "Select the Education");
        }
    }

    // Action performed when the Add or Back button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        String Employee_Name = Emp_name.getText();
        String Employee_Last_name = Emp_Last_name.getText();
        String Employee_Salary = Emp_salary.getText();
        String Employee_Address = Emp_address.getText();
        String Employee_Phone = Emp_phone.getText();
        String Employee_Email = Emp_email.getText();
        String Employee_Designation = Emp_designation.getText();
        String Employee_Date_Of_Birth = ((JTextField) Emp_dob.getDateEditor().getUiComponent()).getText();
        String Employee_Education = (String) Emp_education.getSelectedItem();
        String Employee_Id = Emp_id.getText();

        // Validate user inputs
        if (e.getSource() == add) {
            validateName(Employee_Name, "First Name");
            validateName(Employee_Last_name, "Last Name");
            validateDOB(Employee_Date_Of_Birth);
            validateSalary(Employee_Salary);
            validatePhoneNumber(Employee_Phone);
            validateEmail(Employee_Email);
            validateDesignation(Employee_Designation);
            validateEducation(Employee_Education);

            try {
                // Insert data into database
                conn connection = new conn();
                String query = "INSERT INTO EmployeeTable(emp_id, emp_first_name, emp_last_name, emp_date_of_birth, emp_contact_no, emp_email, emp_salary, emp_address, emp_designation, emp_education) " +
                        "VALUES ('" + Employee_Id + "', '" + Employee_Name + "', '" + Employee_Last_name + "', '" + Employee_Date_Of_Birth + "', '" + Employee_Phone + "', '" + Employee_Email + "', '" + Employee_Salary + "', '" + Employee_Address + "', '" + Employee_Designation + "', '" + Employee_Education + "')";
                connection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "The data has been successfully added");

                // Clear the form fields after insertion
                clearForm();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (e.getSource() == back) {
            new Home();
            setVisible(false);
        }
    }

    // Function to clear all the form fields after adding data
    private void clearForm() {
        Emp_name.setText("");
        Emp_Last_name.setText("");
        Emp_address.setText("");
        Emp_phone.setText("");
        Emp_email.setText("");
        Emp_salary.setText("");
        Emp_designation.setText("");
        Emp_dob.setDate(null);
        Emp_education.setSelectedIndex(0);  // Reset combo box to default
        Random ran = new Random();
        int number = ran.nextInt(999999);  // Generate a new random employee ID for next entry
        Emp_id.setText(String.valueOf(number));
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
