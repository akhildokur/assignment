package com.united.healthcare.service;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.united.healthcare.domain.dto.Enrollee;
import com.united.healthcare.domain.request.EnrolleeRequest;
import com.united.healthcare.domain.response.EnrolleeResponse;
import com.united.healthcare.io.DependentRepository;
import com.united.healthcare.io.EnrolleeRepository;

@Service
public class EnrolleeService {

	@Autowired
	private EnrolleeRepository enrolleeRepository;
	
	@Autowired
	private DependentRepository dependentRepository;

	public ResponseEntity<Object> addEnrollee(EnrolleeRequest enrolleeRequest) {

		if (StringUtils.isBlank(enrolleeRequest.getDateOfBirth())
				|| StringUtils.isAllBlank(enrolleeRequest.getEnrolleeName())) {
			return ResponseEntity.unprocessableEntity()
					.body("Date of Birth and Name cannot be null. Please submit the request again.");
		}

		Enrollee enrollee = new Enrollee();
		enrollee.setBirthday(enrolleeRequest.getDateOfBirth());
		enrollee.setName(enrolleeRequest.getEnrolleeName());
		enrollee.setPhoneNumber(
				StringUtils.isEmpty(enrolleeRequest.getPhoneNumber()) ? null : enrolleeRequest.getPhoneNumber());
		enrollee.setStatus(enrolleeRequest.isActivationStatus());

		Enrollee savedEnrollee = enrolleeRepository.save(enrollee);

		if (enrolleeRepository.findById(savedEnrollee.getId()).isPresent()) {
			return ResponseEntity.accepted().body(
					"Successfully Created Enrollee record. If you want to add any dependents, please feel free to use dependent resource, thanks.");
		} else {
			return ResponseEntity.unprocessableEntity().body("Failed to Create specified enrollee record.");
		}

	}

	public ResponseEntity<Object> deleteEnrolleeRecord(Long id) {

		if (enrolleeRepository.findById(id).isPresent()) {
			enrolleeRepository.deleteById(id);
			if (enrolleeRepository.findById(id).isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record.");
			} else {
				return ResponseEntity.ok().body("Successfully deleted specified record.");
			}
		} else {
			return ResponseEntity.unprocessableEntity().body("No Records Found.");
		}

	}

	public ResponseEntity<Object> updateEnrolleeRecord(EnrolleeRequest enrolleeRequest) {
		
		Optional<Enrollee> optionalEnrollee = enrolleeRepository.findById(enrolleeRequest.getId());
		
		if (optionalEnrollee.isPresent()) {
			Enrollee enrollee = optionalEnrollee.get();
			if(StringUtils.isNotBlank(enrolleeRequest.getDateOfBirth())) enrollee.setBirthday(enrolleeRequest.getDateOfBirth());
			if(StringUtils.isNotBlank(enrolleeRequest.getEnrolleeName())) enrollee.setName(enrolleeRequest.getEnrolleeName());
			if(StringUtils.isNotBlank(enrolleeRequest.getPhoneNumber())) enrollee.setPhoneNumber(enrolleeRequest.getPhoneNumber());	
			enrollee.setStatus(enrolleeRequest.isActivationStatus());
			enrolleeRepository.save(enrollee);
			if (!enrolleeRepository.findById(enrolleeRequest.getId()).isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to update the specified record.");
			} else {
				return ResponseEntity.ok().body("Successfully updated specified record.");
			}
		} else
			return ResponseEntity.unprocessableEntity().body("No Records Found.");
		
	}

	public ResponseEntity<EnrolleeResponse> findById(Long id) {

		Optional<Enrollee> optionalEnrollee = enrolleeRepository.findById(id);
		EnrolleeResponse response = new EnrolleeResponse();
		if (optionalEnrollee.isPresent()) {
			Enrollee enrollee = optionalEnrollee.get();			
			response.setActivationStatus(enrollee.isStatus());
			response.setDateOfBirth(enrollee.getBirthday());
			response.setEnrolleeName(enrollee.getName());
			response.setPhoneNumber(enrollee.getPhoneNumber());
			response.setId(enrollee.getId());
			response.setDependents(dependentRepository.findByEnrolleeId(id));			
			return new ResponseEntity<EnrolleeResponse>(response, HttpStatus.OK);
		} else
			return new ResponseEntity<EnrolleeResponse>(HttpStatus.NOT_FOUND);	
		
	}

}
