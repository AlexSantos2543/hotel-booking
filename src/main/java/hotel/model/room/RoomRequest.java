package hotel.model.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomRequest {

    @NotBlank
    private String hotelId;
    private String name;
    private String bedType;
    private Integer quantity;
    private Integer sleeps;
    private String[] facilities;
    private List<Pricing> pricing;

    @JsonCreator
    public RoomRequest(@NotBlank @JsonProperty("hotelId") String hotelId,@JsonProperty("name") String name,
                       @JsonProperty("bedType") String bedType,@JsonProperty("quantity") Integer quantity,@JsonProperty("sleeps") Integer sleeps,
                       @JsonProperty("facilities") String[] facilities,@JsonProperty("pricing") List<Pricing> pricing) {
        this.hotelId = hotelId;
        this.name = name;
        this.bedType = bedType;
        this.quantity = quantity;
        this.sleeps = sleeps;
        this.facilities = facilities;
        this.pricing = pricing;
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

    public List<Pricing> getPricing() {
        return pricing;
    }

    @Override
    public String toString() {
        return "RoomRequest{" +
                "hotelId='" + hotelId + '\'' +
                ", name='" + name + '\'' +
                ", bedType='" + bedType + '\'' +
                ", quantity=" + quantity +
                ", sleeps=" + sleeps +
                ", facilities=" + Arrays.toString(facilities) +
                ", pricing=" + pricing +
                '}';
    }
}
