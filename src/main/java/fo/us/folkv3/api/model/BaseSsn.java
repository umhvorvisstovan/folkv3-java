package fo.us.folkv3.api.model;

import java.util.Objects;
import java.util.regex.Pattern;

abstract class BaseSsn {

	private final String value;
	private final String formattedValue;

	protected BaseSsn(String value) {
		var cleanValue = clean(Objects.requireNonNull(value, "value must not be null"));
		if (pattern() != null && !pattern().matcher(cleanValue).matches()) {
			throw new IllegalArgumentException(
					"value does not represent a valid " + getClass().getSimpleName() + ": " + value);
		}
		this.value = cleanValue;
		formattedValue = format();
	}

	public String getValue() {
		return value;
	}
	
	public String getFormattedValue() {
		return formattedValue;
	}

	protected String clean(String value) {
		return value;
	}

	protected Pattern pattern() {
		return null;
	}

	protected abstract String format();

}
