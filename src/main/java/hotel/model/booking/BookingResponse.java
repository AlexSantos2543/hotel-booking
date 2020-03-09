package hotel.model.booking;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BookingResponse {

    private String _id;
    private String customerId;
    private Date checkInDate;
    private Date checkoutDate;
    private Integer priceOrder;
    private Integer bookingPrice;

    public BookingResponse(String customerId, Date checkInDate, Date checkoutDate, Integer priceOrder, Integer bookingPrice) {
        this(null,customerId,checkInDate,checkoutDate,priceOrder,bookingPrice);
    }

    @JsonCreator
    public BookingResponse(@JsonProperty("_id") String _id, @JsonProperty("customerId") String customerId,
                           @JsonProperty("checkIn_date") Date checkInDate, @JsonProperty("checkOut_date") Date checkoutDate,
                           @JsonProperty("priceOrder") Integer priceOrder, @JsonProperty("bookingPrice") Integer bookingPrice) {

        this._id = _id;
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

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckoutDate() {
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
