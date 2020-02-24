package hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class HotelResponse {

    private String id;
    private String name;
    private String description;
    private String city;
    private String photo;
    private Double priceFrom;
    private Double priceTo;
    private String status;
    private Integer availableRooms;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public HotelResponse(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("description") String description,
                         @JsonProperty("city") String city, @JsonProperty("photo") String photo, @JsonProperty("priceFrom") Double priceFrom,
                         @JsonProperty("priceTo") Double priceTo, @JsonProperty("status") String status, @JsonProperty("availableRooms") Integer availableRooms,
                         @JsonProperty("createdDate") LocalDate createdDate, @JsonProperty("updatedDate") LocalDate updatedDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
        this.photo = photo;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.status = status;
        this.availableRooms = availableRooms;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public String toString() {
        return "HotelResponse{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", photo='" + photo + '\'' +
                ", priceFrom='" + priceFrom + '\'' +
                ", priceTo='" + priceTo + '\'' +
                ", status='" + status + '\'' +
                ", availableRooms=" + availableRooms +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
