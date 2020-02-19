package hotel.room.repository;

import hotel.room.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface RoomListRepository extends MongoRepository<Room, String> {
}
