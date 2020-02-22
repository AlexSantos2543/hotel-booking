package hotel.room.service;

import hotel.room.model.Room;
import hotel.room.model.RoomRequest;
import hotel.room.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room addRooms(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRooms(Room room) {
        return roomRepository.save(room);
    }

    public Optional<Room> removeRoomById(String refId) {
        Optional<Room> room = roomRepository.findById(refId);
        room.ifPresent(r -> roomRepository.delete(r));
        return room;
    }

    public Optional<Room> updateRoomDetails(String id, RoomRequest roomRequest) throws ResourceNotFoundException {
        Optional<Room> room = Optional.ofNullable(roomRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Room not found for this id :: " + id)));
        room.ifPresent(r -> r.setName(roomRequest.getName()));
        room.ifPresent(r -> r.setType(roomRequest.getType()));
        room.ifPresent(r -> r.setDesc(roomRequest.getDesc()));
        room.ifPresent(r -> r.setCode(roomRequest.getCode()));
        room.ifPresent(r -> r.setBedDetail(roomRequest.getBedDetail()));
        room.ifPresent(r -> r.setSmokeIndicator(roomRequest.getSmokeIndicator()));

        room.ifPresent(r -> roomRepository.save(r));

        return room;

    }
}
