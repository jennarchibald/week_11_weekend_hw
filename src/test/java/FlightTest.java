import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FlightTest {

    Plane plane;
    Flight flight;

    Passenger passenger;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747, Airline.FLYBE);
        flight = new Flight("FB2164", AirportCode.PARIS);
        passenger = new Passenger("Jenn");
    }

    @Test
    public void hasFlightNumber(){
        assertEquals("FB2164", flight.getFlightNumber());
    }

    @Test
    public void hasDestination(){
        assertEquals("CDG", flight.getDestination());
    }

    @Test
    public void hasDistance(){
        assertEquals(682.9, flight.getDistance(), 0.1);
    }

    @Test
    public void startsWithNoPlane(){
        assertNull(flight.getPlane());
    }

    @Test
    public void canAssignPlane(){
        flight.assignPlane(plane);
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void canBoardPassenger(){
        flight.assignPlane(plane);
        flight.boardPassenger(passenger);
        assertEquals(1, plane.passengerCount());
    }

    @Test
    public void canBeFull(){
        flight.assignPlane(plane);
        for (int i = 0; i < 100; i ++){
            flight.boardPassenger(passenger);
        }
        assertEquals(true, flight.isFull());
    }

}
