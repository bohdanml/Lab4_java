package org.example.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotel.entity.Amenity;
import org.example.hotel.entity.Cottage;
import org.example.hotel.entity.Hotel;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private long id;
    private String name;
    private List<CottageDTO> cottages;
    private List<AmenityDTO> amenities;

    public static HotelDTO fromHotel(Hotel hotel) {
        final HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setId(hotel.getId());
        hotelDTO.setName(hotel.getName());
        hotelDTO.setCottages(hotel.getCottages().stream()
                .map(CottageDTO::fromCottage)
                .collect(Collectors.toList()));
        hotelDTO.setAmenities(hotel.getAmenities().stream()
                .map(AmenityDTO::fromAmenity)
                .collect(Collectors.toList()));
        return hotelDTO;
    }

    public static Hotel toHotel(HotelDTO hotelDTO) {
        final Hotel hotel = new Hotel();
        hotel.setId(hotelDTO.getId());
        hotel.setName(hotelDTO.getName());

        List<Cottage> cottages = hotelDTO.getCottages().stream()
                .map(CottageDTO::toCottage)
                .collect(Collectors.toList());
        hotel.setCottages(cottages);

        List<Amenity> amenities = hotelDTO.getAmenities().stream()
                .map(AmenityDTO::toAmenity)
                .collect(Collectors.toList());
        hotel.setAmenities(amenities);

        return hotel;
    }
}
