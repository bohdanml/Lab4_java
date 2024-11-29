package org.example.hotel.service;

import org.example.hotel.dto.BookingDTO;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    BookingDTO getBookingById(long id);

    List<BookingDTO> getBookings();

    BookingDTO createBooking(BookingDTO bookingDTO);

    BookingDTO updateBooking(BookingDTO bookingDTO);

    void deleteById(long id);

    boolean isCottageBooked(long cottageId, LocalDate startDate, LocalDate endDate);

    List<LocalDate> getAvailableDates(long cottageId, LocalDate startDate, LocalDate endDate);
}
