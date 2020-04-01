package com.cafeto.codechallenge.controller;

import com.cafeto.codechallenge.exception.ResourceNotFoundException;
import com.cafeto.codechallenge.model.Zone;
import com.cafeto.codechallenge.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ZoneController {

    @Autowired
    private ZoneRepository zoneRepository;

    //get Zones
    @GetMapping("zones")
    public List<Zone> getAllZones(){
        return this.zoneRepository.findAll();
    }

    //get Zone by id
    @GetMapping("zones/{id}")
    public ResponseEntity<Zone> getZoneById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Zone zone = zoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zone not found for this id :: " + id));

        return ResponseEntity.ok().body(zone);

    }
    //save Zone
    @PostMapping("zones")
    public Zone createZone(@RequestBody Zone zone){

        return this.zoneRepository.save(zone);
    }

    //update Zone
    @PutMapping("zones/{id}")
    public ResponseEntity<Zone> updateZone(@PathVariable(value = "id") long id,
                                           @Valid @RequestBody Zone zoneDetails) throws ResourceNotFoundException {
        Zone zone = zoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zone not found for this id :: " + id));

        zoneDetails.setDescription(zoneDetails.getDescription());

        return ResponseEntity.ok(this.zoneRepository.save(zone));
    }

    //delete Zone
    @DeleteMapping("zones/{id}")
    public Map<String, Boolean> deleteZone(@PathVariable(value = "id") long id,
                                           @Valid @RequestBody Zone zoneDetails) throws ResourceNotFoundException {
        Zone zone = zoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zone not found for this id :: " + id));


        this.zoneRepository.delete(zone);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;
    }

}
