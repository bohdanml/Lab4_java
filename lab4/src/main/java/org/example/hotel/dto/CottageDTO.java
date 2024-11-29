package org.example.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotel.entity.Amenity;
import org.example.hotel.entity.Category;
import org.example.hotel.entity.Cottage;
import org.example.hotel.entity.Hotel;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CottageDTO {
    private long id;
    private String name;
    private double price;
    private Hotel hotel;
    private Category category;
    private int maxAdultGuests;
    private int maxChildrenGuests;
    private List<AmenityDTO> amenities;

    public static CottageDTO fromCottage(Cottage cottage) {
        final CottageDTO cottageDTO = new CottageDTO();
        cottageDTO.setId(cottage.getId());
        cottageDTO.setName(cottage.getName());
        cottageDTO.setPrice(cottage.getPrice());
        cottageDTO.setHotel(cottage.getHotel());
        cottageDTO.setCategory(cottage.getCategory());
        cottageDTO.setMaxAdultGuests(cottage.getMaxAdultGuests());
        cottageDTO.setMaxChildrenGuests(cottage.getMaxChildrenGuests());
        cottageDTO.setAmenities(cottage.getAmenities().stream()
                .map(AmenityDTO::fromAmenity)
                .collect(Collectors.toList()));
        return cottageDTO;
    }

    public static Cottage toCottage(CottageDTO cottageDTO) {
        final Cottage cottage = new Cottage();
        cottage.setId(cottageDTO.getId());
        cottage.setName(cottageDTO.getName());
        cottage.setPrice(cottageDTO.getPrice());
        cottage.setHotel(cottageDTO.getHotel());
        cottage.setCategory(cottageDTO.getCategory());
        cottage.setMaxAdultGuests(cottageDTO.getMaxAdultGuests());
        cottage.setMaxChildrenGuests(cottageDTO.getMaxChildrenGuests());
        List<Amenity> amenities = cottageDTO.getAmenities().stream()
                .map(amenityDTO -> {
                    Amenity amenity = new Amenity();
                    amenity.setId(amenityDTO.getId());
                    return amenity;
                }).collect(Collectors.toList());
        cottage.setAmenities(amenities);
        return cottage;
    }
}