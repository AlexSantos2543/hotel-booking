package hotel.api;

import hotel.model.booking.Booking;
import hotel.model.booking.BookingRequest;
import hotel.service.BookingService;
import hotel.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v69/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("{bookingId}")
    public Optional<Booking> getHotelById(@PathVariable("bookingId") String bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @PostMapping("/v69/rooms/{roomId}/bookings")
    public Booking createHotelBooking(@RequestBody @Valid BookingRequest bookingRequest,@PathVariable String roomId) throws ResourceNotFoundException {

        bookingService.getRoomById(roomId);

        return bookingService.addHotels(new Booking(roomId, bookingRequest.getCustomerId(), bookingRequest.getCheckInDate(), bookingRequest.getCheckoutDate(),
                bookingRequest.getPriceOrder(),bookingRequest.getBookingPrice()));
    }

    @PutMapping("/{bookingId}")
    public Optional<Booking> updateBookingById(@PathVariable("bookingId") @NotBlank String bookingId, @RequestBody @Valid BookingRequest bookingRequest)
            throws ResourceNotFoundException {
        return bookingService.updateBookingById(bookingId, bookingRequest);
    }

    @DeleteMapping("{bookingId}")
    public Optional<Booking> deleteRoom(@PathVariable("bookingId") @NotBlank String bookingId) throws ResourceNotFoundException {
        return bookingService.removeHotelById(bookingId);
    }
}
