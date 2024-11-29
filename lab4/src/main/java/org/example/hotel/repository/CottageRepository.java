package org.example.hotel.repository;

import org.example.hotel.entity.Cottage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CottageRepository {
    private List<Cottage> cottageList = new ArrayList<>();
    private static long ID = 1;

    public Cottage getCottageById(long id) {
        return cottageList.stream()
                .filter(cottage -> cottage.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("No such cottage"));
    }

    public List<Cottage> getCottages() {
        return cottageList;
    }

    public Cottage save(Cottage cottage) {
        if (cottage.getId() == 0) {
            cottage.setId(ID);
            cottageList.add(cottage);
            ++ID;
        } else {
            Cottage existingCottage = getCottageById(cottage.getId());
            existingCottage.setName(cottage.getName());
            existingCottage.setPrice(cottage.getPrice());
            existingCottage.setHotel(cottage.getHotel());
            existingCottage.setCategory(cottage.getCategory());
            existingCottage.setMaxAdultGuests(cottage.getMaxAdultGuests());
            existingCottage.setMaxChildrenGuests(cottage.getMaxChildrenGuests());
            existingCottage.setAmenities(cottage.getAmenities());
        }
        return cottage;
    }

    public void deleteCottageById(long id) {
        cottageList.removeIf(cottage -> cottage.getId() == id);
    }
}
