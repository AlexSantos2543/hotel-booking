package hotel.service;

import hotel.exception.ResourceNotFoundException;
import hotel.model.booking.Booking;
import hotel.model.booking.BookingRequest;
import hotel.model.room.Room;
import hotel.repository.BookingRepository;
import hotel.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    RoomRepository roomRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(String bookingId) {
        return bookingRepository.findById(bookingId);
    }

    public Booking addHotels(Booking hotelBooking) {
        return bookingRepository.save(hotelBooking);
    }

    public Optional<Room> getRoomById(String request) throws ResourceNotFoundException {

        return Optional.ofNullable(roomRepository.findById(request)
                .orElseThrow(() -> new ResourceNotFoundException("Room does not exist for this _id :: " + request)));
    }

    public Optional<Booking> updateBookingById(String id, BookingRequest bookingRequest) throws ResourceNotFoundException {

        Optional<Booking> booking = Optional.ofNullable(bookingRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + id)));

        booking.ifPresent(h -> h.setCustomerId(bookingRequest.getCustomerId()));
        booking.ifPresent(h -> h.setCheckInDate(bookingRequest.getCheckInDate()));
        booking.ifPresent(h -> h.setCheckoutDate(bookingRequest.getCheckoutDate()));
        booking.ifPresent(h -> h.setPriceOrder(bookingRequest.getPriceOrder()));
        booking.ifPresent(h -> h.setBookingPrice(bookingRequest.getBookingPrice()));

        booking.ifPresent(h -> bookingRepository.save(h));

        return booking;
    }

    public Optional<Booking> removeHotelById(String id) throws ResourceNotFoundException {
        Optional<Booking> booking = Optional.ofNullable(bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this _id :: " + id)));
        booking.ifPresent(r -> bookingRepository.delete(r));
        return booking;
    }
}
