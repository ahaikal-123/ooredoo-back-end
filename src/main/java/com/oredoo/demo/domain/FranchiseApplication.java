package com.oredoo.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.oredoo.demo.domain.base.BaseEntity;

@Entity
public class FranchiseApplication extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "franchise_id")
	private Long id;

	@Column(name = "applicants_name", nullable = false)
	private String applicantsName;

	@Column(name = "id_number")
	private long idNumber;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "contact_email")
	private String contactEmail;

	@Column(name = "brand_interest_description")
	private String brandInterestDescription;

	@Column(name = "investment_amount")
	private double investmentAmount;

	@Column(name = "additional_notes")
	private String additionalNotes;

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

	public void setBrandInterestDescription(String brandInterestDescribtion) {
		this.brandInterestDescription = brandInterestDescribtion;
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
