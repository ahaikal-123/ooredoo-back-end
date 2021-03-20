package com.oredoo.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.oredoo.demo.domain.FranchiseApplication;

public interface FranchiseApplicationDaoRepository extends JpaRepository<FranchiseApplication, Long> {
}
