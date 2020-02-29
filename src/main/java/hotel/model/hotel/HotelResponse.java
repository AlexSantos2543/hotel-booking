package hotel.model.hotel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import hotel.model.hotel.Hotel;


import java.util.List;


public class HotelResponse {

    private final List<Hotel> hotels;

    @JsonCreator
    public HotelResponse(@JsonProperty("items") List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    @Override
    public String toString() {
        return "HotelResponse{" +
                "hotels=" + hotels +
                '}';
    }
}
