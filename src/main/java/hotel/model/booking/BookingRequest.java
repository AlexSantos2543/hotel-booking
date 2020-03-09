package hotel.model.booking;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;


@Document("hotel-booking")
public class BookingRequest {

    private String roomId;
    private String customerId;
    @NotBlank(message = "Check-in date cannot be blank")
    private String checkInDate;
    @NotBlank(message = "Check-out date cannot be blank")
    private String checkoutDate;
    private Integer priceOrder;
    private Integer bookingPrice;

    @JsonCreator
    public BookingRequest(@JsonProperty("_id") String _id, String roomId, @JsonProperty("customerId") String customerId,
                          @JsonProperty("checkIn_date") String checkInDate, @JsonProperty("checkOut_date") String checkoutDate,
                          @JsonProperty("priceOrder") Integer priceOrder, @JsonProperty("bookingPrice") Integer bookingPrice) {

        this.roomId = roomId;
        this.customerId = customerId;
        this.checkInDate = checkInDate;
        this.checkoutDate = checkoutDate;
        this.priceOrder = priceOrder;
        this.bookingPrice = bookingPrice;
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

    @Override
    public String toString() {
        return "BookingRequest{" +
                "roomId='" + roomId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkoutDate='" + checkoutDate + '\'' +
                ", priceOrder=" + priceOrder +
                ", bookingPrice=" + bookingPrice +
                '}';
    }
}
