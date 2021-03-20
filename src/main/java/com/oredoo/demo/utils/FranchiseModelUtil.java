package com.oredoo.demo.utils;

import java.util.Optional;

import com.oredoo.demo.controllers.model.FranchiseApplicationCreateModel;
import com.oredoo.demo.controllers.model.FranchiseApplicationUpdateModel;
import com.oredoo.demo.domain.FranchiseApplication;

public class FranchiseModelUtil {

	public static FranchiseApplicationCreateModel mapCreateModelValues(FranchiseApplication entity) {
		return Optional.of(entity).map(franchiseEntity ->
			new FranchiseApplicationCreateModel(
				franchiseEntity.getId(), franchiseEntity.getApplicantsName(), franchiseEntity.getIdNumber(), franchiseEntity.getBirthDate(), franchiseEntity.getContactEmail(),
				franchiseEntity.getBrandInterestDescription(), franchiseEntity.getInvestmentAmount(), franchiseEntity.getAdditionalNotes()
			)
		).orElse(null);
	}

	public static FranchiseApplicationCreateModel mapCreateModelValues1(Optional<FranchiseApplication> entity) {
		return entity.map(franchiseEntity ->
			new FranchiseApplicationCreateModel(
				franchiseEntity.getId(), franchiseEntity.getApplicantsName(), franchiseEntity.getIdNumber(), franchiseEntity.getBirthDate(), franchiseEntity.getContactEmail(),
				franchiseEntity.getBrandInterestDescription(), franchiseEntity.getInvestmentAmount(), franchiseEntity.getAdditionalNotes()
			)
		).orElse(null);
	}

	public static FranchiseApplicationUpdateModel mapUpdateModelValues(FranchiseApplication entity) {
		return Optional.of(entity).map(franchiseEntity ->
			new FranchiseApplicationUpdateModel(
				franchiseEntity.getApplicantsName(), franchiseEntity.getBirthDate(), franchiseEntity.getContactEmail(),
				franchiseEntity.getBrandInterestDescription(), franchiseEntity.getInvestmentAmount()
			)
		).orElse(null);
	}
}
