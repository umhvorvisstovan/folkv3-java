package fo.us.folkv3.api.model;

import java.util.Objects;

public class Ssn extends BaseSsn {

	private final Country country;
	
	public Ssn(String value, Country country) {
		super(value);
		this.country = Objects.requireNonNull(country, "country must not be null");
	}

	public Country getCountry() {
		return country;
	}

	@Override
	protected String format() {
		return getValue();
	}
	
}
