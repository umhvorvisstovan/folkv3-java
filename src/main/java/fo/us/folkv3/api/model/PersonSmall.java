package fo.us.folkv3.api.model;

import java.time.LocalDate;

public class PersonSmall {
	
	private final PrivateId privateId;
	private final Name name;
	private final Gender gender;
	private final Address address;
	private final String placeOfBirth;
	private final Incapacity incapacity;
	private final SpecialMarks specialMarks;
	private final LocalDate dateOfDeath;
	
	public PersonSmall(PrivateId privateId, Name name, Gender gender, Address address, String placeOfBirth,
			Incapacity incapacity, SpecialMarks specialMarks, LocalDate dateOfDeath) {
		this.privateId = privateId;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.placeOfBirth = placeOfBirth;
		this.incapacity = incapacity;
		this.specialMarks = specialMarks;
		this.dateOfDeath = dateOfDeath;
	}

	public PrivateId getPrivateId() {
		return privateId;
	}

	public Name getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Address getAddress() {
		return address;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public Incapacity getIncapacity() {
		return incapacity;
	}

	public SpecialMarks getSpecialMarks() {
		return specialMarks;
	}

	public LocalDate getDateOfDeath() {
		return dateOfDeath;
	}
	
	public boolean isAlive() {
		return dateOfDeath == null;
	}

	public boolean isDead() {
		return !isAlive();
	}

	public boolean isIncapable() {
		return incapacity != null;
	}

}
