package fo.us.folkv3.api.model;

import java.time.LocalDate;
import java.util.Objects;

public class CivilStatus {

	private final Type type;
	private final LocalDate from;
	
	public CivilStatus(Type type, LocalDate from) {
		this.type = Objects.requireNonNull(type, "type must not be null");
		this.from = Objects.requireNonNull(from, "from must not be null");
	}
	
	public Type getType() {
		return type;
	}

	public LocalDate getFrom() {
		return from;
	}

	public static enum Type {
		
		BORN,
		BREAKING_OFF,
		DEAD,
		DIVORCED,
		LONGEST_LIVING,
		MARRIED,
		PARTNER,
		SEPARATED,
		WIDOWED,
		;

	}
	
}
