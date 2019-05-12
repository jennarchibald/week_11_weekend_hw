import java.util.ArrayList;
import java.util.List;

public class Plane {

    private PlaneType type;
    private Airline airline;
    private ArrayList<Passenger> passengers;


    public Plane(PlaneType type, Airline airline) {
        this.type = type;
        this.airline = airline;
        this.passengers = new ArrayList<>();
    }

    public PlaneType getType() {
        return type;
    }

    public Airline getAirline() {
        return airline;
    }

    public int passengerCount(){
        return passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public Passenger findPassenger(Passenger passenger) {
        List<Passenger> passengersToSearch = passengers;

        while (passengersToSearch.size() > 1){
            int halfway = passengersToSearch.size() / 2;
            List<Passenger> firstHalf = passengersToSearch.subList(0, halfway);
            List<Passenger> secondHalf = passengersToSearch.subList(halfway, passengersToSearch.size());
            if (firstHalf.contains(passenger)){
                passengersToSearch = firstHalf;
            } else {
                passengersToSearch = secondHalf;
            }
        }

        return passengersToSearch.get(0) == passenger ? passenger : null;
    }


    public boolean isFull() {
        return passengers.size() >= type.getCapacity();
    }

    public int getFlightRange() {
        return type.getFlightRange();
    }
}
