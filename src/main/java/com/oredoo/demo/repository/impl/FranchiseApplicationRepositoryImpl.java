package com.oredoo.demo.repository.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oredoo.demo.controllers.model.FranchiseApplicationCreateModel;
import com.oredoo.demo.controllers.model.FranchiseApplicationUpdateModel;
import com.oredoo.demo.domain.FranchiseApplication;
import com.oredoo.demo.repository.FranchiseApplicationDaoRepository;
import com.oredoo.demo.repository.FranchiseApplicationRepository;
import com.oredoo.demo.utils.FranchiseEntityUtil;

@Repository
public class FranchiseApplicationRepositoryImpl implements FranchiseApplicationRepository {

	private static final Logger LOG = LoggerFactory.getLogger(FranchiseApplicationRepositoryImpl.class);

	private final FranchiseApplicationDaoRepository franchiseApplicationDaoRepository;

	@Autowired
	public FranchiseApplicationRepositoryImpl(FranchiseApplicationDaoRepository franchiseApplicationDaoRepository) {
		this.franchiseApplicationDaoRepository = franchiseApplicationDaoRepository;
	}

	@Override
	public FranchiseApplication save(FranchiseApplicationCreateModel franchiseApplicationCreateModel) {
		FranchiseApplication franchiseApplication = new FranchiseApplication();
		FranchiseEntityUtil.mapFranchiseApplicationEntity(franchiseApplicationCreateModel, franchiseApplication);
		LOG.info("saving franchise application object...");
		return franchiseApplicationDaoRepository.save(franchiseApplication);
	}

	@Override
	public FranchiseApplication updateFranchiseById(Long id, FranchiseApplicationUpdateModel franchiseApplicationUpdateModel) {
		FranchiseApplication franchiseApplication = new FranchiseApplication();
		franchiseApplication = FranchiseEntityUtil.mapFranchiseApplicationEntity(franchiseApplicationUpdateModel, franchiseApplication, id);
		LOG.info("updating franchise application object...");
		return franchiseApplicationDaoRepository.save(franchiseApplication);
	}

	@Override
	public Optional<FranchiseApplication> findFranchiseById(Long id) {
		return franchiseApplicationDaoRepository.findById(id);
	}

	@Override
	public List<FranchiseApplication> findAllFranchises() {
		return franchiseApplicationDaoRepository.findAll();
	}

	@Override
	public void deleteFranchiseById(Long id) {
		franchiseApplicationDaoRepository.deleteById(id);
	}

	@Override
	public Boolean franchiseExistById(Long id) {
		return franchiseApplicationDaoRepository.existsById(id);
	}
}
