package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.*;

/**
 * Step 2 Extends with JFrame**/
public class SignUp extends JFrame implements ActionListener {
    JTextField tuserName,tPhoneNumber,tEmail;
    JPasswordField tPassword;
    JPasswordField confirmPassword;
    JButton register,back;

    SignUp(){

        JLabel title = new JLabel("SIGN-UP");
        title.setBounds(260,50,400,60);
        title.setFont(new Font("Serif",Font.BOLD,60));
        title.setForeground(Color.BLACK);
        add(title);

        ImageIcon titleImage1 = new ImageIcon(ClassLoader.getSystemResource("Icons/SignUpImage.png"));
        Image titleImage2 = titleImage1.getImage().getScaledInstance(350,170,Image.SCALE_DEFAULT);
        ImageIcon titleImage3 = new ImageIcon(titleImage2);
        JLabel titleImage = new JLabel(titleImage3);
        titleImage.setBounds(30,5,350,170);
        add(titleImage);
        /**
         * Step 5
         * Making JLabel for UserName
         * Setting Bounds to the UserName using SetBounds(x,y,width,height)
         * Setting the Font size using the SetFont(new Font(name,FONT.PLAIN,Size)).
         * Adding UserName on the Frame.**/
        JLabel username = new JLabel("Enter The UserName:");
        username.setBounds(100, 180, 210, 30);
        username.setFont(new Font("SansSerif",Font.BOLD,20));
        add(username);


        /**
         * Step 12
         * Adding the TextField with JTextField
         * Setting the SetBounds*/
        tuserName = new JTextField();
        tuserName.setBounds(400,180,230,30);
        tuserName.setFont(new Font("Serif",Font.PLAIN,20));
        add(tuserName);

        /**
         * Step 7
         * Making JLabel for Password
         * Setting Bounds to the Password using SetBounds(x,y,width,height)
         * Setting the Font size using the SetFont(new Font(name,FONT.PLAIN,Size)).
         * Adding Password on the Frame.**/
        JLabel password = new JLabel("Enter The Password:");
        password.setBounds(100, 280, 210, 30);
        password.setFont(new Font("SansSerif",Font.BOLD,20));
        add(password);

        /**
         * Step 13
         * Adding the Password with JPasswordField().
         * Setting the SetBounds*/
        tPassword = new JPasswordField();
        tPassword.setBounds(400,280,230,30);
        tPassword.setFont(new Font("SansSerif",Font.BOLD,20));
        add(tPassword);

        /**
         * Step 8
         * Making JLabel for Confirm Password
         * Setting Bounds to the Confirm Password using SetBounds(x,y,width,height)
         * Setting the Font size using the SetFont(new Font(name,FONT.PLAIN,Size)).
         * Adding Confirm Password on the Frame.**/
        JLabel c_password = new JLabel("Confirm The Password:");
        c_password.setBounds(100, 380, 230, 30);
        c_password.setFont(new Font("SansSerif",Font.BOLD,20));
        add(c_password);

        /**
         * Step 14
         * Adding the Confirm Password with JPasswordField().
         * Setting the SetBounds*/
        confirmPassword = new JPasswordField();
        confirmPassword.setBounds(400,380,230,30);
        confirmPassword.setFont(new Font("SansSerif",Font.BOLD,20));
        add(confirmPassword);
        /**
         * Step 9
         * Making JLabel for Mobile Number
         * Setting Bounds to the mobile number using SetBounds(x,y,width,height)
         * Setting the Font size using the SetFont(new Font(name,FONT.PLAIN,Size)).
         * Adding mobile number on the Frame.**/
        JLabel mob_number = new JLabel("Enter The Phone No.:");
        mob_number.setBounds(100, 480, 210, 30);
        mob_number.setFont(new Font("SansSerif",Font.BOLD,20));
        add(mob_number);

        /**
         * Step 15
         * Adding the Phone Number with JTextField().
         * Setting the SetBounds*/
        tPhoneNumber = new JTextField();
        tPhoneNumber.setBounds(400,480,230,30);
        tPhoneNumber.setFont(new Font("SansSerif",Font.BOLD,20));
        add(tPhoneNumber);

        /**
         * Step 10
         * Making JLabel for email
         * Setting Bounds to the email using SetBounds(x,y,width,height)
         * Setting the Font size using the SetFont(new Font(name,FONT.PLAIN,Size)).
         * Adding email on the Frame.**/
        JLabel email = new JLabel("Enter The Mail:");
        email.setBounds(100, 580, 210, 30);
        email.setFont(new Font("SansSerif",Font.BOLD,20));
        add(email);


        /**
         * Step 16
         * Adding the Email with JTextField().
         * Setting the SetBounds*/
        tEmail = new JTextField();
        tEmail.setBounds(400,580,230,30);
        tEmail.setFont(new Font("SansSerif",Font.BOLD,20));
        add(tEmail);
        /**
         * step 11
         * Adding the Register button
         * Assigning Register as setBounds(x,y,height,width).
         * Setting Background color to Black. using setBackground(Color.BLACK).
         * Changing the text Color to White . Using setForeground(Color.WHITE).**/
        register = new JButton("REGISTER");
        register.setBounds(250,670,100,40);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);

        /**
         * step 12
         * Adding the Back button
         * Assigning Back as setBounds(x,y,height,width).
         * Setting Background color to Black. using setBackground(Color.BLUE).
         * Changing the text Color to White . Using setForeground(Color.WHITE).**/
        back = new JButton("BACK");
        back.setBounds(450,670,100,40);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        /**
         * Step 6
         * Adding the Background to the SignUp Page.
         * Creating ImageIcon i1 interface that takes Image from System using ClassLoader.
         * Crating Image i2 passing to i1.
         * Here, We get Scaled Image.
         * Then Creating ImageIcon i3 setting inside i2
         * Using JLabel adding the Background to the SignUp Frame.
         **/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/SignUpBackground.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        /**
         * Step 3
         * Setting the all Basic things*/
        setSize(800,800);
        setLocation(350,20);
        setLayout(null);
        setVisible(true);

    }

    /**
     * Checking the Regular Expression for Username */
    public void userNameRegex(String userName) {
        // First check if the input is empty
        if (userName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the UserName");
        } else {
            // Then validate the input format
            Pattern user_Pattern = Pattern.compile("[a-z]*\\s+[a-z]*"); // Escape the \ for regex
            Matcher user_Match = user_Pattern.matcher(userName);
            boolean user_Name_Match = user_Match.matches();

            // Only if the format is incorrect, show the error message
            if (!user_Name_Match) {
                JOptionPane.showMessageDialog(this, "Enter the Full Name in Smaller Case");
            }
        }
    }

    /**
     * Checking the Regular Expression for enteredPassword */
    public void enterPassword(String user_password){
        if(user_password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter the Password");
        }else{
            Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@!#%&*']).{8,}$");
            Matcher matcher = pattern.matcher(user_password);
            boolean matches = matcher.matches();
            if(!matches){
                JOptionPane.showMessageDialog(this, "Password must contain at least one lowercase letter, one uppercase letter, one digit, one special character, and be at least 8 characters long.");
            }
        }
    }

    /**
     * Checking the Regular Expression for UserPhoneNumber */
    public void userPhoneNumber(String user_phoneNumber){
        if(user_phoneNumber.isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter the Password");
        }else{
            Pattern pattern = Pattern.compile("\\d{1,10}");
            Matcher matcher = pattern.matcher(user_phoneNumber);
            boolean matches = matcher.matches();
            if(!matches){
                JOptionPane.showMessageDialog(this, "Enter the phone number");
            }
        }
    }


    public void eamilValidation(String user_email){
        if(user_email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter the Email");
        }else{
            Pattern pattern = Pattern.compile("^([a-z0-9_.-]+)@([\\da-z.-]+)\\.([a-z.]{2,6})$");
            Matcher matcher = pattern.matcher(user_email);
            boolean matches = matcher.matches();
            if(!matches){
                JOptionPane.showMessageDialog(this, "check the email");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register){
            String string_userName = tuserName.getText();
            String string_Password = new String(tPassword.getPassword());
            String string_Confirm_Password = new String(confirmPassword.getPassword());
            String string_Phone_Number = tPhoneNumber.getText();
            String string_Email = tEmail.getText();

            userNameRegex(string_userName.trim());
            enterPassword(string_Password.trim());
            if(!string_Confirm_Password.trim().equals(string_Password.trim())){
                JOptionPane.showMessageDialog(this, "check input password is not correct");
            }

            userPhoneNumber(string_Phone_Number);
            eamilValidation(string_Email.trim());

            try {
                conn conn = new conn();
                String query = "INSERT INTO Admin (userName, userPassword,contact_no,email) " +
                        "VALUES ('" + string_userName + "', '" + string_Password + "', '" +  string_Phone_Number + "', '" + string_Email + "')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this,"The data executed successfully");
                new Login();
                setVisible(false);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else if(e.getSource() == back){
            new Login();
            setVisible(false);
        }
    }

    public static void main(String[] args){
        /**
         * Step 1
         * Creating the Object of Constructor SignUp */
        new SignUp();
    }
}
