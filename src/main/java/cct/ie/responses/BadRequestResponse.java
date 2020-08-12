package cct.ie.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestResponse extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2129021259982511903L;

	public BadRequestResponse(String msg) {
		super(msg);
	}

}
