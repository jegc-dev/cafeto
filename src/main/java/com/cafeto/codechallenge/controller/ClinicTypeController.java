package com.cafeto.codechallenge.controller;

import com.cafeto.codechallenge.exception.ResourceNotFoundException;
import com.cafeto.codechallenge.model.ClinicType;
import com.cafeto.codechallenge.repository.ClinicTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ClinicTypeController {

    @Autowired
    private ClinicTypeRepository clinicTypeRepository;

    //get ClinicTypes
    @GetMapping("clinicTypes")
    public List<ClinicType> getAllClinicTypes(){
        return this.clinicTypeRepository.findAll();
    }

    //get ClinicType by id
    @GetMapping("clinicTypes/{id}")
    public ResponseEntity<ClinicType> getClinicTypeById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        ClinicType clinicType = clinicTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClinicType not found for this id :: " + id));

        return ResponseEntity.ok().body(clinicType);

    }
    //save ClinicType
    @PostMapping("clinicTypes")
    public ClinicType createClinicType(@RequestBody ClinicType clinicType){

        return this.clinicTypeRepository.save(clinicType);
    }

    //update ClinicType
    @PutMapping("clinicTypes/{id}")
    public ResponseEntity<ClinicType> updateClinicType(@PathVariable(value = "id") long id,
                                                                   @Valid @RequestBody ClinicType clinicTypeDetails) throws ResourceNotFoundException {
        ClinicType clinicType = clinicTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClinicType not found for this id :: " + id));

        clinicTypeDetails.setName(clinicTypeDetails.getName());

        return ResponseEntity.ok(this.clinicTypeRepository.save(clinicType));
    }

    //delete ClinicType
    @DeleteMapping("clinicTypes/{id}")
    public Map<String, Boolean> deleteClinicType(@PathVariable(value = "id") long id,
                                                       @Valid @RequestBody ClinicType clinicTypeDetails) throws ResourceNotFoundException {
        ClinicType clinicType = clinicTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClinicType not found for this id :: " + id));


        this.clinicTypeRepository.delete(clinicType);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;
    }
    
}
