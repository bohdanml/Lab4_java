package org.example.hotel.repository;

import org.example.hotel.entity.Hotel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelRepository {
    private List<Hotel> hotelList = new ArrayList<>();
    private static long ID = 1;

    public Hotel getHotelById(long id) {
        return hotelList.stream()
                .filter(hotel -> hotel.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("No such hotel"));
    }

    public List<Hotel> getHotels() {
        return hotelList;
    }

    public Hotel save(Hotel hotel) {
        if (hotel.getId() == 0) {
            hotel.setId(ID);
            hotelList.add(hotel);
            ++ID;
        } else {
            updateHotel(hotel);
        }
        return hotel;
    }

    public Hotel updateHotel(Hotel updatedHotel) {
        Hotel hotel = hotelList.stream()
                .filter(h -> h.getId() == updatedHotel.getId())
                .findAny()
                .orElseThrow(() -> new RuntimeException("No such hotel"));
        hotel.setName(updatedHotel.getName());
        hotel.setCottages(updatedHotel.getCottages());
        hotel.setAmenities(updatedHotel.getAmenities());
        return hotel;
    }

    public void deleteHotelById(long id) {
        hotelList.removeIf(hotel -> hotel.getId() == id);
    }
}

