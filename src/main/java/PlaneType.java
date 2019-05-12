public enum PlaneType {
    BOEING747(85, 8350 ),
    CIRUSSSR22(4, 1207),
    BOEING757(235,7222),
    AIRBUSA320(236, 6150);

    private int passengerCapacity;
    private int flightRange;

    PlaneType(int passengerCapacity, int flightRange){
        this.passengerCapacity = passengerCapacity;
        this.flightRange = flightRange;
    }

    public int getCapacity(){
        return this.passengerCapacity;
    }

    public int getFlightRange() {
        return flightRange;
    }
}
