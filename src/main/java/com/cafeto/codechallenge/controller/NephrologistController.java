package com.cafeto.codechallenge.controller;

import com.cafeto.codechallenge.exception.ResourceNotFoundException;
import com.cafeto.codechallenge.model.Nephrologist;
import com.cafeto.codechallenge.repository.NephrologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class NephrologistController {

    @Autowired
    private NephrologistRepository nephrologistRepository;

    //get Nephrologists
    @GetMapping("nephrologists")
    public List<Nephrologist> getAllNephrologists() {
        return this.nephrologistRepository.findAll();
    }

    //get Nephrologists by id
    @GetMapping("nephrologists/{id}")
    public ResponseEntity<Nephrologist> getNephrologistById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Nephrologist nephrologist = nephrologistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nephrologist not found for this id :: " + id));

        return ResponseEntity.ok().body(nephrologist);

    }

    // save nephrologists
    @PostMapping("nephrologists")
    public Nephrologist createNephrologist(@RequestBody Nephrologist nephrologist) {
        return this.nephrologistRepository.save(nephrologist);

    }

    // update nephrologists
    @PutMapping("nephrologists/{id}")
    public ResponseEntity<Nephrologist> updateNephrologist(@PathVariable(value = "id") long id,
                                                           @Valid @RequestBody Nephrologist nephrologistDetails) throws ResourceNotFoundException {
        Nephrologist nephrologist = nephrologistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nephrologist not found for this id :: " + id));

        nephrologist.setName(nephrologistDetails.getName());
        nephrologist.setEmail(nephrologistDetails.getEmail());
        nephrologist.setActive(nephrologistDetails.getActive());

        final Nephrologist updatedNephrologist = nephrologistRepository.save(nephrologist);

        return ResponseEntity.ok(this.nephrologistRepository.save(updatedNephrologist));
    }

    // delete nephrologists
    @DeleteMapping("nephrologists/{id}")
    public Map<String, Boolean> deleteNephrologist(@PathVariable(value = "id") long id,
                                                   @Valid @RequestBody Nephrologist nephrologistDetails) throws ResourceNotFoundException {
        Nephrologist nephrologist = nephrologistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nephrologist not found for this id :: " + id));

        this.nephrologistRepository.delete(nephrologist);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;
    }
}
