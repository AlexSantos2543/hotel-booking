package hotel.model.hotel;

import hotel.model.hotel.Hotel;
import hotel.model.hotel.HotelRequest;
import hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;

public class HotelResponse {

    @Autowired
    private HotelService hotelService;

    public HotelResponse() {
    }

    public Hotel hotelResponse(HotelRequest hotelRequest) {

        return hotelService.addHotels(new Hotel(null, hotelRequest.getName(), hotelRequest.getDescription(), hotelRequest.getCity(),
                hotelRequest.getPhoto(), hotelRequest.getPriceFrom(), hotelRequest.getPriceTo(), hotelRequest.getStatus(),
                hotelRequest.getAvailableRooms(), null, null));
    }

}
