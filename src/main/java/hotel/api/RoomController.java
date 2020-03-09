package hotel.api;

import hotel.model.booking.Booking;
import hotel.model.room.RoomRequest;
import hotel.model.room.RoomListResponse;
import hotel.model.room.Room;
import hotel.service.BookingService;
import hotel.exception.ResourceNotFoundException;
import hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v69/rooms")
public class RoomController {

    @Autowired
    RoomService roomListService;

    @Autowired
    BookingService bookingService;

    @GetMapping
    public RoomListResponse getRoomList() {
        return new RoomListResponse(roomListService.getAllRooms());
    }

    @GetMapping("/{roomId}/bookings")
    public List<Booking> findBookingByRoomId(@PathVariable String roomId) throws ResourceNotFoundException {

        bookingService.getRoomById(roomId);

        return bookingService.getAllBookings();
    }

    @GetMapping("/search")
    public Page<Room> findByRefIdLikeAndHotelId(@RequestParam(value = "refId") String refId, @RequestParam("hotelId") String hotelId, int page, int size ) {
    return roomListService.findByRefIdLikeAndHotelId(refId, hotelId, PageRequest.of(page, size));
    }

    @PostMapping
    public Room createRoomList(@RequestBody @Valid RoomRequest roomRequest) throws ResourceNotFoundException {
       roomListService.getHotelId(roomRequest);

      return roomListService.addRooms(new Room(null,roomRequest.getHotelId(), roomRequest.getName(),
                roomRequest.getBedType(), roomRequest.getQuantity(),
                roomRequest.getSleeps(), roomRequest.getFacilities(),
                roomRequest.getPricing()));
    }

    @PutMapping("{refId}")
    public Optional<Room> updateRooms(@PathVariable("refId") @NotBlank String refId, @RequestBody @Valid RoomRequest roomRequest) throws ResourceNotFoundException {
        return roomListService.updateRoomDetails(refId,roomRequest);
    }

    @DeleteMapping("{refId}")
    public Optional<Room> deleteRoom(@PathVariable("refId") @NotBlank String refId) throws ResourceNotFoundException {
        return roomListService.removeRoomById(refId);
    }
}
