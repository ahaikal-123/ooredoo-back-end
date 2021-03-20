package com.oredoo.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oredoo.demo.controllers.model.FranchiseApplicationCreateModel;
import com.oredoo.demo.controllers.model.FranchiseApplicationUpdateModel;
import com.oredoo.demo.service.FranchiseApplicationService;

@RestController
@RequestMapping("/api/admin.v1/franchise")
@Validated
public class FranchiseApplicationController {

	private final FranchiseApplicationService franchiseApplicationService;

	@Autowired
	public FranchiseApplicationController(FranchiseApplicationService franchiseApplicationService) {
		this.franchiseApplicationService = franchiseApplicationService;
	}

	@PostMapping
	public ResponseEntity<?> createFranchiseApplication(@Valid @RequestBody FranchiseApplicationCreateModel franchiseApplicationCreateModel) {
		return new ResponseEntity<>(franchiseApplicationService.createNewFranchiseApplication(franchiseApplicationCreateModel), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getAllFranchiseApplications() {
		List<FranchiseApplicationCreateModel> applicationCreationModelList = franchiseApplicationService.findAllFranchiseApplications();
		return ResponseEntity.status(applicationCreationModelList.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK).body(applicationCreationModelList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getFranchiseApplication(@PathVariable("id") Long id) {
		FranchiseApplicationCreateModel franchiseApplication = franchiseApplicationService.findFranchiseApplication(id);
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(franchiseApplication);
	}

	@PatchMapping("franchiseId/{id}")
	public ResponseEntity<?> updateFranchiseApplication(@PathVariable() Long id,
	                                                    @Valid @RequestBody FranchiseApplicationUpdateModel model) {
		FranchiseApplicationUpdateModel updatedApplicationCreationModel = franchiseApplicationService.updateFranchiseApplication(id, model);
		return ResponseEntity.status(HttpStatus.OK).body(updatedApplicationCreationModel);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFranchiseApplication(@PathVariable Long id) {
		franchiseApplicationService.deleteFranchiseApplication(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
