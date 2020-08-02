package cct.ie.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.OK)
public class SuccessResponse {

	private String message;

	public SuccessResponse(String msg) {
		this.message = msg;
	}

	public void NaNResponse(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
