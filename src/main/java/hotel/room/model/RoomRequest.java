package hotel.room.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class RoomRequest {

    @NotBlank
    private final String name;
    private final String type;
    private final String desc;
    private final String code;
    private final List<BedDetails> bedDetail;
    private String smokeIndicator;

    @JsonCreator
    public RoomRequest(@JsonProperty("name") String name, @JsonProperty("type") String type, @JsonProperty("desc") String desc,
                       @JsonProperty("code") String code, @JsonProperty("bedDetail") List<BedDetails>  bedDetail, @JsonProperty("smokeIndicator") String smokeIndicator) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.code = code;
        this.bedDetail = bedDetail;
        this.smokeIndicator = smokeIndicator;
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
        return "RoomRequest{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", code='" + code + '\'' +
                ", bedDetail=" + bedDetail +
                ", smokeIndicator='" + smokeIndicator + '\'' +
                '}';
    }
}
