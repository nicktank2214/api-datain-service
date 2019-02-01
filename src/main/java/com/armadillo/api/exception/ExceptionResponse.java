package com.armadillo.api.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionResponse {
	
	
    @JsonProperty("message_code")
	private String messageCode;
    
    @JsonProperty("message_text")
	private String messageText;
    
    @JsonProperty("message_type")
	private String messageType;
	
	
	
	public ExceptionResponse(String messageCode, String messageText, String messageType) {
		super();
		this.messageCode = messageCode;
		this.messageText = messageText;
		this.messageType = messageType;
	}
	
	
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
	
	
	@Override
	public String toString() {
		return "ExceptionResponse [messageCode=" + messageCode + ", messageText=" + messageText + ", messageType="
				+ messageType + "]";
	}
	
	

}
