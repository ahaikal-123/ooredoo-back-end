package com.oredoo.demo.controllers.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class FranchiseApplicationCreateModel implements Serializable {

	private Long id;

	@NotBlank
	private String applicantsName;

	@NotNull
	private long idNumber;

	private LocalDate birthDate;

	@Email(message = "this property must be with email format")
	private String contactEmail;

	private String brandInterestDescription;

	@PositiveOrZero
	private double investmentAmount;

	private String additionalNotes;

	public FranchiseApplicationCreateModel() {
	}

	public FranchiseApplicationCreateModel(Long id, String applicantsName, long idNumber, LocalDate birthDate, String contactEmail, String brandInterestDescription, double investmentAmount, String additionalNotes) {
		this.id = id;
		this.applicantsName = applicantsName;
		this.idNumber = idNumber;
		this.birthDate = birthDate;
		this.contactEmail = contactEmail;
		this.brandInterestDescription = brandInterestDescription;
		this.investmentAmount = investmentAmount;
		this.additionalNotes = additionalNotes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplicantsName() {
		return applicantsName;
	}

	public void setApplicantsName(String applicantsName) {
		this.applicantsName = applicantsName;
	}

	public long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getBrandInterestDescription() {
		return brandInterestDescription;
	}

	public void setBrandInterestDescription(String brandInterestDescription) {
		this.brandInterestDescription = brandInterestDescription;
	}

	public double getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
}
