package employee.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Employee extends JFrame implements ActionListener {
    JTextField Emp_education, Emp_Last_name, Emp_address, Emp_phone, Emp_email, Emp_salary, Emp_designation;
    JLabel Emp_id;
    JButton update, back;
    String number_id;

    Update_Employee(String number_id) {
        this.number_id = number_id;

        // Set the background and main frame properties
        getContentPane().setBackground(new Color(234, 242, 248));
        setLayout(null);

        // Add a title with new style
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(300, 30, 600, 50);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 30));
        heading.setForeground(new Color(50, 50, 102));
        add(heading);

        // Add icon to the title
        ImageIcon icon = new ImageIcon("icon.png");
        heading.setIcon(icon);

        // Panel styling for organized sections
        JPanel panel = new JPanel();
        panel.setBounds(30, 100, 840, 480);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 102), 2));
        panel.setLayout(null);
        add(panel);

        // Initialize fields with labels, improved fonts, and consistent styling
        JLabel name = new JLabel("First Name");
        name.setBounds(50, 30, 150, 30);
        name.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(name);

        JLabel Emp_name = new JLabel();
        Emp_name.setBounds(200, 30, 150, 30);
        Emp_name.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panel.add(Emp_name);

        JLabel last_name = new JLabel("Last Name");
        last_name.setBounds(450, 30, 150, 30);
        last_name.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(last_name);

        Emp_Last_name = new JTextField();
        Emp_Last_name.setBounds(600, 30, 180, 30);
        Emp_Last_name.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panel.add(Emp_Last_name);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 90, 150, 30);
        dob.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(dob);

        JLabel Emp_dob = new JLabel();
        Emp_dob.setBounds(200, 90, 150, 30);
        Emp_dob.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panel.add(Emp_dob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(450, 90, 150, 30);
        salary.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(salary);

        Emp_salary = new JTextField();
        Emp_salary.setBounds(600, 90, 180, 30);
        Emp_salary.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panel.add(Emp_salary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 150, 150, 30);
        address.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(address);

        Emp_address = new JTextField();
        Emp_address.setBounds(200, 150, 200, 30);
        Emp_address.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panel.add(Emp_address);

        JLabel phone = new JLabel("Contact No.");
        phone.setBounds(450, 150, 150, 30);
        phone.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(phone);

        Emp_phone = new JTextField();
        Emp_phone.setBounds(600, 150, 180, 30);
        Emp_phone.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panel.add(Emp_phone);

        JLabel email = new JLabel("E-mail");
        email.setBounds(50, 210, 150, 30);
        email.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(email);

        Emp_email = new JTextField();
        Emp_email.setBounds(200, 210, 200, 30);
        Emp_email.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panel.add(Emp_email);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(450, 210, 150, 30);
        designation.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(designation);

        Emp_designation = new JTextField();
        Emp_designation.setBounds(600, 210, 180, 30);
        Emp_designation.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panel.add(Emp_designation);

        JLabel education = new JLabel("Higher Education");
        education.setBounds(50, 270, 180, 30);
        education.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(education);

        Emp_education = new JTextField();
        Emp_education.setBounds(200, 270, 200, 30);
        Emp_education.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panel.add(Emp_education);

        JLabel emp_id = new JLabel("Employee ID");
        emp_id.setBounds(450, 270, 150, 30);
        emp_id.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(emp_id);

        Emp_id = new JLabel();
        Emp_id.setBounds(600, 270, 150, 30);
        Emp_id.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Emp_id.setForeground(Color.RED);
        panel.add(Emp_id);

        // Fetch and populate employee data from the database
        try {
            conn c = new conn();
            String query = "select * from EmployeeTable where emp_id = '" + number_id + "'";
            ResultSet result = c.statement.executeQuery(query);
            while (result.next()) {
                Emp_id.setText(result.getString("emp_id"));
                Emp_name.setText(result.getString("emp_first_name"));
                Emp_Last_name.setText(result.getString("emp_last_name"));
                Emp_dob.setText(result.getString("emp_date_of_birth"));
                Emp_phone.setText(result.getString("emp_contact_no"));
                Emp_email.setText(result.getString("emp_email"));
                Emp_salary.setText(result.getString("emp_salary"));
                Emp_address.setText(result.getString("emp_address"));
                Emp_designation.setText(result.getString("emp_designation"));
                Emp_education.setText(result.getString("emp_education"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Buttons with improved styling
        update = new JButton("Update");
        update.setBounds(200, 650, 150, 40);
        update.setFont(new Font("Segoe UI", Font.BOLD, 18));
        update.setBackground(new Color(72, 151, 208));
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(550, 650, 150, 40);
        back.setFont(new Font("Segoe UI", Font.BOLD, 18));
        back.setBackground(new Color(72, 151, 208));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 750);
        setLocation(380, 20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
            String emp_last_name = Emp_Last_name.getText();
            String emp_salary = Emp_salary.getText();
            String emp_address = Emp_address.getText();
            String emp_phone = Emp_phone.getText();
            String emp_mail = Emp_email.getText();
            String emp_designation = Emp_designation.getText();
            String emp_education = Emp_education.getText();

            try{
                conn connection = new conn();
                String query = "update EmployeeTable set emp_last_name = '"+emp_last_name+"',emp_salary = '"+emp_salary+"', emp_address = '"+emp_address+"', emp_contact_no = '"+emp_phone+"',emp_email = '"+emp_mail+"',emp_designation = '"+emp_designation+"', emp_education = '"+emp_education+"' where emp_id = '"+number_id+"'";
                connection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Employee details updated successfully.");
                setVisible(false);
                new Home();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new Update_Employee("1"); // Replace "1" with a test employee ID
    }
}
