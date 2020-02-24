package hotel.service;

import hotel.model.*;
import hotel.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HotelService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HotelRepository hotelRepository;

//    public List<Hotel> getAllRooms() {
//        return roomRepository.findAll();
//    }

    public Hotel addHotels(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

//    public Optional<Hotel> removeHotelyId(String id) throws ResourceNotFoundException {
//        Optional<Room> room = Optional.ofNullable(roomRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this refId :: " + refId)));
//        room.ifPresent(r -> roomRepository.delete(r));
//        return room;
//    }
//
//    public Optional<Room> updateRoomDetails(String refId, RoomRequest roomRequest) throws ResourceNotFoundException {
//        Optional<Room> room = Optional.ofNullable(roomRepository.findById(refId)
//                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + refId)));
//        room.ifPresent(r -> r.setName(roomRequest.getName()));
//        room.ifPresent(r -> r.setType(roomRequest.getType()));
//        room.ifPresent(r -> r.setDesc(roomRequest.getDesc()));
//        room.ifPresent(r -> r.setCode(roomRequest.getCode()));
//        room.ifPresent(r -> r.setBedDetail(roomRequest.getBedDetail()));
//        room.ifPresent(r -> r.setSmokeIndicator(roomRequest.getSmokeIndicator()));
//
//        room.ifPresent(r -> roomRepository.save(r));
//
//        return room;

//    }
}
