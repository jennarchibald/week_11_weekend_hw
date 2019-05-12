import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketTest {

    Passenger passenger;
    Flight flight;

    Ticket ticket;

    @Before
    public void before(){
        passenger = new Passenger("Jenn");
        flight = new Flight("FA1234", AirportCode.EDINBURGH);
        ticket = new Ticket(passenger, flight);
    }

    @Test
    public void hasPassenger(){
        assertEquals(passenger, ticket.getPassenger());
    }

    @Test
    public void hasFlight(){
        assertEquals(flight, ticket.getFlight());
    }
}
