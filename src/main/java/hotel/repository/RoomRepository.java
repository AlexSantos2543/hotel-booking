package hotel.repository;

import hotel.model.room.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface RoomRepository extends MongoRepository<Room, String> {

    Optional<Room> findByHotelId(String hotelId);

    Page<Room> findByRefIdLikeAndHotelId(String refId, String hotelId, PageRequest pageRequest);
}
