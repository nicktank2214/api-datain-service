package com.armadillo.api.datainservice.acurisc6.controller;

import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.armadillo.api.datainservice.acurisc6.dto.PersonSearchDto;




/**
 * Company House Controller
 * 
 * 
 */
@RestController
@RequestMapping(path = "/acurisc6/persons")
public class Acurisc6PersonsController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final String RESOURCE_URL="https://api1.uat.c6-intelligence.com/api/v2_0/api/persons";
	private final String API_KEY="f1b245c5-1ba5-44e1-9b17-e8f0f054cd09";
	private final String USERNAME="";	
	private final String PASSWORD="";


	@Autowired
	RestTemplate restTemplate;


	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	

	protected Acurisc6PersonsController() {
	}








	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/search")
	//<GET>http://localhost:8080/acurisc6/persons/search
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
	public String personsSearch(
			@RequestBody String jsonBody
			) {

		
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" personsSearch - " +  jsonBody );
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("apiKey", API_KEY);
	    		
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody,headers);
		
		String result = "";
		try {
			
			result = restTemplate.exchange(
					RESOURCE_URL+"/search", 
					HttpMethod.POST, 
					entity, 
					String.class
					).getBody();
			
		} catch (HttpStatusCodeException e) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" personsSearch - HttpStatusCodeException [" + e.getMessage() + "]");			
			return e.getMessage();			
		} catch (RuntimeException e) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" personsSearch - RuntimeException [" + e.getMessage() + "]");					
			return e.getMessage();    			
		}	
		
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" personsSearch - result [" + result + "]");		


		//TEST - find ALL users using the DISCOVERY CLIENT 
		String url = "";
	    List<ServiceInstance> list = discoveryClient.getInstances("CLIENT-SERVICE");
	    if (list != null && list.size() > 0 ) {
	        url=list.get(0).getUri().toString();
	    }
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllUsers personsSearch - url [" + url + "]");
		this.findAllUsers(url);

		
		
		//TEST - find ALL users using the DISCOVERY CLIENT 
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findClientByClientAndAccount personsSearch - url [" + url + "]");
		this.findClientByClientAndAccount(url);
		
		
		
		return result;
	}



	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{qr_code}")
	//<GET>http://localhost:8080/acurisc6/persons/116301
	public String personsSearchByQRCode(
			@PathVariable(value = "qr_code") String qr_code			
			) {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" personsSearchByQRCode - Parameters [" + qr_code + "]");
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("apiKey", API_KEY);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		String result = "";
		try {
			
			result = restTemplate.exchange(
					RESOURCE_URL+"/"+qr_code, 
					HttpMethod.GET, 
					entity, 
					String.class
					).getBody();
			
		} catch (HttpStatusCodeException e) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" personsSearchByQRCode - HttpStatusCodeException [" + e.getMessage() + "]");			
			return e.getMessage();			
		} catch (RuntimeException e) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" personsSearchByQRCode - RuntimeException [" + e.getMessage() + "]");					
			return e.getMessage();    			
		}	
		
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" personsSearch - result [" + result + "]");		
		
		return result;
	}
	
	
	/**TESTING CONNECTION TO CLIENT-SERVICE
	 */
	public String findAllUsers(String url) {
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		String result = "";
		try {
			
			result = restTemplate.exchange(
					url+"/user/list", 
					HttpMethod.GET, 
					entity, 
					String.class
					).getBody();
			
		} catch (HttpStatusCodeException e) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" findAllUsers - HttpStatusCodeException [" + e.getMessage() + "]");			
			return e.getMessage();			
		} catch (RuntimeException e) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" findAllUsers - RuntimeException [" + e.getMessage() + "]");					
			return e.getMessage();    			
		}	
		
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllUsers - result [" + result + "]");		
		
		return result;
	}
	

	public String findClientByClientAndAccount(String url) {
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		String result = "";
		try {
			
			result = restTemplate.exchange(
					url+"/client/findbyclientandaccount?client=168965&account=A05", 
					HttpMethod.GET, 
					entity, 
					String.class
					).getBody();
			
		} catch (HttpStatusCodeException e) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" findClientByClientAndAccount - HttpStatusCodeException [" + e.getMessage() + "]");			
			return e.getMessage();			
		} catch (RuntimeException e) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" findClientByClientAndAccount - RuntimeException [" + e.getMessage() + "]");					
			return e.getMessage();    			
		}	
		
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findClientByClientAndAccount - result [" + result + "]");		
		
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
