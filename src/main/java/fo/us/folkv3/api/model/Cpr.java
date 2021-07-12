package fo.us.folkv3.api.model;

import java.util.regex.Pattern;

public class Cpr extends BaseSsn {

	private static final Pattern PATTERN = Pattern.compile("\\d{10}");

	private Cpr(String value) {
		super(value);
	}

	public static Cpr of(String value) {
		return new Cpr(value);
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
