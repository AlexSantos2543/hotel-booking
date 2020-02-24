package hotel.api;

import hotel.model.RoomRequest;
import hotel.model.RoomListResponse;
import hotel.model.Room;
import hotel.service.ResourceNotFoundException;
import hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@RestController
@RequestMapping("/v69/hotel/rooms")
public class RoomController {

    @Autowired
    public RoomService roomListService;

    @GetMapping
    public RoomListResponse getRoomList() {
        return new RoomListResponse(roomListService.getAllRooms());
    }

    @PostMapping
    public Room createRoomList(@RequestBody @Valid RoomRequest roomRequest) {

        return roomListService.addRooms(
                new Room(null,roomRequest.getName(),
                        roomRequest.getType(), roomRequest.getDesc(),
                        roomRequest.getCode(), roomRequest.getBedDetail(),
                        roomRequest.getSmokeIndicator()));
    }

    @PutMapping("{refId}")
    public Optional<Room> UpdateRoom(@PathVariable("refId") @NotBlank String refId, @RequestBody @Valid RoomRequest roomRequest) throws ResourceNotFoundException {
        return roomListService.updateRoomDetails(refId,roomRequest);
    }

    @DeleteMapping("{refId}")
    public Optional<Room> deleteRoom(@PathVariable("refId") @NotBlank String refId) throws ResourceNotFoundException {
        return roomListService.removeRoomById(refId);
    }
}
