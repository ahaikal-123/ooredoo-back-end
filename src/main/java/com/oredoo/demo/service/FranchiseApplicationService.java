package com.oredoo.demo.service;

import java.util.List;

import com.oredoo.demo.controllers.model.FranchiseApplicationCreateModel;
import com.oredoo.demo.controllers.model.FranchiseApplicationUpdateModel;
import com.oredoo.demo.exception.CustomFranchiseException;

public interface FranchiseApplicationService {
	FranchiseApplicationCreateModel createNewFranchiseApplication(FranchiseApplicationCreateModel franchiseApplicationCreateModel) throws CustomFranchiseException;

	List<FranchiseApplicationCreateModel> findAllFranchiseApplications() throws CustomFranchiseException;

	FranchiseApplicationCreateModel findFranchiseApplication(Long id);

	FranchiseApplicationUpdateModel updateFranchiseApplication(Long id, FranchiseApplicationUpdateModel model);

	void deleteFranchiseApplication(Long id);
}
