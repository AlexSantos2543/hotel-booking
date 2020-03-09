package hotel.api;

import hotel.model.hotel.*;
import hotel.model.room.Room;
import hotel.service.HotelService;
import hotel.exception.ResourceNotFoundException;
import hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/v69/hotels/")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    RoomService roomService;

    @GetMapping
    public HotelResponse getAllHotels() {
        return new HotelResponse(hotelService.getAllHotels());
    }

    @GetMapping("{id}")
    public Optional<Hotel> getHotelById(@PathVariable("id") String id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping("{id}/rooms")
    public Stream<Room> getRoomByHotelById(@PathVariable("id") String id) {

        return roomService.getAllRooms().stream().filter(h -> h.getHotelId().equals(id));
    }

    @GetMapping("status/{status}")
    public Page<Hotel> getHotelByStatus(@PathVariable HotelStatus status, @RequestParam int page, @RequestParam int size) {
        PageRequest request = PageRequest.of(page, size);

        return hotelService.getByStatus(status, request);
    }

    @PostMapping
    public Hotel createHotels(@RequestBody @Valid HotelRequest hotelRequest) {
        return hotelService.addHotels(new Hotel(hotelRequest.getName(), hotelRequest.getDescription(), hotelRequest.getCity(),
                hotelRequest.getPhoto(), hotelRequest.getPriceFrom(), hotelRequest.getPriceTo(), hotelRequest.getStatus(),
                hotelRequest.getAvailableRooms()));
    }

    @DeleteMapping("{id}")
    public Optional<Hotel> deleteRoom(@PathVariable("id") @NotBlank String id) throws ResourceNotFoundException {
        return hotelService.removeHotelById(id);
    }

//    @GetMapping(path="search")
//    public Page<Hotel> findHotelByNameAndCity(@RequestParam String city, @RequestParam String check_in, @RequestParam String check_out,
//                                              @RequestParam int page, @RequestParam int pageSize) {
//        return hotelService.findHotelByNameAndCity(name, city, PageRequest.of(page, pageSize));
//    }


//    @GetMapping(path="/search")
//    public Page<Hotel> findHotelByNameAndCity(@RequestParam String name, @RequestParam String city,
//                                 @RequestParam int page, @RequestParam int pageSize) {
//        return hotelService.findHotelByNameAndCity(name, city, PageRequest.of(page, pageSize));
//    }

    @PutMapping("/{id}")
    public Optional<Hotel> updateHotelById(@PathVariable("id") @NotBlank String id, @RequestBody @Valid HotelRequest hotelRequest)
            throws ResourceNotFoundException {
        return hotelService.updateHotelById(id, hotelRequest);
    }

}
