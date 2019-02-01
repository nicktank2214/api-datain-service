package com.armadillo.api.datainservice.acurisc6.service;

import java.util.Base64;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;



/**
 * Company House Service
 * 
 * 
 */
@Service
public class CompaniesHouseService {


	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final String resourceUrl="https://api.companieshouse.gov.uk";
	private final String username="qmJHxsvrgLtFRqecCLzfkJ81dpDn5FbD3Y39bm6z";
	private final String password="";


	@Autowired
	RestTemplate restTemplate;


	protected CompaniesHouseService() {
	}








	/**
	 */
	//<GET>http://localhost:8080/companieshouse/company/01777777       
	public String getCompanyByCompanyNumber(String company_number) {

		String result = "";
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getCompanyByCompanyNumber - Parameters [company_number=" + company_number+ "]");

		try {
			HttpHeaders headers = this.createHttpHeaders(username, password);
			HttpEntity<String> entity = new HttpEntity<String>(headers);

			ResponseEntity<String> httpResult=restTemplate.exchange(resourceUrl+"/company/"+company_number,	HttpMethod.GET,	entity,	String.class);

			result = "Get SUCCESS with result: " + httpResult.toString();
		} catch (HttpStatusCodeException e) {
			result = "Get FAILED with HttpStatusCode: " + e.getStatusCode()
			+ "|" + e.getStatusText();
		} catch (RuntimeException e) {
			result = "Get FAILEDn" + e.getMessage();
		}		



		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getCompanyByCompanyNumber - result [" + result+ "]");

		return result;
	}




	private HttpHeaders createHttpHeaders(String user, String password)
	{
		String notEncoded = user + ":" + password;
		String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", encodedAuth);
		return headers;
	}	 


	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 *
	 * @param ex
	 * @return Error message String.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();

	}

}
