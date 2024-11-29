package org.example.hotel.service;

import org.example.hotel.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    HotelDTO getHotelById(long id);

    List<HotelDTO> getHotels();

    HotelDTO createHotel(HotelDTO hotelDTO);

    HotelDTO updateHotel(HotelDTO hotelDTO);

    void deleteById(long id);

    double calculateTotalIncome(long hotelId);

    double calculateTotalExpenses(long hotelId);

    double applyLowSeasonDiscount(double price, int month);
}
