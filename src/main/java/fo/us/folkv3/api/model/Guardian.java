package fo.us.folkv3.api.model;

import java.util.Objects;

public class Guardian {

	private final Name name;
	private final Address address;
	
	public Guardian(Name name, Address address) {
		this.name = Objects.requireNonNull(name, "name must not be null");
		this.address = Objects.requireNonNull(address, "address must not be null");
	}

	public Name getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

}
