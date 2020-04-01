package com.cafeto.codechallenge.controller;


import com.cafeto.codechallenge.exception.ResourceNotFoundException;
import com.cafeto.codechallenge.model.Nephrologist;
import com.cafeto.codechallenge.model.NephrologistType;
import com.cafeto.codechallenge.repository.NephrologistRepository;
import com.cafeto.codechallenge.repository.NephrologistTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@RestController
@RequestMapping("/api/v1/")
public class NephrologistTypeController {

    @Autowired
    private NephrologistTypeRepository nephrologistTypeRepository;

    @Autowired
    private NephrologistRepository nephrologistRepository;

    //get NephrologistTypes
    @GetMapping("nephrologistTypes")
    public List<NephrologistType> getAllNephrologistTypes(){
        return this.nephrologistTypeRepository.findAll();
    }

    //get NephrologistType by id
    @GetMapping("nephrologistTypes/{id}")
    public ResponseEntity<NephrologistType> getNephrologistTypeById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        NephrologistType nephrologistType = nephrologistTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NephrologistType not found for this id :: " + id));

        return ResponseEntity.ok().body(nephrologistType);

    }

    @GetMapping("/nephrologists/{nephrologistId}/nephrologistTypes")
    public List < NephrologistType > getNephrologistTypesByNephrologist(@PathVariable(value = "postId") Long nephrologistId) {
        return nephrologistTypeRepository.findByNephrologistId(nephrologistId);
    }

    //save NephrologistType
    @PostMapping("/nephrologists/{nephrologistId}/nephrologistTypes")
    public NephrologistType createNephrologistType(@PathVariable(value = "nephrologistsId") Long nephrologistsId,
                               @Valid @RequestBody NephrologistType nephrologistType) throws ResourceNotFoundException {

        return nephrologistRepository.findById(nephrologistsId).map(doctor -> {
                nephrologistType.setNephrologist(doctor);
        return nephrologistTypeRepository.save(nephrologistType);
        }).orElseThrow(() -> new ResourceNotFoundException("instructor not found"));
    }

    @PutMapping("/nephrologists/{nephrologistId}/nephrologistTypes/{nephrologistTypeId}")
    public NephrologistType updateNephrologistType(@PathVariable(value = "nephrologistId") Long nephrologistId,
                               @PathVariable(value = "nephrologistTypeId") Long nephrologistTypeId,
                                                   @Valid @RequestBody NephrologistType nephrologistTypeRequest)
            throws ResourceNotFoundException {
        if (!nephrologistRepository.existsById(nephrologistId)) {
            throw new ResourceNotFoundException("nephrologistId not found");
        }

        return nephrologistTypeRepository.findById(nephrologistTypeId).map(ntype -> {
            ntype.setDescription(nephrologistTypeRequest.getDescription());
        return nephrologistTypeRepository.save(ntype);
        }).orElseThrow(() -> new ResourceNotFoundException("nephrologistType id not found"));
    }

    @DeleteMapping("/nephrologists/{nephrologistId}/nephrologistTypes/{nephrologistTypeId}")
    public ResponseEntity < ? > deleteNephrologistType(@PathVariable(value = "nephrologistId") Long nephrologistId,
                                              @PathVariable(value = "nephrologistTypeId") Long nephrologistTypeId) throws ResourceNotFoundException {
        return nephrologistTypeRepository.findByIdAndNephrologistId(nephrologistTypeId, nephrologistId).map(ntype -> {
                nephrologistTypeRepository.delete(ntype);
        return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "NephrologistType not found with id " + nephrologistTypeId + " and nephrologistId " + nephrologistId));
    }

}
