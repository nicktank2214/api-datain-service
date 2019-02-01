package com.armadillo.api.datainservice.acurisc6.dto;


import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * Data Transfer Object for users
 */
public class PersonSearchDto {

	
	//{
	//	"Threshold":70,
	//	"PEP":true,
	//	"PreviousSanctions":false,
	//	"CurrentSanctions":false,
	//	"LawEnforcement":false,
	//	"FinancialRegulator":false,
	//	"Insolvency":false,
	//	"DisqualifiedDirector":false,
	//	"AdverseMedia":false,
	//	"Forename":"Vladimir",
	//	"Middlename":null,
	//	"Surname":"Putin",
	//	"DateOfBirth":"1952-10-23",
	//	"YearOfBirth":1952,
	//	"Address": "23 ilinkina street",
	//	"City":"Moscow",
	//	"County":null,
	//	"Postcode":"103132",
	//	"Country":"Russia"
	//	}	
	
    @JsonProperty("Threshold")
    private Integer Threshold;

    @JsonProperty("PEP")
    private boolean PEP;

    @Size(max = 50)
    @JsonProperty("PreviousSanctions")
    private boolean PreviousSanctions;

    @Size(max = 200)
    @JsonProperty("Forename")
    private String Forename;
	
    @Size(max = 200)
    @JsonProperty("Middlename")
    private String Middlename;

    @JsonProperty("Surname")
    private String Surname;

	
    
	public PersonSearchDto(Integer Threshold, boolean PEP, boolean PreviousSanctions, String Forename, String Middlename, String Surname) {
		 this.Threshold=Threshold; 
				 this.PEP= PEP;
						 this.PreviousSanctions= PreviousSanctions;
								 this.Forename=Forename;
										 this.Middlename= Middlename;
												 this.Surname=Surname;
	}
	protected PersonSearchDto() {
	}
	
	
	
	
	public Integer getThreshold() {
		return Threshold;
	}
	public void setThreshold(Integer threshold) {
		Threshold = threshold;
	}
	public boolean isPEP() {
		return PEP;
	}
	public void setPEP(boolean pEP) {
		PEP = pEP;
	}
	public boolean isPreviousSanctions() {
		return PreviousSanctions;
	}
	public void setPreviousSanctions(boolean previousSanctions) {
		PreviousSanctions = previousSanctions;
	}
	public String getForename() {
		return Forename;
	}
	public void setForename(String forename) {
		Forename = forename;
	}
	public String getMiddlename() {
		return Middlename;
	}
	public void setMiddlename(String middlename) {
		Middlename = middlename;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	
	
	
	
	@Override
	public String toString() {
		return "PersonSearchDto [Threshold=" + Threshold + ", PEP=" + PEP + ", PreviousSanctions=" + PreviousSanctions
				+ ", Forename=" + Forename + ", Middlename=" + Middlename + ", Surname=" + Surname + "]";
	}
	


	
}
