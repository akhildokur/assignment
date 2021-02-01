package com.united.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.united.healthcare.domain.dto.Dependent;
import com.united.healthcare.domain.request.DependentRequest;
import com.united.healthcare.domain.response.EnrolleeResponse;
import com.united.healthcare.io.DependentRepository;

@Service
public class DependentService {

	@Autowired
	private DependentRepository dependentRepository;

	public ResponseEntity<Object> addDependent(DependentRequest dependentRequest) {

		if (StringUtils.isBlank(dependentRequest.getDateOfBirth())
				|| StringUtils.isAllBlank(dependentRequest.getEnrolleeName())) {
			return ResponseEntity.unprocessableEntity()
					.body("Date of Birth and Name cannot be null. Please submit the request again.");
		}

		Dependent dependent = new Dependent();
		dependent.setBirthday(dependentRequest.getDateOfBirth());
		dependent.setName(dependentRequest.getEnrolleeName());
		dependent.setEnrolleeId(dependentRequest.getEnrolleeId());
		
		Dependent savedDependent = dependentRepository.save(dependent);
		if (dependentRepository.findById(savedDependent.getId()).isPresent()) {
			return ResponseEntity.accepted().body(
					"Successfully Created Dependent record.");
		} else {
			return ResponseEntity.unprocessableEntity().body("Failed to Create specified enrollee record.");
		}

	}

	public ResponseEntity<Object> deleteDependentRecord(Long id) {

		if (dependentRepository.findById(id).isPresent()) {
			dependentRepository.deleteById(id);
			if (dependentRepository.findById(id).isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record.");
			} else {
				return ResponseEntity.ok().body("Successfully deleted specified record.");
			}
		} else {
			return ResponseEntity.unprocessableEntity().body("No Records Found.");
		}

	}

	public ResponseEntity<Object> updateDependentRecord(DependentRequest dependentRequest) {
		
		Optional<Dependent> optionalDependent = dependentRepository.findById(dependentRequest.getId());
		
		if (optionalDependent.isPresent()) {
			Dependent dependent = optionalDependent.get();
			if(StringUtils.isNotBlank(dependentRequest.getDateOfBirth())) dependent.setBirthday(dependentRequest.getDateOfBirth());
			if(StringUtils.isNotBlank(dependentRequest.getEnrolleeName())) dependent.setName(dependentRequest.getEnrolleeName());	
			dependentRepository.save(dependent);
			if (!dependentRepository.findById(dependentRequest.getId()).isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to update the specified record.");
			} else {
				return ResponseEntity.ok().body("Successfully updated specified record.");
			}
		} else
			return ResponseEntity.unprocessableEntity().body("No Records Found.");		
	}

}
