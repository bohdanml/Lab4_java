package org.example.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Amenity {
    private long id;
    private String name;
    private int additionalAdultPlaces;
    private int additionalChildrenPlaces;
    private double cost;
    private TypeOfAmenity typeOfAmenity;
}
