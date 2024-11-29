package org.example.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotel.entity.Booking;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private long id;
    private long cottageId;
    private long userId;
    private LocalDate startDate;
    private LocalDate endDate;

    public static BookingDTO fromBooking(Booking booking) {
        final BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setCottageId(booking.getCottageId());
        bookingDTO.setUserId(booking.getUserId());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setEndDate(booking.getEndDate());
        return bookingDTO;
    }

    public static Booking toBooking(BookingDTO bookingDTO) {
        final Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setCottageId(bookingDTO.getCottageId());
        booking.setUserId(bookingDTO.getUserId());
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());
        return booking;
    }
}
