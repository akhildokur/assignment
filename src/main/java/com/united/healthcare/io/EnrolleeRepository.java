package com.united.healthcare.io;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.united.healthcare.domain.dto.Enrollee;

@Repository
public interface EnrolleeRepository extends JpaRepository<Enrollee, Long>{
	
	Optional<Enrollee> findById(Long id);
	
}
