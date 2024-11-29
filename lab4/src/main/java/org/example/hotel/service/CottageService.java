package org.example.hotel.service;

import org.example.hotel.dto.CottageDTO;

import java.util.List;

public interface CottageService {

    CottageDTO getCottageById(int id);

    List<CottageDTO> getCottages();

    CottageDTO createCottage(CottageDTO cottageDTO);

    CottageDTO updateCottage(CottageDTO cottageDTO);

    void deleteById(int id);

}
