package hotel.service;

import hotel.model.Room;
import hotel.model.RoomRequest;
import hotel.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Room> removeRoomById(String refId) throws ResourceNotFoundException {
        Optional<Room> room = Optional.ofNullable(roomRepository.findById(refId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this refId :: " + refId)));
        room.ifPresent(r -> roomRepository.delete(r));
        return room;
    }

    public Optional<Room> updateRoomDetails(String refId, RoomRequest roomRequest) throws ResourceNotFoundException {
        Optional<Room> room = Optional.ofNullable(roomRepository.findById(refId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + refId)));
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
