package org.example.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotel.dto.AmenityDTO;
import org.example.hotel.entity.Amenity;
import org.example.hotel.repository.AmenityRepository;
import org.example.hotel.service.AmenityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AmenityServiceImpl implements AmenityService {
    private final AmenityRepository amenityRepository;

    @Override
    public AmenityDTO getAmenityById(long id) {
        Amenity amenity = amenityRepository.getAmenityById(id);
        return AmenityDTO.fromAmenity(amenity);
    }

    @Override
    public List<AmenityDTO> getAmenities() {
        return amenityRepository.getAmenity().stream()
                .map(AmenityDTO::fromAmenity)
                .collect(Collectors.toList());
    }

    @Override
    public AmenityDTO createAmenity(final AmenityDTO amenityDTO) {
        final Amenity amenity = new Amenity();
        amenity.setName(amenityDTO.getName());
        amenity.setAdditionalAdultPlaces(amenityDTO.getAdditionalAdultPlaces());
        amenity.setAdditionalChildrenPlaces(amenityDTO.getAdditionalChildrenPlaces());
        amenity.setCost(amenityDTO.getCost());
        amenity.setTypeOfAmenity(amenityDTO.getTypeOfAmenity());
        amenityRepository.save(amenity);
        return AmenityDTO.fromAmenity(amenity);
    }

    @Override
    public AmenityDTO updateAmenity(AmenityDTO amenityDTO) {
        Amenity amenity = amenityRepository.getAmenityById(amenityDTO.getId());
        amenity.setName(amenityDTO.getName());
        amenity.setAdditionalAdultPlaces(amenityDTO.getAdditionalAdultPlaces());
        amenity.setAdditionalChildrenPlaces(amenityDTO.getAdditionalChildrenPlaces());
        amenity.setCost(amenityDTO.getCost());
        amenity.setTypeOfAmenity(amenityDTO.getTypeOfAmenity());
        amenityRepository.save(amenity);
        return AmenityDTO.fromAmenity(amenity);
    }

    @Override
    public void deleteById(long id) {
        amenityRepository.deleteAmenityById(id);
    }
}