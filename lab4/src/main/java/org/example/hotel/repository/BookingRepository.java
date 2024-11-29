package org.example.hotel.repository;

import org.example.hotel.entity.Booking;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookingRepository {
    private List<Booking> bookingList = new ArrayList<>();
    private static long ID = 1;

    public Booking getBookingById(long id) {
        return bookingList.stream()
                .filter(booking -> booking.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("No such booking"));
    }

    public List<Booking> getBookings() {
        return bookingList;
    }

    public Booking save(Booking booking) {
        if (booking.getId() == 0) {
            booking.setId(ID++);
            bookingList.add(booking);
        } else {
            updateBooking(booking);
        }
        return booking;
    }

    public Booking updateBooking(Booking updatedBooking) {
        Booking booking = bookingList.stream()
                .filter(b -> b.getId() == updatedBooking.getId())
                .findAny()
                .orElseThrow(() -> new RuntimeException("No such booking"));
        booking.setCottageId(updatedBooking.getCottageId());
        booking.setUserId(updatedBooking.getUserId());
        booking.setStartDate(updatedBooking.getStartDate());
        booking.setEndDate(updatedBooking.getEndDate());
        return booking;
    }

    public void deleteById(long id) {
        bookingList.removeIf(booking -> booking.getId() == id);
    }

    public List<Booking> getBookingsByCottageId(long cottageId) {
        return bookingList.stream()
                .filter(booking -> booking.getCottageId() == cottageId)
                .collect(Collectors.toList());
    }

    public List<Booking> getBookingsByUserId(long userId) {
        return bookingList.stream()
                .filter(booking -> booking.getUserId() == userId)
                .collect(Collectors.toList());
    }

    public boolean isCottageBooked(long cottageId, LocalDate startDate, LocalDate endDate) {
        return bookingList.stream()
                .filter(booking -> booking.getCottageId() == cottageId)
                .anyMatch(booking -> (startDate.isBefore(booking.getEndDate())
                        && endDate.isAfter(booking.getStartDate())));
    }

    public boolean isUserBookingForSameDates(long userId, LocalDate startDate, LocalDate endDate) {
        return bookingList.stream()
                .filter(booking -> booking.getUserId() == userId)
                .anyMatch(booking ->
                        (startDate.isBefore(booking.getEndDate())
                                && endDate.isAfter(booking.getStartDate())));
    }

    public List<Booking> getBookingsByHotelId(long hotelId) {
        return bookingList.stream()
                .filter(booking -> booking.getCottage().getHotel().getId() == hotelId)
                .collect(Collectors.toList());
    }

}