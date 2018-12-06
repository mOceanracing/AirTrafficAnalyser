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
    private String dbURL;
    private String dbUSER;
    private String dbPW;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

//    public static final Logger log = Logger.getLogger(DBConnect.class);

    public DBConnect(String dbURL, String dbUSER, String dbPW) {
        this.dbURL = dbURL;
        this.dbUSER = dbUSER;
        this.dbPW = dbPW;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, dbUSER, dbPW);
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }


    public ArrayList<String> getData(String tableName, String columnName, int searchID, ArrayList<String> columnNames) {
        ArrayList result = new ArrayList<String>();

        String query_SELECT = "SELECT *";
        String query_FROM = " FROM `" + tableName + "` ";
        String query_WHERE = " WHERE " + searchID;
        String query = query_SELECT + query_FROM + query_WHERE;

        try {
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                for (String column : columnNames) {
                    result.add(resultSet.getString(column));
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        } finally {
            return result;
        }
    }

    public boolean insertInto(String tableName, ArrayList<String> columnNames, ArrayList<String> values) {
        //   Z.b INSERT INTO Customer (FirstName, LastName, City, Country, Phone)
        //   Z.b VALUES ('Craig', 'Smith', 'New York', 'USA', 1-01-993 2800)
        int columnCounter = 0;
        int valuesCounter = 0;
        String query = "";
        String query_INSERT_INTO = "INSERT INTO " + tableName + " (";
        String query_VALUES = " VALUES (";

        for (String columnName : columnNames) {
            query_INSERT_INTO = query_INSERT_INTO + columnName;
            if (columnCounter != columnNames.size() - 1) {
                query_INSERT_INTO = query_INSERT_INTO + ",";
            }
            columnCounter++;
        }
        query_INSERT_INTO = query_INSERT_INTO + " )";

        for (String value : values) {
            query_VALUES = query_VALUES + "'" + value + "'";
            if (valuesCounter != values.size() - 1) {
                query_VALUES = query_VALUES + ",";
            }
            valuesCounter++;
        }
        query_VALUES = query_VALUES + ")";
        query = "" + query_INSERT_INTO + query_VALUES;
        try {
            connection.createStatement().execute(query);

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return false;
        }
        return false;
    }


    public void updateData(String tableName, ArrayList<String> columnNamesToUpdate, ArrayList<String> newValues, String idColumnName, int idColumnNameValue) {

        int coumnCounter = 0;
        String query = "";
        String query_UPDATE = "UPDATE " + tableName + " (";
        String query_SET = "SET ";
        String query_WHERE = "WHERE " + idColumnName + " " + idColumnNameValue;


        for (String column : columnNamesToUpdate) {
            query_SET = query_SET + column + " `" + newValues.get(coumnCounter) + "`";
            coumnCounter++;
        }
        query = query_SET + query_UPDATE + query_WHERE;

        try {
            connection.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String tableName, ArrayList<String> columnNames, ArrayList<String> values) {
        String query = "";
        String query_UPDATE = "UPDATE " + tableName + " (";
        String query_SET = "INSERT INTO " + tableName + " (";
        String query_WHERE = " VALUES (";
    }


}
