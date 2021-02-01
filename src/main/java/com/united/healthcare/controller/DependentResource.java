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

import com.united.healthcare.domain.request.DependentRequest;
import com.united.healthcare.domain.request.EnrolleeRequest;
import com.united.healthcare.domain.response.EnrolleeResponse;
import com.united.healthcare.service.DependentService;

@RestController
public class DependentResource {

	@Autowired
	private DependentService dependentService;
	
	@PostMapping("/dependent/create")
	public ResponseEntity<Object> addNewDependent(@RequestBody DependentRequest enrolleeRequest){
		return dependentService.addDependent(enrolleeRequest);
	}
	
	@DeleteMapping("/dependent/delete/{id}")
	public ResponseEntity<Object> deleteDependent(@PathVariable Long id) {
		return dependentService.deleteDependentRecord(id);
	}
	
	@PutMapping("/dependent/update")
	public ResponseEntity<Object> updateDependentRecord(@RequestBody DependentRequest enrolleeRequest){
		return dependentService.updateDependentRecord(enrolleeRequest);
	}
	
}
