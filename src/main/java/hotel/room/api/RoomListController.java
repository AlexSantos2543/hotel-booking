package hotel.room.api;

import hotel.room.model.RoomRequest;
import hotel.room.model.RoomListResponse;
import hotel.room.model.Room;
import hotel.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
