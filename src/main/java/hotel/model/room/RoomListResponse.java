package hotel.model.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class RoomListResponse {

    private final List<Room> rooms;

    @JsonCreator
    public RoomListResponse(@JsonProperty("rooms") List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return "RoomListResponse{" +
                "rooms=" + rooms +
                '}';
    }
}
