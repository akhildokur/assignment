package com.united.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.united.healthcare.domain.request.EnrolleeRequest;
import com.united.healthcare.domain.response.EnrolleeResponse;
import com.united.healthcare.service.EnrolleeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "Enrollee APIs", tags = "EnrolleeResource")
public class EnrolleeResource {

	@Autowired
	private EnrolleeService enrolleeService;
	
	@PostMapping("/enrollee/create")
	@ApiOperation(value = "This API adds a new enrollee record.")
	public ResponseEntity<Object> addNewEnrollee(@RequestBody EnrolleeRequest enrolleeRequest){
		return enrolleeService.addEnrollee(enrolleeRequest);
	}
	
	@DeleteMapping("/enrollee/delete/{id}")
	public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
		return enrolleeService.deleteEnrolleeRecord(id);
	}
	
	@PutMapping("/enrollee/update")
	public ResponseEntity<Object> updateEnrolleeRecord(@RequestBody EnrolleeRequest enrolleeRequest){
		return enrolleeService.updateEnrolleeRecord(enrolleeRequest);
	}
	
	@GetMapping("/enrollee/findbyid/{id}")
	public ResponseEntity<EnrolleeResponse> findbyid(@PathVariable Long id){
		return enrolleeService.findById(id);
	}
	
}
