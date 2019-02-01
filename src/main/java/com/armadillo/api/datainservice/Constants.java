package com.armadillo.api.datainservice;




/**
 */
public class Constants {


	public static final String TIME_ZONE = "Etc/GMT-1";
			
			

	//ERROR MESSAGES
	public static final String ERROR_MESSAGE_CODE_001 = "001";
	public static final String ERROR_MESSAGE_TEXT_001 = "RECORD NOT FOUND FOR ID:  ";
	public static final String ERROR_MESSAGE_TYPE_001 = "ERROR";			

	public static final String ERROR_MESSAGE_CODE_002 = "002";
	public static final String ERROR_MESSAGE_TEXT_002 = "USER NAME ALREADY EXISTS:  ";
	public static final String ERROR_MESSAGE_TYPE_002 = "ERROR";	
	
	


	//TokenAuthenticationService Constants
	public static final long EXPIRATION_TIME = 86_400_000; // 1 days
	public static final String SECRET = "ThisIsASecret";
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String HEADER_AUTHORIZATION = "Authorization";
	public static final String HEADER_CORS = "Access-Control-Allow-Origin";

}
