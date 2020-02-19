package hotel.room.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "room-server")
public class Room {

    private String refId = UUID.randomUUID().toString();

    private final String name;
    private final String type;
    private final String desc;
    private final String code;
//    private RoomPrice price;
    private final List<BedDetails> bedDetail;
    private String smokeIndicator;

    @JsonCreator
    public Room(@JsonProperty("refId") String refId, @JsonProperty("name") String name,
                @JsonProperty("type") String type, @JsonProperty("desc") String desc,
                @JsonProperty("code") String code, @JsonProperty("bedDetail") List<BedDetails>  bedDetail, @JsonProperty("smokeIndicator") String smokeIndicator) {
        this.refId = refId;
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.code = code;
        this.bedDetail = bedDetail;
        this.smokeIndicator = smokeIndicator;
    }

    public String getRefId() {
        return refId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }

    public List<BedDetails> getBedDetail() {
        return bedDetail;
    }

    public String getSmokeIndicator() {
        return smokeIndicator;
    }

    @Override
    public String toString() {
        return "Room{" +
                "refId='" + refId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", code='" + code + '\'' +
                ", bedDetail=" + bedDetail +
                ", smokeIndicator='" + smokeIndicator + '\'' +
                '}';
    }
}
