import controll.DBConnect;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marc100 on 02.12.2018.
 * https://openflights.org/data.html
 */
public class Main {
    public static final Logger log = Logger.getLogger(DBConnect.class);

    public static void main(String[] args) {
        DBConnect dbConnect = new DBConnect();

        String tableName = "planes";
        ArrayList<String> columnNames = new ArrayList<String>();
        ArrayList<String> values = new ArrayList<String>();

        columnNames.add("name");
        columnNames.add("iata");
        columnNames.add("icao");

        values.add("`Boeing 787-8`,");
        values.add("`787`,");
        values.add("`B788`,");

        dbConnect.insertData(tableName, columnNames, values);
        //dbConnect.getData();
        System.out.println("adsfsd");
    }
}
