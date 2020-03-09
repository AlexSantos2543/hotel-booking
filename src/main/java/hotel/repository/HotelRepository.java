package hotel.repository;

import hotel.model.hotel.Hotel;
import hotel.model.hotel.HotelStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface HotelRepository extends MongoRepository<Hotel, String> {

    Page<Hotel> findByNameLikeAndCity(String name, String city, PageRequest request);

    List<Hotel> findAll();

    Page<Hotel> findByStatus(HotelStatus status, PageRequest request);

}
