package hotel.model.hotel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document("admin-hotel")
public class Hotel {

    @Id
    private String _id;
    private String name;
    private String description;
    private String city;
    private String photo;
    private Double priceFrom;
    private Double priceTo;
    private String status;
    private Integer availableRooms;
    private LocalDate createdDate;
    private LocalDateTime updatedDate;

    public Hotel() {

    }

    public Hotel(String name, String description, String city, String photo, Double priceFrom, Double priceTo, String status, Integer availableRooms) {

        this(null, name, description, city, photo, priceFrom, priceTo, status, availableRooms, LocalDate.now(), LocalDateTime.now());
    }

    @JsonCreator
    public Hotel(@JsonProperty("id") String _id, @JsonProperty("name") String name, @JsonProperty("description") String description,
                         @JsonProperty("city") String city, @JsonProperty("photo") String photo, @JsonProperty("priceFrom") Double priceFrom,
                         @JsonProperty("priceTo") Double priceTo, @JsonProperty("status") String status, @JsonProperty("availableRooms") Integer availableRooms,
                         @JsonProperty("createdDate") LocalDate createdDate, @JsonProperty("updatedDate") LocalDateTime updatedDate) {
        this._id = _id;
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

    public String getId() {
        return _id;
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

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }

    @Override
    public String toString() {
        return "HotelResponse{" +
                "id='" + _id + '\'' +
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
