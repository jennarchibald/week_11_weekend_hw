import java.util.ArrayList;
import java.util.HashMap;

public class Airport {

    private AirportCode code;
    private ArrayList<Plane> hangar;
    private ArrayList<Flight> flightSchedule;
    private HashMap<Flight, Integer> ticketSales;


    public Airport(AirportCode code) {
        this.code = code;
        this.hangar = new ArrayList<>();
        this.flightSchedule = new ArrayList<>();
        this.ticketSales = new HashMap<>();
    }

    public String getCode() {
        return code.getCode();
    }

    public int planeCount(){
        return hangar.size();
    }


    public void addPlaneToHangar(Plane plane){
        hangar.add(plane);
    }

    public int scheduledFlightsCount() {
        return flightSchedule.size();
    }

    public void addFlight(Flight flight) {
        if (planeCount() == 0){
            return;
        }
        assignPlaneToFlight(flight);
        flightSchedule.add(flight);
    }

    public void createFlightAndAdd(String flightNumber, AirportCode destination) {
        if (planeCount() == 0){
            return;
        }
        Flight flight = new Flight(flightNumber, destination);
        addFlight(flight);
    }

    public void assignPlaneToFlight(Flight flight) {
        int indexOfBest = locateBestPlane(flight);
        Plane plane = hangar.remove(indexOfBest);
        flight.assignPlane(plane);
    }

    private int locateBestPlane(Flight flight) {
        double requiredFlightRange = flight.getDistance() * 1.5;
        Plane bestPlane = hangar.get(0);
        for (Plane plane : hangar){
            if (plane.getFlightRange() >= requiredFlightRange && plane.getFlightRange() < bestPlane.getFlightRange()){
                bestPlane = plane;
            }
        }
        return bestPlane.getFlightRange() >= requiredFlightRange ? hangar.indexOf(bestPlane) : null;

    }

    public Ticket sellTicketForFlight(Flight flight, Passenger passenger) {
        if (!flight.isFull()) {
            Ticket ticket = new Ticket(passenger, flight);
            incrementTicketSales(flight);
            flight.boardPassenger(passenger);
            return ticket;
        }
        return null;
    }

    public void incrementTicketSales(Flight flight){
        int ticketsSold = ticketSales.getOrDefault(flight, 0);
        ticketSales.put(flight, ticketsSold + 1 );
    }

    public int getTicketSalesForFlight(Flight flight) {
        int ticketsSold = ticketSales.getOrDefault(flight, 0);
        return ticketsSold;
    }

    public double getFlightDistance(Flight flight) {
        return flight.getDistance();
    }

    public void replacePlane(Flight flight) {
        Plane plane = hangar.remove(locateBestPlane(flight));
        Plane oldPlane = flight.getPlane();
        addPlaneToHangar(oldPlane);
        flight.assignPlane(plane);
    }
}
