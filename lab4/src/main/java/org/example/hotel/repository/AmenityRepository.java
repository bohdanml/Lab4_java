package org.example.hotel.repository;

import org.example.hotel.entity.Amenity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AmenityRepository {
    private List<Amenity> dtoList = new ArrayList<>();
    private static long ID = 1;

    public Amenity getAmenityById(long id) {
        return dtoList.stream()
                .filter(dto -> dto.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("No such amenity"));
    }

    public List<Amenity> getAmenitiesByIds(List<Long> ids) {
        return dtoList.stream()
                .filter(dto -> ids.contains(dto.getId()))
                .collect(Collectors.toList());
    }

    public List<Amenity> getAmenity() {
        return dtoList;
    }

    public Amenity save(Amenity amenity) {
        if (amenity.getId() == 0) {
            amenity.setId(ID);
            dtoList.add(amenity);
            ++ID;
        } else {
            Amenity existingAmenity = getAmenityById(amenity.getId());
            existingAmenity.setName(amenity.getName());
            existingAmenity.setAdditionalAdultPlaces(amenity.getAdditionalAdultPlaces());
            existingAmenity.setAdditionalChildrenPlaces(amenity.getAdditionalChildrenPlaces());
            existingAmenity.setCost(amenity.getCost());
            existingAmenity.setTypeOfAmenity(amenity.getTypeOfAmenity());
        }
        return amenity;
    }

    public void deleteAmenityById(long id) {
        dtoList.removeIf(dto -> dto.getId() == id);
    }
}

