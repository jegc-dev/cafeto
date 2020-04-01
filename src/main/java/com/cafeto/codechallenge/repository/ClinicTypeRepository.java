package com.cafeto.codechallenge.repository;

import com.cafeto.codechallenge.model.ClinicType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicTypeRepository extends JpaRepository<ClinicType, Long> {


}
