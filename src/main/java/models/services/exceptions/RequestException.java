package models.services.exceptions;

@SuppressWarnings("serial")
public class RequestException extends Exception {
	public RequestException(String message) {
		super(message);
	}
}
