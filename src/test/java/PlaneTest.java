import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PlaneTest {

    Passenger passenger;
    Plane plane;

    @Before
    public void before(){
        passenger = new Passenger("Jenn");
        plane = new Plane( PlaneType.AIRBUSA320, Airline.BRITISHAIRWAYS);
    }

    @Test
    public void hasType(){
        assertEquals(PlaneType.AIRBUSA320, plane.getType());
    }

    @Test
    public void hasAirline(){
        assertEquals(Airline.BRITISHAIRWAYS, plane.getAirline());
    }

    @Test
    public void canAddPassenger(){
        plane.addPassenger(passenger);
        assertEquals(1, plane.passengerCount());
    }

    @Test
    public void canFindPassenger(){
        for (int i = 1; i < 10; i ++){
            plane.addPassenger(passenger);
        }
        Passenger pat = new Passenger("Pat");
        plane.addPassenger(pat);
        assertEquals(pat, plane.findPassenger(pat));
    }

    @Test
    public void returnsNullIfNoMatchingPassenger(){
        for (int i = 1; i < 10; i ++){
            plane.addPassenger(passenger);
        }
        Passenger bob = new Passenger("Bob");
        assertNull(plane.findPassenger(bob));
    }

    @Test
    public void canBeFull(){
        for (int i = 1; i < 300; i ++){
            plane.addPassenger(passenger);
        }
        assertEquals(true , plane.isFull());
    }

    @Test
    public void hasFlightRange(){
        assertEquals(6150, plane.getFlightRange());
    }

}
