package co.com.pagesearch.demo.domain.constants.errors;

import lombok.Getter;

@Getter
public enum DocumentErrorCode {

	DOCUMENT_ERROR("Error in  document", ErrorCodes.NOTIFICATIONSOURCE),
	
	FILE_NOT_SUPPORT_ERROR("file no support", ErrorCodes.NOTIFICATIONSOURCE),

	FILE_NOT_FOUND("file not found",ErrorCodes.NOTIFICATIONSOURCE_01);
	
	private DocumentErrorCode(final String errorMessage, final String apiCode) {
		this.errorMessage = errorMessage;
		this.apiCode = apiCode;
	}
	
	private String errorMessage;

	private String apiCode;
	
}
