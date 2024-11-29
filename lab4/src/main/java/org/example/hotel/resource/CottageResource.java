package org.example.hotel.resource;

import lombok.RequiredArgsConstructor;
import org.example.hotel.dto.CottageDTO;
import org.example.hotel.service.CottageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cottage")
public class CottageResource {
    private final CottageService cottageService;

    @GetMapping("/{id}")
    public CottageDTO getCottageById(@PathVariable int id) {
        return cottageService.getCottageById(id);
    }

    @GetMapping
    public List<CottageDTO> getCottages() {
        return cottageService.getCottages();
    }

    @PostMapping
    public CottageDTO createCottage(@RequestBody CottageDTO cottageDTO) {
        return cottageService.createCottage(cottageDTO);
    }

    @PutMapping
    public CottageDTO updateCottage(@RequestBody CottageDTO cottageDTO) {
        return cottageService.updateCottage(cottageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        cottageService.deleteById(id);
    }
}
