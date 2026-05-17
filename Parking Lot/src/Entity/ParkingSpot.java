package Entity;

public class ParkingSpot {
    private String spotId;
    private boolean free;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.free = true;
    }


    public boolean isFree() {
        return free;
    }

    public String getSpotId() {
        return spotId;
    }

    public void occupySpot() {
        free = false;
    }

    public void releaseSpot() {
        free = true;
    }
}
