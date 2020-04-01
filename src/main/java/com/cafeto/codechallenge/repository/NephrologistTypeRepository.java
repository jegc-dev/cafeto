package com.cafeto.codechallenge.repository;

import com.cafeto.codechallenge.model.NephrologistType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface NephrologistTypeRepository extends JpaRepository<NephrologistType, Long> {
        List<NephrologistType> findByNephrologistId(Long nephrologistId);
        Optional<NephrologistType> findByIdAndNephrologistId(Long id, Long nephrologistId);
    }

