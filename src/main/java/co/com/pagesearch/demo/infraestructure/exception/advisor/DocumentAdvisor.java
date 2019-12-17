package co.com.pagesearch.demo.infraestructure.exception.advisor;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.com.pagesearch.demo.infraestructure.adapters.dto.Notification;
import co.com.pagesearch.demo.infraestructure.exception.DocumentFileException;
import co.com.pagesearch.demo.domain.constants.errors.ErrorCodes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DocumentAdvisor {

	@ExceptionHandler(DocumentFileException.class)
	public ResponseEntity<Notification> handle(DocumentFileException exception) {

		Notification notification = new Notification();
		notification.setMessage(exception.getMessage());
		notification.setCode(exception.getError());
		notification.setSource(ErrorCodes.NOTIFICATIONSOURCE);
		
		return new ResponseEntity<>(notification, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
}
