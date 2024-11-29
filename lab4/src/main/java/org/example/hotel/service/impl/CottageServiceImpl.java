package org.example.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotel.dto.AmenityDTO;
import org.example.hotel.dto.CottageDTO;
import org.example.hotel.entity.Amenity;
import org.example.hotel.entity.Cottage;
import org.example.hotel.repository.AmenityRepository;
import org.example.hotel.repository.CottageRepository;
import org.example.hotel.service.CottageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CottageServiceImpl implements CottageService {
    private final CottageRepository cottageRepository;
    private final AmenityRepository amenityRepository;

    @Override
    public CottageDTO getCottageById(int id) {
        Cottage cottage = cottageRepository.getCottageById(id);
        return CottageDTO.fromCottage(cottage);
    }

    @Override
    public List<CottageDTO> getCottages() {
        return cottageRepository.getCottages().stream()
                .map(CottageDTO::fromCottage)
                .collect(Collectors.toList());
    }

    @Override
    public CottageDTO createCottage(final CottageDTO cottageDTO) {
        final Cottage cottage = new Cottage();
        cottage.setName(cottageDTO.getName());
        cottage.setPrice(cottageDTO.getPrice());
        cottage.setHotel(cottageDTO.getHotel());
        cottage.setCategory(cottageDTO.getCategory());

        int totalAdultGuests = cottageDTO.getMaxAdultGuests();
        int totalChildrenGuests = cottageDTO.getMaxChildrenGuests();
        List<Long> amenityIds = cottageDTO.getAmenities().stream()
                .map(AmenityDTO::getId)
                .collect(Collectors.toList());
        List<Amenity> amenities = amenityRepository.getAmenitiesByIds(amenityIds);

        for (Amenity amenity : amenities) {
            totalAdultGuests += amenity.getAdditionalAdultPlaces();
            totalChildrenGuests += amenity.getAdditionalChildrenPlaces();
        }

        cottage.setMaxAdultGuests(totalAdultGuests);
        cottage.setMaxChildrenGuests(totalChildrenGuests);
        cottage.setAmenities(amenities);

        cottageRepository.save(cottage);
        return CottageDTO.fromCottage(cottage);
    }

    @Override
    public CottageDTO updateCottage(CottageDTO cottageDTO) {
        Cottage cottage = cottageRepository.getCottageById(cottageDTO.getId());
        cottage.setName(cottageDTO.getName());
        cottage.setPrice(cottageDTO.getPrice());
        cottage.setHotel(cottageDTO.getHotel());
        cottage.setCategory(cottageDTO.getCategory());

        int totalAdultGuests = cottageDTO.getMaxAdultGuests();
        int totalChildrenGuests = cottageDTO.getMaxChildrenGuests();
        List<Long> amenityIds = cottageDTO.getAmenities().stream()
                .map(AmenityDTO::getId)
                .collect(Collectors.toList());
        List<Amenity> amenities = amenityRepository.getAmenitiesByIds(amenityIds);

        for (Amenity amenity : amenities) {
            totalAdultGuests += amenity.getAdditionalAdultPlaces();
            totalChildrenGuests += amenity.getAdditionalChildrenPlaces();
        }

        cottage.setMaxAdultGuests(totalAdultGuests);
        cottage.setMaxChildrenGuests(totalChildrenGuests);
        cottage.setAmenities(amenities);

        cottageRepository.save(cottage);
        return CottageDTO.fromCottage(cottage);
    }

    @Override
    public void deleteById(int id) {
        cottageRepository.deleteCottageById(id);
    }
}



