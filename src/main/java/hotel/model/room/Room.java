package hotel.model.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Document(collection = "room-server")
public class Room {

    @Id
    private String refId;

    private String hotelId;
    private String name;
    private String bedType;
    private Integer quantity;
    private Integer sleeps;
    private String[] facilities;
    private List<Pricing> pricing;

    @JsonCreator
    public Room(@JsonProperty("refId") String refId, @JsonProperty("hotelId") String hotelId,@JsonProperty("name") String name,
                @JsonProperty("bedType") String bedType,@JsonProperty("quantity") Integer quantity,@JsonProperty("sleeps") Integer sleeps,
                @JsonProperty("facilities") String[] facilities,@JsonProperty("pricing") List<Pricing> pricing) {
        this.refId = refId;
        this.hotelId = hotelId;
        this.name = name;
        this.bedType = bedType;
        this.quantity = quantity;
        this.sleeps = sleeps;
        this.facilities = facilities;
        this.pricing = pricing;
    }

    public String getRefId() {
        return refId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public String getBedType() {
        return bedType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getSleeps() {
        return sleeps;
    }

    public String[] getFacilities() {
        return facilities;
    }

    public List<Pricing> getPricing() {
        return pricing;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setSleeps(Integer sleeps) {
        this.sleeps = sleeps;
    }

    public void setFacilities(String[] facilities) {
        this.facilities = facilities;
    }

    public void setPricing(List<Pricing> pricing) {
        this.pricing = pricing;
    }

    @Override
    public String toString() {
        return "Room{" +
                "refId='" + refId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", name='" + name + '\'' +
                ", bedType='" + bedType + '\'' +
                ", quantity=" + quantity +
                ", sleeps=" + sleeps +
                ", facilities=" + Arrays.toString(facilities) +
                ", pricing=" + pricing +
                '}';
    }
}
