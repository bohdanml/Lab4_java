package org.example.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private long id;
    private long cottageId;
    private long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Cottage cottage;
}
