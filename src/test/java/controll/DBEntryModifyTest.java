package controll;

import model.Airplane;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.print.DocFlavor;


public class DBEntryModifyTest {

    @Mock
    private DBConnect dbConnect;

    @InjectMocks
    private DBEntryModify dbEntryModify;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveItemIntoDB() {

        int planeID = 1;
        String name = "Boeing 787-8";
        String iata = "788";
        String icao = "B788";

        dbEntryModify.query_Create_Airplane(new Airplane(planeID, name, iata, icao));
        Airplane airplane = dbEntryModify.query_Read_Airplane(1);

        Assert.assertEquals(planeID, airplane.getPlaneID());
        Assert.assertEquals(name, airplane.getName());
        Assert.assertEquals(iata, airplane.getIata());
        Assert.assertEquals(icao, airplane.getIcao());



    }

    @Test
    public void updateItemIntoDB() {

        int planeID = 1;
        String name = "Boeing 787-8";
        String iata = "788";
        String icao = "B788";

        dbEntryModify.query_Update_Airplane();
        Airplane airplane = dbEntryModify.query_Read_Airplane(1);

        Assert.assertEquals(planeID, airplane.getPlaneID());
        Assert.assertEquals(name, airplane.getName());
        Assert.assertEquals(iata, airplane.getIata());
        Assert.assertEquals(icao, airplane.getIcao());



    }
}