package cct.ie.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NoContentResponse extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1308112172448516172L;
	
	private String message;

	public NoContentResponse(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
