package com.cafeto.codechallenge.repository;

import com.cafeto.codechallenge.model.Nephrologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NephrologistRepository extends JpaRepository<Nephrologist, Long> {

}
