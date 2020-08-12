package cct.ie.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
public class BookingServiceResponse extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1047556520878046419L;

	public BookingServiceResponse(String msg) {
		super(msg);
	}

}
