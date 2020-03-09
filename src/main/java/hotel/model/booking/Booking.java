package hotel.model.booking;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document("hotel-booking")
public class Booking {

    @Id
    private String _id;

    private String roomId;
    private String customerId;
    @NotBlank(message = "Check-in date cannot be blank")
    private String checkInDate;
    @NotBlank(message = "Check-out date cannot be blank")
    private String checkoutDate;
    private Integer priceOrder;
    private Integer bookingPrice;

    public Booking() {
    }

    public Booking(String roomId, String customerId, String checkInDate, String checkoutDate, Integer priceOrder, Integer bookingPrice) {
        this(null,roomId,customerId,checkInDate,checkoutDate,priceOrder,bookingPrice);
    }

    @JsonCreator
    public Booking(@JsonProperty("_id") String _id, String roomId, @JsonProperty("customerId") String customerId,
                   @JsonProperty("checkIn_date") String checkInDate,@JsonProperty("checkOut_date") String checkoutDate,
                   @JsonProperty("priceOrder") Integer priceOrder, @JsonProperty("bookingPrice") Integer bookingPrice) {

        this._id = _id;
        this.roomId = roomId;
        this.customerId = customerId;
        this.checkInDate = checkInDate;
        this.checkoutDate = checkoutDate;
        this.priceOrder = priceOrder;
        this.bookingPrice = bookingPrice;

    }

    public String get_id() {
        return _id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public Integer getPriceOrder() {
        return priceOrder;
    }

    public Integer getBookingPrice() {
        return bookingPrice;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public void setPriceOrder(Integer priceOrder) {
        this.priceOrder = priceOrder;
    }

    public void setBookingPrice(Integer bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "_id='" + _id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkoutDate=" + checkoutDate +
                ", priceOrder=" + priceOrder +
                ", bookingPrice=" + bookingPrice +
                '}';
    }
}
