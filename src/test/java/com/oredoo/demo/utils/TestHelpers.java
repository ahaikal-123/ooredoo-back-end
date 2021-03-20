package com.oredoo.demo.utils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.mockito.Mockito;
import org.springframework.http.HttpHeaders;

import com.oredoo.demo.controllers.model.FranchiseApplicationCreateModel;
import com.oredoo.demo.repository.FranchiseApplicationRepository;
import com.oredoo.demo.service.FranchiseApplicationService;

public class TestHelpers {
	public TestHelpers() {
		super();
	}
	public static HttpHeaders getHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
		return httpHeaders;
	}
	public static void prepareCreateTest(FranchiseApplicationService franchiseApplicationService,
	                                     FranchiseApplicationRepository franchiseApplicationRepository) {
		String time = "2019-03-27";
		LocalDate localTimeObj = LocalDate.parse(time);
		FranchiseApplicationCreateModel franchiseApplicationCreateModel = new FranchiseApplicationCreateModel(null,
			"App", 123, localTimeObj, "test@test.com", "Description", 0.0, "notes");
		franchiseApplicationCreateModel.setId(1L);
		Mockito.when(franchiseApplicationService.createNewFranchiseApplication(Mockito.any())).thenReturn(franchiseApplicationCreateModel);
	}

	public static FranchiseApplicationCreateModel prepareGetTest(FranchiseApplicationCreateModel franchiseApplicationCreateModel) {
		String time = "2019-03-27";
		LocalDate localTimeObj = LocalDate.parse(time);
		franchiseApplicationCreateModel = new FranchiseApplicationCreateModel(null,
			"App", 123, localTimeObj, "test@test.com", "Description", 0.0, "notes");
		franchiseApplicationCreateModel.setId(1L);
		return franchiseApplicationCreateModel;
	}

	public static List<FranchiseApplicationCreateModel> prepareGetListTest() {
		return Collections.singletonList(prepareGetTest(new FranchiseApplicationCreateModel()));
	}

}
