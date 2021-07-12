package fo.us.folkv3.api.client;

@SuppressWarnings("serial")
public class ResponseStatusException extends FolkApiException {

	private final ResponseStatus responseStatus;
	
	public ResponseStatusException(String message, ResponseStatus responseStatus) {
		super(responseStatus + " - " + message);
		this.responseStatus = responseStatus;
	}

	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

}
