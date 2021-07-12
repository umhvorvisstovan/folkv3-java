package fo.us.folkv3.api.model;

import java.util.regex.Pattern;

public class Ptal extends BaseSsn {

	private static final Pattern PATTERN = Pattern.compile("\\d{9}");

	private Ptal(String value) {
		super(value);
	}

	public static Ptal of(String value) {
		return new Ptal(value);
	}

	@Override
	protected String clean(String value) {
		return value.replace("-", "");
	}

	@Override
	protected Pattern pattern() {
		return PATTERN;
	}

	@Override
	protected String format() {
		return String.format("%s-%s", getValue().substring(0, 6), getValue().substring(6));
	}

}
