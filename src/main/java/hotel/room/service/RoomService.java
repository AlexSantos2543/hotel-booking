package hotel.room.service;

import hotel.room.model.Room;
import hotel.room.repository.RoomListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RoomListRepository roomListRepository;

    public List<Room> getAllRooms() {
        return roomListRepository.findAll();
    }

    public Room addRooms(Room room) {
        return roomListRepository.save(room);
    }
}
