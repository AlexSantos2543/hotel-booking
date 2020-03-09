package hotel.service;

import hotel.exception.ResourceNotFoundException;
import hotel.model.hotel.Hotel;
import hotel.model.room.Room;
import hotel.model.room.RoomRequest;
import hotel.repository.HotelRepository;
import hotel.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HotelRepository hotelRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room addRooms(Room room) {
        return roomRepository.save(room);
    }

    public Page<Room> findByRefIdLikeAndHotelId(String refId, String hotelId, PageRequest pageRequest) {
        return roomRepository.findByRefIdLikeAndHotelId(refId, hotelId, pageRequest);
    }

    public Optional<Room> removeRoomById(String refId) throws ResourceNotFoundException {
        Optional<Room> room = Optional.ofNullable(roomRepository.findById(refId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this refId :: " + refId)));
        room.ifPresent(r -> roomRepository.delete(r));
        return room;
    }

    //TODO give a better name to this method below
    public Optional<Hotel> getHotelId(RoomRequest request) throws ResourceNotFoundException {

        return Optional.ofNullable(hotelRepository.findById(request.getHotelId())
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this _id :: " + request.getHotelId())));
    }

    public Optional<Room> updateRoomDetails(String refId, RoomRequest roomRequest) throws ResourceNotFoundException {
        Optional<Room> room = Optional.ofNullable(roomRepository.findById(refId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + refId)));

        room.ifPresent(h -> h.setHotelId(roomRequest.getHotelId()));
        room.ifPresent(h -> h.setName(roomRequest.getName()));
        room.ifPresent(h -> h.setBedType(roomRequest.getBedType()));
        room.ifPresent(h -> h.setQuantity(roomRequest.getQuantity()));
        room.ifPresent(h -> h.setSleeps(roomRequest.getSleeps()));
        room.ifPresent(h -> h.setFacilities(roomRequest.getFacilities()));
        room.ifPresent(h -> h.setPricing(roomRequest.getPricing()));

        room.ifPresent(r -> roomRepository.save(r));

        return room;
    }
}
