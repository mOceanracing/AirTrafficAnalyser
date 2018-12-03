package controll;

import java.sql.*;

/**
 * Created by marck on 03.12.2018.
 */
public class DBConnect {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            statement = connection.createStatement();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void getData() {
        try {

            String query = "select * from persons";
            resultSet = statement.executeQuery(query);

            System.out.println("Records from Database:");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");

                System.out.println("Name: " + name + "    " + "Age: " + age);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }


}
