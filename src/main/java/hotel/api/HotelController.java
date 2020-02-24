package hotel.api;

import hotel.model.*;
import hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/v69/hotels/")
public class HotelController {

    @Autowired
    public HotelService hotelService;

//    @GetMapping
//    public RoomListResponse getRoomList() {
//        return new RoomListResponse(roomListService.getAllRooms());
//    }

    @PostMapping
    public Hotel createHotels(@RequestBody @Valid HotelRequest hotelRequest) {

        return hotelService.addHotels(
                new Hotel(null, hotelRequest.getName(),
                        hotelRequest.getDescription(), hotelRequest.getCity(),
                        hotelRequest.getPhoto(), hotelRequest.getPriceFrom(),
                        hotelRequest.getPriceTo(), hotelRequest.getStatus(), hotelRequest.getAvailableRooms(), LocalDate.now(), LocalDateTime.now()));
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
