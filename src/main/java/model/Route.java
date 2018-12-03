package model;

/**
 * Created by marck on 03.12.2018.
 */
public class Route {
    Airline airline;
    int airlineID;
    Airport sourceAirport;
    int sourceAirportID;
    Airport destinationAirport;
    int destinationAirportID;
    boolean codeshare;
    int stops;
    String planeName;
}
