package fo.us.folkv3.api.client.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import fo.us.folkv3.api.client.FolkApiException;
import fo.us.folkv3.api.model.Address;
import fo.us.folkv3.api.model.CivilStatus;
import fo.us.folkv3.api.model.Country;
import fo.us.folkv3.api.model.Gender;
import fo.us.folkv3.api.model.Guardian;
import fo.us.folkv3.api.model.HouseNumber;
import fo.us.folkv3.api.model.Incapacity;
import fo.us.folkv3.api.model.Name;
import fo.us.folkv3.api.model.PrivateId;
import fo.us.folkv3.api.model.Ptal;
import fo.us.folkv3.api.model.PublicId;
import fo.us.folkv3.api.model.SpecialMarks;

public class Mapper {

	private Mapper() {
		throw new AssertionError();
	}

	static Address address(eu.x_road.us_folk_v3.producer.Address address) {
		if (address == null) {
			return new Address(null, null, null, null, null, null, null, null);
		}
		return new Address(
				nullIfBlank(address.getStreetAndNumbers()),
				nullIfBlank(address.getStreet()),
				houseNumber(address.getHouseNumber()),
				nullIfBlank(address.getApartment()),
				nullIfBlank(address.getPostalCode()),
				nullIfBlank(address.getCity()),
				country(address.getCountry()),
				date(address.getFrom(), true, "address.from")
				);
	}

	static Address address(eu.x_road.us_folk_v3.producer.PersonSmall person) {
		return address(person.getAddress());
	}
	
	static CivilStatus civilStatus(eu.x_road.us_folk_v3.producer.PersonMedium person) {
		if (person.getCivilStatus() == null) {
			return null;
		}
		return new CivilStatus(
				CivilStatus.Type.valueOf(person.getCivilStatus().getType()),
				LocalDate.parse(person.getCivilStatus().getFrom())
				);
	}
	
	static Country country(eu.x_road.us_folk_v3.producer.Country country) {
		if (country == null) {
			throw new FolkApiException("no country");
		}
		if (isNullOrBlank(country.getCode()) || isNullOrBlank(country.getNameFo())
						|| isNullOrBlank(country.getNameEn())) {
			throw new FolkApiException("invalid country");
		}
		return new Country(
				country.getCode(),
				country.getNameFo(),
				country.getNameEn());
	}

	static LocalDate dateOfBirth(String value) {
		return date(value, false, "dateOfBirth");
	}
	
	static LocalDate dateOfDeath(String value) {
		return date(value, false, "dateOfDeath");
	}

	static LocalDate date(String value, boolean required, String what) {
		if (isNullOrBlank(value)) {
			if (required) {
				throw new FolkApiException("no " + what);
			}
			return null;
		}
		try {
			return LocalDate.parse(value);
		} catch (Exception e) {
			throw new FolkApiException("invalid " + what + ' ' + value);
		}
	}
	
	static Gender gender(eu.x_road.us_folk_v3.producer.PersonSmall person) {
		return Gender.valueOf(person.getGender());
	}
	
	static Guardian guardian(eu.x_road.us_folk_v3.producer.Guardian guardian) {
		if (guardian == null) {
			return null;
		}
		var name = name(guardian.getName());
		var address = address(guardian.getAddress());
		return name.isComplete() && address.isComplete() ? new Guardian(name, address) : null;
	}
	
	static HouseNumber houseNumber(eu.x_road.us_folk_v3.producer.HouseNumber houseNumber) {
		if (houseNumber == null) {
			return null;
		}
		return isNullOrBlank(houseNumber.getBuildingCode())
				? HouseNumber.of(houseNumber.getNumber())
				: HouseNumber.of(houseNumber.getNumber(), houseNumber.getBuildingCode().charAt(0));
	}

	static Incapacity incapacity(eu.x_road.us_folk_v3.producer.Incapacity incapacity) {
		if (incapacity == null) {
			return null;
		}
		var guardian1 = guardian(incapacity.getGuardian1());
		var guardian2 = guardian(incapacity.getGuardian2());
		return guardian2 == null
				? new Incapacity(guardian1, null)
				: new Incapacity(guardian1, guardian2);
	}

	static Incapacity incapacity(eu.x_road.us_folk_v3.producer.PersonSmall person) {
		return person == null ? null : incapacity(person.getIncapacity());
	}
	
	static Name name(eu.x_road.us_folk_v3.producer.PersonName name) {
		return name == null ? null : new Name(
				nullIfBlank(name.getFirst()),
				nullIfBlank(name.getMiddle()),
				nullIfBlank(name.getLast()),
				nullIfBlank(name.getOfficial())
				);
	}
	
	static Name name(eu.x_road.us_folk_v3.producer.PersonSmall person) {
		return person == null ? null : name(person.getName());
	}
	
	static PrivateId privateId(eu.x_road.us_folk_v3.producer.PrivateId id) {
		return id == null ? null : PrivateId.of(id.getValue());
	}
	
	static PrivateId privateId(eu.x_road.us_folk_v3.producer.PersonSmall person) {
		return person == null ? null : privateId(person.getPrivateId());
	}
	
	static Ptal ptal(eu.x_road.us_folk_v3.producer.PersonMedium person) {
		return person == null || person.getPtal() == null ? null : Ptal.of(person.getPtal());
	}
	
	static PublicId publicId(eu.x_road.us_folk_v3.producer.PublicId id) {
		return id == null ? null : PublicId.of(id.getValue());
	}
	
	static PublicId publicId(eu.x_road.us_folk_v3.producer.PersonMedium person) {
		return person == null ? null : publicId(person.getPublicId());
	}
	
	static List<PublicId> publicIds(eu.x_road.us_folk_v3.producer.PublicIdList idList) {
		return idList == null
				? List.of()
				: idList.getId().stream()
						.map(id -> PublicId.of(id.getValue()))
						.collect(Collectors.toList());
	}
	
	static SpecialMarks specialMarks(eu.x_road.us_folk_v3.producer.SpecialMarks specialMarks) {
		return specialMarks == null
				? null
				: new SpecialMarks(
						specialMarks.getType().stream()
						.map(SpecialMarks.Type::valueOf)
						.collect(Collectors.toSet())
						);
	}
	
	static SpecialMarks specialMarks(eu.x_road.us_folk_v3.producer.PersonSmall person) {
		return person == null ? null : specialMarks(person.getSpecialMarks());
	}
	
	static boolean isNullOrBlank(String value) {
		return value == null || value.isBlank();
	}

	static String nullIfBlank(String value) {
		return isNullOrBlank(value) ? null : value;
	}

}
