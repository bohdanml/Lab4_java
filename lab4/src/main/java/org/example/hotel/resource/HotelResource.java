package org.example.hotel.resource;

import lombok.RequiredArgsConstructor;
import org.example.hotel.dto.HotelDTO;
import org.example.hotel.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotel")
public class HotelResource {
    private final HotelService hotelService;

    @GetMapping("/{id}")
    public HotelDTO getHotelById(@PathVariable long id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping
    public List<HotelDTO> getHotels() {
        return hotelService.getHotels();
    }

    @PostMapping
    public HotelDTO createHotel(@RequestBody HotelDTO hotelDTO) {
        return hotelService.createHotel(hotelDTO);
    }

    @PutMapping
    public HotelDTO updateHotel(@RequestBody HotelDTO hotelDTO) {
        return hotelService.updateHotel(hotelDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        hotelService.deleteById(id);
    }

    @GetMapping("/{id}/income")
    public double getTotalIncome(@PathVariable long id) {
        return hotelService.calculateTotalIncome(id);
    }

    @GetMapping("/{id}/expenses")
    public double getTotalExpenses(@PathVariable long id) {
        return hotelService.calculateTotalExpenses(id);
    }
}
