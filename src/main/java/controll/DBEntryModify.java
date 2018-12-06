package controll;

import model.Airplane;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by marck on 04.12.2018.
 */
public class DBEntryModify {
    private static final Logger logger = Logger.getLogger(DBEntryModify.class.getName());

    private static DBConnect dbConnect;
    private ArrayList<String> columnNames = new ArrayList<String>();
    private String airplaneTableName = "planes";
    private String airlineTableName = "airlines";
    private String airportTableName = "airports";
    private String routeTableName = "route";


    public DBEntryModify() {
        dbConnect = new DBConnect("jdbc:mysql://localhost:3306/airtraficanalyserdb_01", "root", "");

        columnNames.add("planeID");
        columnNames.add("name");
        columnNames.add("iata");
        columnNames.add("icao");
    }


    ///////////////////////////////////////////////////////////////////
    ///////                CRUD AIRPLANES                       ///////
    ///////////////////////////////////////////////////////////////////


    public void query_Create_Airplane(Airplane airplane) {
        ArrayList<String> values = new ArrayList<String>();

        values.add("" + airplane.getPlaneID());
        values.add(airplane.getName());
        values.add(airplane.getIata());
        values.add(airplane.getIcao());

        dbConnect.insertInto(airplaneTableName, columnNames, values);
    }

    public Airplane query_Read_Airplane(int airplaneID) {
        ArrayList<String> dbResponse = dbConnect.getData(airplaneTableName, "planeID", 1, columnNames);
        return new Airplane(airplaneID, dbResponse.get(1), dbResponse.get(2), dbResponse.get(3));
    }

    public void query_Update_Airplane(Airplane oldAirplane, Airplane newAirplane) {
        ArrayList<String> columnNamesToUpdate = new ArrayList<String>();
        ArrayList<String> newValues = new ArrayList<String>();

        if (!oldAirplane.getName().equals(newAirplane.getName())) {
            columnNamesToUpdate.add("name");
            newValues.add(newAirplane.getName());
        }

        if (!oldAirplane.getIata().equals(newAirplane.getIata())) {
            columnNamesToUpdate.add("iata");
            newValues.add(newAirplane.getIata());
        }

        if (!oldAirplane.getIcao().equals(newAirplane.getIcao())) {
            columnNamesToUpdate.add("icao");
            newValues.add(newAirplane.getIcao());
        }
        dbConnect.updateData(airplaneTableName, , "planeID", oldAirplane.getPlaneID());
    }

    public void query_Delete_Airplane(int airplaneID) {

    }
}
