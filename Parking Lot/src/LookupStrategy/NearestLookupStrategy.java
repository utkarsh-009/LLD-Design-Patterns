public class NearestLookupStrategy implements ParkingSpotLookupStrategy {
    
    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.isFree()) {
                return parkingSpot;
            }
        }
        return null;
    }
}
