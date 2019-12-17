package co.com.pagesearch.demo.infraestructure.exception;

import co.com.pagesearch.demo.domain.constants.errors.DocumentErrorCode;

public class FIleNotFoundException extends  RuntimeException {

    private static final long serialVersionUID = 335932166142994938L;

    private final DocumentErrorCode error;

    public FIleNotFoundException(String message) {
        super(message);
        this.error = DocumentErrorCode.FILE_NOT_FOUND;
    }

    public DocumentErrorCode getError() {
        return error;
    }
}
