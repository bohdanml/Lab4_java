package org.example.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotel.entity.Amenity;
import org.example.hotel.entity.TypeOfAmenity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmenityDTO {
    private long id;
    private String name;
    private int additionalAdultPlaces;
    private int additionalChildrenPlaces;
    private double cost;
    private TypeOfAmenity typeOfAmenity;

    public static AmenityDTO fromAmenity(Amenity amenity) {
        final AmenityDTO amenityDTO = new AmenityDTO();
        amenityDTO.setId(amenity.getId());
        amenityDTO.setName(amenity.getName());
        amenityDTO.setAdditionalAdultPlaces(amenity.getAdditionalAdultPlaces());
        amenityDTO.setAdditionalChildrenPlaces(amenity.getAdditionalChildrenPlaces());
        amenityDTO.setCost(amenity.getCost());
        amenityDTO.setTypeOfAmenity(amenity.getTypeOfAmenity());
        return amenityDTO;
    }

    public static Amenity toAmenity(AmenityDTO amenityDTO) {
        final Amenity amenity = new Amenity();
        amenity.setId(amenityDTO.getId());
        amenity.setName(amenityDTO.getName());
        amenity.setAdditionalAdultPlaces(amenityDTO.getAdditionalAdultPlaces());
        amenity.setAdditionalChildrenPlaces(amenityDTO.getAdditionalChildrenPlaces());
        amenity.setCost(amenityDTO.getCost());
        amenity.setTypeOfAmenity(amenityDTO.getTypeOfAmenity());
        return amenity;
    }
}