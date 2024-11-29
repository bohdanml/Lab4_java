package org.example.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cottage {
    private long id;
    private String name;
    private double price;
    private Hotel hotel;
    private Category category;
    private int maxAdultGuests;
    private int maxChildrenGuests;
    private List<Amenity> amenities;
}
