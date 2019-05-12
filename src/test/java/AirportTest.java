import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AirportTest {

    Plane plane;
    Plane plane1;
    Plane plane2;
    Plane plane3;

    Airport edinburghAirport;

    Flight flight;
    Flight flight1;

    Passenger passenger;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747, Airline.BRITISHAIRWAYS);
        plane1 = new Plane(PlaneType.BOEING757, Airline.FLYBE);
        plane2 = new Plane(PlaneType.CIRUSSSR22, Airline.EASYJET);
        plane3 = new Plane(PlaneType.AIRBUSA320, Airline.EASYJET);

        edinburghAirport = new Airport(AirportCode.EDINBURGH);

        flight = new Flight("BA1234", AirportCode.HEATHROW);
        flight1 = new Flight("FB1234", AirportCode.NEWYORK);
        passenger = new Passenger("Jenn");
    }

    @Test
    public void hasCode(){
        assertEquals("EDI", edinburghAirport.getCode());
    }

    @Test
    public void startsWithEmptyHangar(){
        assertEquals(0 , edinburghAirport.planeCount());
    }


    @Test
    public void canAddPlaneToHangar(){
        edinburghAirport.addPlaneToHangar(plane);
        assertEquals(1, edinburghAirport.planeCount());
    }

    @Test
    public void startsWithEmptySchedule(){
        assertEquals(0, edinburghAirport.scheduledFlightsCount());
    }

    @Test
    public void canCreateFlight(){
        edinburghAirport.addPlaneToHangar(plane);
        edinburghAirport.createFlightAndAdd("KM1234", AirportCode.HEATHROW);
        assertEquals(1, edinburghAirport.scheduledFlightsCount());
    }

    @Test
    public void canAddFlightToSchedule(){
        edinburghAirport.addPlaneToHangar(plane);
        edinburghAirport.addFlight(flight);
        assertEquals(1, edinburghAirport.scheduledFlightsCount());
    }

    @Test
    public void doesNotAddFlightIfNoPlanes(){
        edinburghAirport.addFlight(flight);
        assertEquals(0, edinburghAirport.scheduledFlightsCount());
    }

    @Test
    public void canAssignPlaneToFlight(){
        edinburghAirport.addFlight(flight);
        edinburghAirport.addPlaneToHangar(plane);
        edinburghAirport.assignPlaneToFlight(flight);
        assertNotNull(flight.getPlane());
    }

    @Test
    public void canSellTicketsForFlight(){
        edinburghAirport.addPlaneToHangar(plane);
        edinburghAirport.addFlight(flight);
        Ticket ticket = edinburghAirport.sellTicketForFlight(flight, passenger);
        assertEquals(passenger, ticket.getPassenger());
        assertEquals(flight, ticket.getFlight());
        assertEquals(1, plane.passengerCount());
    }

    @Test
    public void tracksTicketSales(){
        edinburghAirport.addPlaneToHangar(plane);
        edinburghAirport.addFlight(flight);
        assertEquals(0, edinburghAirport.getTicketSalesForFlight(flight));
        edinburghAirport.sellTicketForFlight(flight, passenger);
        assertEquals(1, edinburghAirport.getTicketSalesForFlight(flight));
    }

    @Test
    public void doesNotSellTicketIfFullyBooked(){
        edinburghAirport.addPlaneToHangar(plane2);
        edinburghAirport.addFlight(flight);
        for (int i=1; i < 6; i++){
            edinburghAirport.sellTicketForFlight(flight, passenger);
        }
        assertEquals(4, edinburghAirport.getTicketSalesForFlight(flight));
    }

    @Test
    public void canGetFlightDistance(){
        edinburghAirport.addPlaneToHangar(plane);
        edinburghAirport.addFlight(flight);
        assertEquals(401.4, edinburghAirport.getFlightDistance(flight), 0.1);
    }

    @Test
    public void assignsBestPlane(){
        edinburghAirport.addPlaneToHangar(plane);
        edinburghAirport.addPlaneToHangar(plane2);
        edinburghAirport.addPlaneToHangar(plane3);
        edinburghAirport.addPlaneToHangar(plane1);

        edinburghAirport.addFlight(flight1);

        assertEquals(plane3, flight1.getPlane());
    }

    @Test
    public void canFindSecondBestPlane(){
        edinburghAirport.addPlaneToHangar(plane);
        edinburghAirport.addPlaneToHangar(plane2);
        edinburghAirport.addPlaneToHangar(plane3);
        edinburghAirport.addPlaneToHangar(plane1);

        edinburghAirport.addFlight(flight1);
        edinburghAirport.replacePlane(flight1);

        assertEquals(plane1, flight1.getPlane());
    }

}
