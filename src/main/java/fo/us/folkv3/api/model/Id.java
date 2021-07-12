package fo.us.folkv3.api.model;

import java.util.Objects;

public abstract class Id {

	private final Integer value;

	protected Id(Integer value) {
		this.value = Objects.requireNonNull(value, "value must not be null");
		if (value.intValue() < 1) {
			throw new IllegalArgumentException("value must be greater than 0");
		}
	}

	public Integer getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		return value.equals(((Id) o).value);
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
}
