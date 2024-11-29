package org.example.hotel.service;

import org.example.hotel.dto.AmenityDTO;

import java.util.List;

public interface AmenityService {
    AmenityDTO getAmenityById(long id);

    List<AmenityDTO> getAmenities();

    AmenityDTO createAmenity(AmenityDTO amenityDTO);

    AmenityDTO updateAmenity(AmenityDTO amenityDTO);

    void deleteById(long id);
}
