package com.oredoo.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oredoo.demo.controllers.model.FranchiseApplicationCreateModel;
import com.oredoo.demo.controllers.model.FranchiseApplicationUpdateModel;
import com.oredoo.demo.exception.CustomFranchiseException;
import com.oredoo.demo.exception.FranchiseApplicationCreationException;
import com.oredoo.demo.exception.FranchiseApplicationNotFoundException;
import com.oredoo.demo.repository.FranchiseApplicationRepository;
import com.oredoo.demo.service.FranchiseApplicationService;
import com.oredoo.demo.utils.FranchiseModelUtil;

@Service
public class FranchiseApplicationServiceImpl implements FranchiseApplicationService {

	private static final Logger LOG = LoggerFactory.getLogger(FranchiseApplicationServiceImpl.class);

	private final FranchiseApplicationRepository franchiseApplicationRepository;

	@Autowired
	public FranchiseApplicationServiceImpl(FranchiseApplicationRepository franchiseApplicationRepository) {
		this.franchiseApplicationRepository = franchiseApplicationRepository;
	}

	@Override
	public FranchiseApplicationCreateModel createNewFranchiseApplication(FranchiseApplicationCreateModel franchiseApplicationCreateModel) throws CustomFranchiseException {
		try {
			LOG.info("start saving franchise application object...");
			return FranchiseModelUtil.mapCreateModelValues(franchiseApplicationRepository.save(franchiseApplicationCreateModel));
		} catch (Exception e) {
			throw new FranchiseApplicationCreationException("Exception happen when trying to create franchise application");
		}
	}

	@Override
	public List<FranchiseApplicationCreateModel> findAllFranchiseApplications() throws FranchiseApplicationNotFoundException {
		return franchiseApplicationRepository.findAllFranchises().stream().map(FranchiseModelUtil::mapCreateModelValues).collect(Collectors.toList());
	}

	@Override
	public FranchiseApplicationCreateModel findFranchiseApplication(Long id) {
		return FranchiseModelUtil.mapCreateModelValues(franchiseApplicationRepository.findFranchiseById(id).orElseThrow(() -> new FranchiseApplicationNotFoundException("Invalid franchise application id : " + id)));
	}

	@Override
	public FranchiseApplicationUpdateModel updateFranchiseApplication(Long id, FranchiseApplicationUpdateModel franchiseApplicationUpdateModel) {
		if (Boolean.TRUE.equals(franchiseApplicationRepository.franchiseExistById(id))) {
			return FranchiseModelUtil.mapUpdateModelValues(franchiseApplicationRepository.updateFranchiseById(id, franchiseApplicationUpdateModel));
		} else {
			throw new FranchiseApplicationNotFoundException("Invalid franchise application id : " + id);
		}
	}

	@Override
	public void deleteFranchiseApplication(Long id) {
		FranchiseApplicationCreateModel franchiseApplication = findFranchiseApplication(id);
		franchiseApplicationRepository.deleteFranchiseById(franchiseApplication.getId());
	}
}
