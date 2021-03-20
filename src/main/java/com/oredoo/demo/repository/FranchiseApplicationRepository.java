package com.oredoo.demo.repository;

import java.util.List;
import java.util.Optional;

import com.oredoo.demo.controllers.model.FranchiseApplicationCreateModel;
import com.oredoo.demo.controllers.model.FranchiseApplicationUpdateModel;
import com.oredoo.demo.domain.FranchiseApplication;

public interface FranchiseApplicationRepository {

	FranchiseApplication save(FranchiseApplicationCreateModel franchiseApplication);

	FranchiseApplication updateFranchiseById(Long id, FranchiseApplicationUpdateModel franchiseApplication);

	Optional<FranchiseApplication> findFranchiseById(Long id);

	List<FranchiseApplication> findAllFranchises();

	void deleteFranchiseById(Long id);

	Boolean franchiseExistById(Long id);

}
