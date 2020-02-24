package hotel.repository;

import hotel.model.Hotel;
import hotel.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface HotelRepository extends MongoRepository<Hotel, String> {
}
