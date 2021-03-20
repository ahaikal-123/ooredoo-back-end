package com.oredoo.demo.controllers;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.oredoo.demo.controllers.model.FranchiseApplicationCreateModel;
import com.oredoo.demo.exception.FranchiseApplicationNotFoundException;
import com.oredoo.demo.repository.FranchiseApplicationRepository;
import com.oredoo.demo.repository.impl.FranchiseApplicationRepositoryImpl;
import com.oredoo.demo.service.FranchiseApplicationService;
import com.oredoo.demo.utils.TestHelpers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FranchiseApplicationController.class)
class FranchiseApplicationControllerTest {

	private FranchiseApplicationRepository franchiseRepository = mock(FranchiseApplicationRepositoryImpl.class);

	@MockBean
	private FranchiseApplicationService franchiseService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach()
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void testGetById() throws Exception {
		String response = "{\"id\":1,\"applicantsName\":\"App\",\"idNumber\":123,\"birthDate\":[2019,3,27],\"contactEmail\":\"test@test.com\",\"brandInterestDescription\":\"Description\",\"investmentAmount\":0.0,\"additionalNotes\":\"notes\"}";
		FranchiseApplicationCreateModel franchiseApplicationCreateModel = null;
		franchiseApplicationCreateModel = TestHelpers.prepareGetTest(franchiseApplicationCreateModel);
		franchiseApplicationCreateModel.setId(1L);
		Mockito.when(franchiseService.findFranchiseApplication(franchiseApplicationCreateModel.getId())).thenReturn(franchiseApplicationCreateModel);
		this.mockMvc.perform(get("/api/admin.v1/franchise/1")
			.accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString(response)));
	}

	@Test
	void testGetWithWrongId() throws Exception {
		Mockito.when(franchiseService.findFranchiseApplication(4L)).thenThrow(FranchiseApplicationNotFoundException.class);
		this.mockMvc.perform(get("/api/admin.v1/franchise/4")
			.accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isNotFound());
	}

	@Test
	void testGetAll() throws Exception {
		String response = "[{\"id\":1,\"applicantsName\":\"App\",\"idNumber\":123,\"birthDate\":[2019,3,27],\"contactEmail\":\"test@test.com\",\"brandInterestDescription\":\"Description\",\"investmentAmount\":0.0,\"additionalNotes\":\"notes\"}]";
		List<FranchiseApplicationCreateModel> franchiseApplicationCreateModels;
		franchiseApplicationCreateModels = TestHelpers.prepareGetListTest();
		Mockito.when(franchiseService.findAllFranchiseApplications()).thenReturn(franchiseApplicationCreateModels);
		this.mockMvc.perform(get("/api/admin.v1/franchise")
			.accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString(response)));
	}

	@Test
	void whenTryingToSaveFranchise_shouldBeSavedCorrectly() throws Exception {
		TestHelpers.prepareCreateTest(franchiseService, franchiseRepository);
		String request = "{\"applicantsName\":\"App\",\"idNumber\":123,\"birthDate\":\"2019-03-27\",\"contactEmail\":\"test@test.com\",\"brandInterestDescription\":\"Description\",\"additionalNotes\":\"notes\"}";
		String response = "{\"id\":1,\"applicantsName\":\"App\",\"idNumber\":123,\"birthDate\":[2019,3,27],\"contactEmail\":\"test@test.com\",\"brandInterestDescription\":\"Description\",\"investmentAmount\":0.0,\"additionalNotes\":\"notes\"}";
		mockMvc.perform(post("/api/admin.v1/franchise").content(request).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(content().string(containsString(response)));
	}
}
