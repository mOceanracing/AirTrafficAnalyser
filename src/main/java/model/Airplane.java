package model;

/**
 * Created by marck on 03.12.2018.
 */
public class Airplane {
    private int planeID;
    private String name;
    private String iata;
    private String icao;


    public Airplane(int planeID) {
        this.planeID = planeID;
    }

    public Airplane(int planeID, String name, String iata, String icao) {
        this.planeID = planeID;
        this.name = name;
        this.iata = iata;
        this.icao = icao;
    }

    public int getPlaneID() {
        return planeID;
    }

    public String getName() {
        return name;
    }

    public String getIata() {
        return iata;
    }

    public String getIcao() {
        return icao;
    }
}
