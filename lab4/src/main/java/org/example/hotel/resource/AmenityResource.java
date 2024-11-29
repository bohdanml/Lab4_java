package org.example.hotel.resource;

import lombok.RequiredArgsConstructor;
import org.example.hotel.dto.AmenityDTO;
import org.example.hotel.service.AmenityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/amenity")
public class AmenityResource {
    private final AmenityService amenityService;

    @GetMapping("/{id}")
    public AmenityDTO getAmenityById(@PathVariable long id) {
        return amenityService.getAmenityById(id);
    }

    @GetMapping
    public List<AmenityDTO> getAmenities() {
        return amenityService.getAmenities();
    }

    @PostMapping
    public AmenityDTO createAmenity(@RequestBody AmenityDTO amenityDTO) {
        return amenityService.createAmenity(amenityDTO);
    }

    @PutMapping
    public AmenityDTO updateAmenity(@RequestBody AmenityDTO amenityDTO) {
        return amenityService.updateAmenity(amenityDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        amenityService.deleteById(id);
    }
}