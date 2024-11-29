package org.example.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hotel {
    private long id;
    private String name;
    private List<Cottage> cottages;
    private List<Amenity> amenities;
}
