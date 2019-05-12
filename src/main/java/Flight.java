public class Flight {

    private String flightNumber;
    private AirportCode destination;
    private Plane plane;

    public Flight(String flightNumber, AirportCode destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.plane = null;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination.getCode();
    }

    public double getDistance(){
        return destination.getDistanceFromEdinburgh();
    }

    public Plane getPlane() {
        return plane;
    }

    public void assignPlane(Plane plane) {
        this.plane = plane;
    }

    public void boardPassenger(Passenger passenger) {
        plane.addPassenger(passenger);
    }

    public boolean isFull() {
        return plane.isFull();
    }
}
