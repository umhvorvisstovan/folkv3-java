package fo.us.folkv3.api.model;

import java.time.LocalDate;
import java.util.Objects;

public class Address {

	private final String streetAndNumbers;
	private final String street;
	private final HouseNumber houseNumber;
	private final String apartment;
	private final String postalCode;
	private final String city;
	private final Country country;
	private final LocalDate from;
	
	public Address(String streetAndNumbers, String street, HouseNumber houseNumber, String apartment,
			String postalCode, String city, Country country, LocalDate from) {
		this.streetAndNumbers = streetAndNumbers;
		this.street = street;
		this.houseNumber = houseNumber;
		this.apartment = apartment;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		this.from = from;
	}

	/**
	 * The format of {@code streetAndNumbers} is 
	 * "{@code street} {@code houseNumber}[{@code buildingCode}][, {@code apartment}]".
	 * @return	a string if {@link #hasStreet()} and {@link #hasHouseNumber()}, {@code null} otherwise.
	 * @see		#getStreet()
	 * @see		#getHouseNumber()
	 * @see		#getBuildingCode()
	 * @see		#getApartment()
	 * @see		#isComplete()
	 */
	public String getStreetAndNumbers() {
		return streetAndNumbers;
	}

	/**
	 * @return	a string if {@link #hasStreet()}, {@code null} otherwise.
	 * @see		#isComplete()
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return	an integer if {@link #hasHouseNumber()}, {@code null} otherwise. 
	 * @see		#isComplete()
	 */
	public HouseNumber getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @return	a string if {@link #hasApartment()}, {@code null} otherwise. 
	 * @see		#isComplete()
	 */
	public String getApartment() {
		return apartment;
	}

	/**
	 * @return	a string if {@link #hasPostalCode()}, {@code null} otherwise. 
	 * @see		#isComplete()
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return	a string if {@link #hasCity()}, {@code null} otherwise. 
	 * @see		#isComplete()
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return	a string if {@link #hasCountry()}, {@code null} otherwise. 
	 * @see		#isComplete()
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @return	a valid from date. 
	 */
	public LocalDate getFrom() {
		return from;
	}

	/**
	 * Tests if this instance represents a complete address. An address is complete if {@link #hasStreet()}, 
	 * {@link #hasHouseNumber()}, {@link #hasPostalCode()}, {@link #hasCity()} and {@link #hasCountry()}
	 * all are {@code true}.
	 * @return	{@code true} if complete, {@code false} otherwise.
	 */
	public boolean isComplete() {
		return hasStreet() && hasHouseNumber() && hasPostalCode() && hasCity() && hasCountry();
	}

	/**
	 * @return	{@code true} if {@link #getStreetAndNumbers()} is not {@code null}, {@code false} otherwise.
	 * @see		#isComplete()
	 */
	public boolean hasStreetAndNumbers() {
		return streetAndNumbers != null;
	}

	/**
	 * @return	{@code true} if {@link #getStreet()} is not {@code null}, {@code false} otherwise.
	 * @see		#isComplete()
	 */
	public boolean hasStreet() {
		return street != null;
	}

	/**
	 * @return	{@code true} if {@link #getHouseNumber()} is not {@code null}, {@code false} otherwise.
	 * @see		#isComplete()
	 */
	public boolean hasHouseNumber() {
		return houseNumber != null;
	}

	/**
	 * @return	{@code true} if {@link #getApartment()} is not {@code null}, {@code false} otherwise.
	 * @see		#isComplete()
	 */
	public boolean hasApartment() {
		return apartment != null;
	}

	/**
	 * @return	{@code true} if {@link #getPostalCode()} is not {@code null}, {@code false} otherwise.
	 * @see		#isComplete()
	 */
	public boolean hasPostalCode() {
		return postalCode != null;
	}

	/**
	 * @return	{@code true} if {@link #getCity()} is not {@code null}, {@code false} otherwise.
	 * @see		#isComplete()
	 */
	public boolean hasCity() {
		return city != null;
	}

	/**
	 * @return	{@code true} if {@link #getCountry()} is not {@code null}, {@code false} otherwise.
	 * @see		#isComplete()
	 */
	public boolean hasCountry() {
		return country != null;
	}

	@Override
	public String toString()  {
		return String.format("%s {street: %s; houseNumber: %s; apartment: %s; "
				+ "postalCode: %s; city: %s; country: %s; from: %s}",
				getClass().getName(), street, houseNumber, apartment, postalCode, city, country, from);
	}

	@Override
	public int hashCode() {
		return Objects.hash(street, houseNumber, apartment, postalCode, city, country, from);
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof Address)) {
			return false;
		}
		Address other = (Address) that;
		return Objects.equals(street, other.street)
				&& Objects.equals(houseNumber, other.houseNumber)
				&& Objects.equals(apartment, other.apartment)
				&& Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(city, other.city)
				&& Objects.equals(country, other.country)
				&& Objects.equals(from, other.from);
	}

}
