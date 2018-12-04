package controll;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by marck on 03.12.2018.
 */
public class DBConnect {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public static final Logger log = Logger.getLogger(DBConnect.class);

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            statement = connection.createStatement();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
//        log.info("Connect with DB Successfully");
    }

    public ArrayList<String> getData(String tableName, String columnName) {
        ArrayList result = new ArrayList<String>();
        try {
            String query = "select * from " + tableName;

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(columnName);
                result.add(resultSet.getString(columnName));
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        } finally {
            return result;
        }
    }

    public boolean insertData(String tableName, ArrayList<String> columnNames, ArrayList<String> values) {
        try {
            //   Z.b INSERT INTO Customer (FirstName, LastName, City, Country, Phone)
            //   Z.b VALUES ('Craig', 'Smith', 'New York', 'USA', 1-01-993 2800)
            String query = "";
            String query_INSERT_INTO = "INSERT INTO " + tableName + " (";
            String query_VALUES = "VALUES (";

            for (String columnName : columnNames) {
                query_INSERT_INTO = query_INSERT_INTO + columnName + ",";
            }
            query_INSERT_INTO = query_INSERT_INTO + ")";


            for (String value : values) {
                query_VALUES = query_VALUES + value;

            }
            query_VALUES = query_VALUES + ")";

            query = "" + query_INSERT_INTO.toString() + "/n " + query_VALUES;

            connection.prepareStatement(query_INSERT_INTO);
            resultSet = statement.executeQuery(query_VALUES);

            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
            while (resultSet.next()) {

                System.out.println(query_INSERT_INTO);
                resultSet.getString(query_INSERT_INTO);

                System.out.println(query_VALUES);
                resultSet.getString(query_VALUES);

                return true;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return false;
        }
        return false;
    }


}
