package fo.us.folkv3.api.model.param;

import java.util.Objects;

public class NameParam {

	private final String first;
	private final String last;
	
	public NameParam(String first, String last) {
		this.first = Objects.requireNonNull(first, "first must not be null");
		this.last = Objects.requireNonNull(last, "last must not be null");
	}

	public static NameParam of(String first, String last) {
		return new NameParam(first, last);
	}
	
	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

}
