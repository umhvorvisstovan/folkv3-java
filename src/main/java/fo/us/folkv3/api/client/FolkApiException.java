package fo.us.folkv3.api.client;

@SuppressWarnings("serial")
public class FolkApiException extends RuntimeException {

	public FolkApiException(String message) {
		super(message);
	}

	public FolkApiException(String message, Throwable cause) {
		super(message, cause);
	}

}
