package fo.us.folkv3.api.model;

import java.util.Objects;

import fo.us.folkv3.api.client.FolkApiException;

public class CommunityPerson {

	private final PersonSmall person;
	private final PrivateId existingId;
	private final Status status;
	
	public CommunityPerson(PersonSmall person, PrivateId existingId, Status status) {
		this.status = Objects.requireNonNull(status);
		if (person == null && status.isAdded()) {
			throw new FolkApiException("person must not be null when status is " + Status.ADDED);
		}
		if (existingId == null && status.isAlreadyExists()) {
			throw new FolkApiException("existingId must not be null when status is " + Status.ALREADY_EXISTS);
		}
		this.person = status.isAdded() ? person : null;
		this.existingId = existingId;
	}
	
	public PersonSmall getPerson() {
		return person;
	}

	public PrivateId getExistingId() {
		return existingId;
	}

	public Status getStatus() {
		return status;
	}

	public static enum Status {
	
		ADDED,
		ALREADY_EXISTS,
		NOT_FOUND,
		MORE_THAN_ONE,
		;

		public boolean isAdded() {
			return this == ADDED;
		}
		
		public boolean isAlreadyExists() {
			return this == ALREADY_EXISTS;
		}

		public boolean isNotFound() {
			return this == NOT_FOUND;
		}

		public boolean isMoreThanOne() {
			return this == MORE_THAN_ONE;
		}

	}

}
