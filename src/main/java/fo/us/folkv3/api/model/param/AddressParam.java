package fo.us.folkv3.api.model.param;

import java.util.Objects;

import fo.us.folkv3.api.model.HouseNumber;

public class AddressParam {

	private final String street;
	private final HouseNumber houseNumber;
	private final String city;

	public AddressParam(String street, HouseNumber houseNumber, String city) {
		this.street = Objects.requireNonNull(street, "street must not be null");
		this.houseNumber = Objects.requireNonNull(houseNumber, "houseNumber must not be null");
		this.city = Objects.requireNonNull(city, "city must not be null");
	}

	public static AddressParam of(String street, HouseNumber houseNumber, String city) {
		return new AddressParam(street, houseNumber, city);
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public HouseNumber getHouseNumber() {
		return houseNumber;
	}

}
