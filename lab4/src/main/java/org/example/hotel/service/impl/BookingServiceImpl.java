package org.example.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotel.dto.BookingDTO;
import org.example.hotel.entity.Booking;
import org.example.hotel.entity.Cottage;
import org.example.hotel.repository.BookingRepository;
import org.example.hotel.repository.CottageRepository;
import org.example.hotel.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CottageRepository cottageRepository;

    @Override
    public BookingDTO getBookingById(long id) {
        Booking booking = bookingRepository.getBookingById(id);
        return BookingDTO.fromBooking(booking);
    }

    @Override
    public List<BookingDTO> getBookings() {
        return bookingRepository.getBookings().stream()
                .map(BookingDTO::fromBooking)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO createBooking(final BookingDTO bookingDTO) {
        if (isCottageBooked(bookingDTO.getCottageId(), bookingDTO.getStartDate(), bookingDTO.getEndDate())) {
            throw new RuntimeException("Cottage is already booked for the selected dates by another user.");
        }
        if (isUserBookingForSameDates(bookingDTO.getUserId(),
                bookingDTO.getStartDate(), bookingDTO.getEndDate())) {
            throw new RuntimeException("User already has a booking for the selected dates.");
        }
        final Booking booking = BookingDTO.toBooking(bookingDTO);
        Cottage cottage = cottageRepository.getCottageById(bookingDTO.getCottageId());
        booking.setCottage(cottage);
        bookingRepository.save(booking);
        return BookingDTO.fromBooking(booking);
    }

    @Override
    public BookingDTO updateBooking(BookingDTO bookingDTO) {
        Booking booking = bookingRepository.getBookingById(bookingDTO.getId());
        Cottage cottage = cottageRepository.getCottageById(bookingDTO.getCottageId());
        booking.setCottage(cottage);
        if (isCottageBooked(booking.getCottageId(), bookingDTO.getStartDate(), bookingDTO.getEndDate())) {
            throw new RuntimeException("Cottage is already " +
                    "booked for the selected dates by another user.");
        }
        if (isUserBookingForSameDates(bookingDTO.getUserId(), bookingDTO.getStartDate(),
                bookingDTO.getEndDate())) {
            throw new RuntimeException("User already has a booking for the selected dates.");
        }
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());
        bookingRepository.save(booking);
        return BookingDTO.fromBooking(booking);
    }

    @Override
    public void deleteById(long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public boolean isCottageBooked(long cottageId, LocalDate startDate, LocalDate endDate) {
        return bookingRepository.isCottageBooked(cottageId, startDate, endDate);
    }

    public boolean isUserBookingForSameDates(long userId, LocalDate startDate, LocalDate endDate) {
        return bookingRepository.isUserBookingForSameDates(userId, startDate, endDate);
    }

    @Override
    public List<LocalDate> getAvailableDates(long cottageId, LocalDate startDate, LocalDate endDate) {
        List<Booking> bookings = bookingRepository.getBookingsByCottageId(cottageId);
        List<LocalDate> unavailableDates = bookings.stream()
                .flatMap(booking -> booking.getStartDate().datesUntil(booking.getEndDate()))
                .collect(Collectors.toList());
        return startDate.datesUntil(endDate)
                .filter(date -> !unavailableDates.contains(date))
                .collect(Collectors.toList());
    }
}


