public enum AirportCode {
    EDINBURGH("EDI", 0.0),
    GLASGOW("GLA", 55.0),
    HEATHROW("LHR", 401.4),
    PARIS("CDG", 682.9),
    NEWYORK("JFK", 3257.0);

    private String code;
    private double distanceFromEdinburgh;

    AirportCode(String code, double distanceFromEdinburgh) {
        this.code = code;
        this.distanceFromEdinburgh = distanceFromEdinburgh;
    }

    public String getCode() {
        return code;
    }

    public double getDistanceFromEdinburgh() {
        return distanceFromEdinburgh;
    }
}
