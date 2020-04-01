package com.cafeto.codechallenge.controller;

import com.cafeto.codechallenge.exception.ResourceNotFoundException;
import com.cafeto.codechallenge.model.City;
import com.cafeto.codechallenge.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    //get Cities
    @GetMapping("cities")
    public List<City> getAllCities(){
        return this.cityRepository.findAll();
    }

    //get City by id
    @GetMapping("cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        City city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found for this id :: " + id));

        return ResponseEntity.ok().body(city);

    }
    //save City
    @PostMapping("cities")
    public City createCity(@RequestBody City city){

        return this.cityRepository.save(city);
    }

    //update City
    @PutMapping("cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable(value = "id") long id,
                                                       @Valid @RequestBody City cityDetails) throws ResourceNotFoundException {
        City city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found for this id :: " + id));

        cityDetails.setDescription(cityDetails.getDescription());

        return ResponseEntity.ok(this.cityRepository.save(city));
    }

    //delete City
    @DeleteMapping("cities/{id}")
    public Map<String, Boolean> deleteCity(@PathVariable(value = "id") long id,
                                                 @Valid @RequestBody City cityDetails) throws ResourceNotFoundException {
        City city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found for this id :: " + id));


        this.cityRepository.delete(city);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;
    }

}
