package com.oredoo.demo.utils;

import com.oredoo.demo.controllers.model.FranchiseApplicationCreateModel;
import com.oredoo.demo.controllers.model.FranchiseApplicationUpdateModel;
import com.oredoo.demo.domain.FranchiseApplication;

public class FranchiseEntityUtil {

	public static void mapFranchiseApplicationEntity(FranchiseApplicationCreateModel franchiseApplicationCreateModel, FranchiseApplication franchiseApplication) {
		franchiseApplication.setIdNumber(franchiseApplicationCreateModel.getIdNumber());
		franchiseApplication.setAdditionalNotes(franchiseApplicationCreateModel.getAdditionalNotes());
		franchiseApplication.setApplicantsName(franchiseApplicationCreateModel.getApplicantsName());
		franchiseApplication.setBirthDate(franchiseApplicationCreateModel.getBirthDate());
		franchiseApplication.setBrandInterestDescription(franchiseApplicationCreateModel.getBrandInterestDescription());
		franchiseApplication.setContactEmail(franchiseApplicationCreateModel.getContactEmail());
		franchiseApplication.setInvestmentAmount(franchiseApplicationCreateModel.getInvestmentAmount());
	}

	public static FranchiseApplication mapFranchiseApplicationEntity(FranchiseApplicationUpdateModel franchiseApplicationUpdateModel, FranchiseApplication franchiseApplication, Long id) {
		franchiseApplication.setId(id);
		franchiseApplication.setApplicantsName(franchiseApplicationUpdateModel.getApplicantsName());
		franchiseApplication.setBirthDate(franchiseApplicationUpdateModel.getBirthDate());
		franchiseApplication.setBrandInterestDescription(franchiseApplicationUpdateModel.getBrandInterestDescription());
		franchiseApplication.setContactEmail(franchiseApplicationUpdateModel.getContactEmail());
		franchiseApplication.setInvestmentAmount(franchiseApplicationUpdateModel.getInvestmentAmount());
		return franchiseApplication;
	}
}
