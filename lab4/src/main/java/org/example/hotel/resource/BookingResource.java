package org.example.hotel.resource;

import lombok.RequiredArgsConstructor;
import org.example.hotel.dto.BookingDTO;
import org.example.hotel.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booking")
public class BookingResource {
    private final BookingService bookingService;

    @GetMapping("/{id}")
    public BookingDTO getBookingById(@PathVariable long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping
    public List<BookingDTO> getBookings() {
        return bookingService.getBookings();
    }

    @PostMapping
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.createBooking(bookingDTO);
    }

    @PutMapping
    public BookingDTO updateBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.updateBooking(bookingDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        bookingService.deleteById(id);
    }

    @GetMapping("/available-dates")
    public List<LocalDate> getAvailableDates(@RequestParam long cottageId, @RequestParam String startDate, @RequestParam String endDate) {
        return bookingService.getAvailableDates(cottageId,
                LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}
