package hotel.api;

import hotel.model.hotel.Hotel;
import hotel.model.hotel.HotelRequest;
import hotel.model.hotel.HotelStatus;
import hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v69/hotels/")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/status/{status}")
    public Page<Hotel> getHotelByStatus(@PathVariable HotelStatus status, Pageable pageable) {
        return hotelService.getByStatus(status, pageable);
    }

    @PostMapping
    public Hotel createHotels(@RequestBody @Valid HotelRequest hotelRequest) {

        return hotelService.addHotels(new Hotel(hotelRequest.getName(), hotelRequest.getDescription(), hotelRequest.getCity(),
                hotelRequest.getPhoto(), hotelRequest.getPriceFrom(), hotelRequest.getPriceTo(), hotelRequest.getStatus(),
                hotelRequest.getAvailableRooms()));
    }


    @GetMapping(path="/search")
    public Page<Hotel> findHotelByNameAndCity(@RequestParam String name, @RequestParam String city,
                                 @RequestParam int page, @RequestParam int pageSize) {
        return hotelService.findHotelByNameAndCity(name, city, PageRequest.of(page, pageSize));
    }

//    @PutMapping("{refId}")
//    public Optional<Room> UpdateRoom(@PathVariable("refId") @NotBlank String refId, @RequestBody @Valid RoomRequest roomRequest) throws ResourceNotFoundException {
//        return roomListService.updateRoomDetails(refId,roomRequest);
//    }
//
//    @DeleteMapping("{refId}")
//    public Optional<Room> deleteRoom(@PathVariable("refId") @NotBlank String refId) throws ResourceNotFoundException {
//        return roomListService.removeRoomById(refId);
//    }
}
