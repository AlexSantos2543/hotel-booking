package hotel.model.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class HotelRequest {

    private String name;
    private String description;
    private String city;
    private String photo;
    private Double priceFrom;
    private Double priceTo;
    private String status;
    private Integer availableRooms;

    public HotelRequest(@JsonProperty("name") String name, @JsonProperty("description") String description,
                        @JsonProperty("city") String city, @JsonProperty("photo") String photo, @JsonProperty("priceFrom") Double priceFrom,
                        @JsonProperty("priceTo") Double priceTo, @JsonProperty("status") String status, @JsonProperty("availableRooms") Integer availableRooms) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.photo = photo;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.status = status;
        this.availableRooms = availableRooms;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public String getPhoto() {
        return photo;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public String getStatus() {
        return status;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    @Override
    public String toString() {
        return "HotelResponse{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", photo='" + photo + '\'' +
                ", priceFrom='" + priceFrom + '\'' +
                ", priceTo='" + priceTo + '\'' +
                ", status='" + status + '\'' +
                ", availableRooms=" + availableRooms +
                '}';
    }
}
