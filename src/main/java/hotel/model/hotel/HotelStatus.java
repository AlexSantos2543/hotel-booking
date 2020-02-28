package hotel.model.hotel;

public enum HotelStatus {

    ACTIVE,
    INACTIVE;

    public static HotelStatus getHotelStatus(String value) {
        for (HotelStatus status : values()) {
            if(status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        return null;
    }
}
