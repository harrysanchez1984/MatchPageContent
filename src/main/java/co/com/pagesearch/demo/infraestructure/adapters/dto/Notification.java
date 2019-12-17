package co.com.pagesearch.demo.infraestructure.adapters.dto;

import co.com.pagesearch.demo.domain.constants.errors.DocumentErrorCode;

public class Notification {
	
	private String status;
	private String message;
	private DocumentErrorCode code;
	private String source;
	
	
	public String getStatus() {
		return status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public DocumentErrorCode getCode() {
		return code;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setCode(DocumentErrorCode code) {
		this.code = code;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	
}
