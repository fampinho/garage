package cct.ie.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.OK)
public class SuccessResponse extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1047556520878046419L;

	public SuccessResponse(String msg) {
		super(msg);
	}

}
