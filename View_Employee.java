package employee.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {
    Choice choiceEmp;
    JTable table;
    JButton searchEmp, print, update, back;

    View_Employee() {
        // Set main frame properties and background color
        getContentPane().setBackground(new Color(245, 245, 250));
        setLayout(null);

        // Heading label with a modern font style
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(300, 10, 500, 40);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 30));
        heading.setForeground(new Color(54, 84, 123));
        add(heading);

        // Search Label
        JLabel search = new JLabel("Search Employee By ID:");
        search.setBounds(20, 60, 215, 30);
        search.setFont(new Font("Segoe UI", Font.BOLD, 18));
        search.setForeground(new Color(84, 105, 141));
        add(search);

        // Choice dropdown for selecting employee ID
        choiceEmp = new Choice();
        choiceEmp.setBounds(250, 65, 150, 25);
        choiceEmp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(choiceEmp);

        // Fill the choice dropdown with employee IDs from the database
        try {
            conn connection = new conn();
            ResultSet result = connection.statement.executeQuery("SELECT emp_id FROM EmployeeTable");
            while (result.next()) {
                choiceEmp.add(result.getString("emp_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize table to display employee data
        table = new JTable();

        // Display all employees by default
        try {
            conn connection = new conn();
            ResultSet result = connection.statement.executeQuery("SELECT * FROM EmployeeTable");
            table.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Scroll pane to make table scrollable
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(20, 150, 860, 450);
        jScrollPane.setBorder(BorderFactory.createLineBorder(new Color(84, 105, 141), 2));
        add(jScrollPane);

        // Search button
        searchEmp = new JButton("Search");
        searchEmp.setBounds(420, 65, 100, 25);
        searchEmp.setBackground(new Color(84, 105, 141));
        searchEmp.setForeground(Color.WHITE);
        searchEmp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        searchEmp.addActionListener(this);
        add(searchEmp);

        // Print button
        print = new JButton("Print");
        print.setBounds(530, 65, 100, 25);
        print.setBackground(new Color(0, 166, 90));
        print.setForeground(Color.WHITE);
        print.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        print.addActionListener(this);
        add(print);

        // Update button
        update = new JButton("Update");
        update.setBounds(640, 65, 100, 25);
        update.setBackground(new Color(84, 105, 141));
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        update.addActionListener(this);
        add(update);

        // Back button
        back = new JButton("Back");
        back.setBounds(750, 65, 100, 25);
        back.setBackground(new Color(235, 87, 87));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);

        setSize(920, 650);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchEmp) {
            // Search and display selected employee by ID
            String query = "SELECT * FROM EmployeeTable WHERE emp_id = '" + choiceEmp.getSelectedItem() + "'";
            try {
                conn connection = new conn();
                ResultSet result = connection.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(result));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == print) {
            // Print table data
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == update) {
            // Open Update_Employee form
            setVisible(false);
            new Update_Employee(choiceEmp.getSelectedItem());
        } else if (e.getSource() == back) {
            // Return to home screen
            new Home();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
