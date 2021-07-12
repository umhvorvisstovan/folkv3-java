package fo.us.folkv3.api.model;

import java.util.Objects;

public class Incapacity {

	private final Guardian guardian1;
	private final Guardian guardian2;

	public Incapacity(Guardian guardian1, Guardian guardian2) {
		this.guardian1 = Objects.requireNonNull(guardian1, "guardian1 must not be null");
		this.guardian2 = guardian2;
	}

	public Guardian getGuardian1() {
		return guardian1;
	}

	public Guardian getGuardian2() {
		return guardian2;
	}

}
