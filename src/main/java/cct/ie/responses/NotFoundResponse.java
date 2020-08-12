package cct.ie.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundResponse extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1047556520878046419L;

	public NotFoundResponse(String msg) {
		super(msg);
	}

}
