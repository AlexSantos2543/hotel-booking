package hotel.service;

import hotel.exception.ResourceNotFoundException;
import hotel.model.hotel.Hotel;
import hotel.model.hotel.HotelRequest;
import hotel.model.hotel.HotelStatus;
import hotel.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HotelService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HotelRepository hotelRepository;

    public Page<Hotel> getByStatus(HotelStatus status, PageRequest pageRequest) {

        return hotelRepository.findByStatus(status, pageRequest);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(String id) {
        return hotelRepository.findById(id);
    }

    public Optional<Hotel> removeHotelById(String id) throws ResourceNotFoundException {
        Optional<Hotel> hotel = Optional.ofNullable(hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this _id :: " + id)));
        hotel.ifPresent(r -> hotelRepository.delete(r));
        return hotel;
    }

    public Hotel addHotels(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

//    public Page<Hotel> findHotelByNameAndCity(String city, String check_in, String check_out, PageRequest pageRequest) {
//        return hotelRepository.findByNameLikeAndCity(name, city, pageRequest);
//    }

    public Optional<Hotel> updateHotelById(String id, HotelRequest hotelRequest) throws ResourceNotFoundException {

        Optional<Hotel> hotel = Optional.ofNullable(hotelRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this id :: " + id)));

        hotel.ifPresent(h -> h.setName(hotelRequest.getName()));
        hotel.ifPresent(h -> h.setDescription(hotelRequest.getDescription()));
        hotel.ifPresent(h -> h.setCity(hotelRequest.getCity()));
        hotel.ifPresent(h -> h.setPhoto(hotelRequest.getPhoto()));
        hotel.ifPresent(h -> h.setPriceFrom(hotelRequest.getPriceFrom()));
        hotel.ifPresent(h -> h.setPriceTo(hotelRequest.getPriceTo()));
        hotel.ifPresent(h -> h.setStatus(hotelRequest.getStatus()));
        hotel.ifPresent(h -> h.setAvailableRooms(hotelRequest.getAvailableRooms()));

        hotel.ifPresent(h -> hotelRepository.save(h));

        return hotel;
    }

}
