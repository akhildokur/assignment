package com.united.healthcare.io;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.united.healthcare.domain.dto.Dependent;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long>{
	
	Optional<Dependent> findById(Long id);
	
	List<Dependent> findByEnrolleeId(Long id);
	
}
