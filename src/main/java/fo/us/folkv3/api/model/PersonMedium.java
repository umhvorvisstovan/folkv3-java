package fo.us.folkv3.api.model;

import java.time.LocalDate;

public class PersonMedium extends PersonSmall {

	private final PublicId publicId;
	private final Ptal ptal;
	private final LocalDate dateOfBirth;
	private final CivilStatus civilStatus;

	public PersonMedium(PrivateId privateId, PublicId publicId, Ptal ptal, Name name, LocalDate dateOfBirth,
			Gender gender, Address address, String placeOfBirth, SpecialMarks specialMarks, Incapacity incapacity,
			CivilStatus civilStatus, LocalDate dateOfDeath) {
		super(privateId, name, gender, address, placeOfBirth, incapacity, specialMarks, dateOfDeath);
		this.publicId = publicId;
		this.ptal = ptal;
		this.dateOfBirth = dateOfBirth;
		this.civilStatus = civilStatus;
	}

	public PublicId getPublicId() {
		return publicId;
	}

	public Ptal getPtal() {
		return ptal;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public CivilStatus getCivilStatus() {
		return civilStatus;
	}

}
