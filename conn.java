package employee.management.system;

import java.sql.*;

public class conn {
    // Step 1: Declare variables for database connection and statement
    Connection connection;  // Used to establish the connection to the database
    Statement statement;     // Used to execute SQL queries

    // Constructor to initialize the connection
    public conn(){
        try{
            // Step 2: Register the JDBC driver
            // Class.forName() loads the JDBC driver class into memory.
            // This is required for the program to communicate with the database.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Establish the connection to the database
            // DriverManager.getConnection() connects to the database using the given URL, username, and password.
            // In this case, we're connecting to a MySQL database named "EmployeeManagementSystem" on the local machine.
            // The database username is "root" and the password is "V@r@d12347".
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem", "root", "V@r@d12347");

            // Step 4: Create a Statement object to send SQL queries to the database
            // The statement object allows us to execute SQL queries, update database records, etc.
            statement = connection.createStatement();

        }catch (Exception e){
            // Step 5: Handle exceptions (if any occur while loading the driver or connecting to the database)
            // If there's an issue with the connection or the SQL driver, the exception is caught here and printed to the console.
            e.printStackTrace();
        }
    }
}
