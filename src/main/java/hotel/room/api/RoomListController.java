package hotel.room.api;

import hotel.room.model.RoomRequest;
import hotel.room.model.RoomListResponse;
import hotel.room.model.Room;
import hotel.room.service.ResourceNotFoundException;
import hotel.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/v69/hotel/rooms")
public class RoomListController {

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
    public Optional<Room> UpdateRoom(@PathVariable("refId") String refId, @RequestBody @Valid RoomRequest roomRequest) throws ResourceNotFoundException {
        return roomListService.updateRoomDetails(refId,roomRequest);
    }

    @DeleteMapping("{refId}")
    public Optional<Room> deleteRoom(@PathVariable("refId") String refId) {
        return roomListService.removeRoomById(refId);
    }
}
