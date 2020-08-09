package cct.ie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
public class BookingServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1047556520878046419L;

	public BookingServiceException(String msg) {
		super(msg);
	}

}
