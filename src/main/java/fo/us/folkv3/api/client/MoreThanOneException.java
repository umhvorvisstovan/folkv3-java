package fo.us.folkv3.api.client;

@SuppressWarnings("serial")
public class MoreThanOneException extends ResponseStatusException {

	public MoreThanOneException() {
		super(null, ResponseStatus.MORE_THAN_ONE);
	}

}
