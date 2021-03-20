package com.oredoo.demo.controllers.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

public class FranchiseApplicationUpdateModel implements Serializable {

	private String applicantsName;

	private LocalDate birthDate;

	@Email
	private String contactEmail;

	private String brandInterestDescription;

	@PositiveOrZero
	private double investmentAmount;

	public FranchiseApplicationUpdateModel() {
	}

	public FranchiseApplicationUpdateModel(String applicantsName, @PastOrPresent LocalDate birthDate, @Email String contactEmail, String brandInterestDescription, @PositiveOrZero double investmentAmount) {
		this.applicantsName = applicantsName;
		this.birthDate = birthDate;
		this.contactEmail = contactEmail;
		this.brandInterestDescription = brandInterestDescription;
		this.investmentAmount = investmentAmount;
	}

	public String getApplicantsName() {
		return applicantsName;
	}

	public void setApplicantsName(String applicantsName) {
		this.applicantsName = applicantsName;
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
}
