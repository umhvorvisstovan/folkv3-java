package fo.us.folkv3.api.client;

public enum ResponseStatus {

	OK,
	BAD_REQUEST,
	NOT_FOUND,
	MORE_THAN_ONE,
	UNAUTHORIZED,
	ERROR;
	
	public boolean isOk() {
		return this == OK;
	}
	
	public boolean isBadRequest() {
		return this == BAD_REQUEST;
	}

	public boolean isNotFound() {
		return this == NOT_FOUND;
	}
	
	public boolean isMoreThanOne() {
		return this == MORE_THAN_ONE;
	}
	
	public boolean isUnauthorized() {
		return this == UNAUTHORIZED;
	}

	public boolean isError() {
		return this == ERROR;
	}
	
}
