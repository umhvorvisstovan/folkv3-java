package fo.us.folkv3.api.model;

import java.util.Objects;

public class Country {

	private final String code;
	private final String nameFo;
	private final String nameEn;

	public Country(String code, String nameFo, String nameEn) {
		this.code = Objects.requireNonNull(code);
		this.nameFo = Objects.requireNonNull(nameFo);
		this.nameEn = Objects.requireNonNull(nameEn);
	}

	public String getCode() {
		return code;
	}

	public String getNameFo() {
		return nameFo;
	}

	public String getNameEn() {
		return nameEn;
	}

	@Override
	public int hashCode() {
		return code.hashCode();
	}
	
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof Country)) {
			return false;
		}
		var other = (Country) that;
		return code.equals(other.code);
	}
}
