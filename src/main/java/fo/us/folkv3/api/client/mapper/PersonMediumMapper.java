package fo.us.folkv3.api.client.mapper;

import fo.us.folkv3.api.model.PersonMedium;

public class PersonMediumMapper extends PersonBaseMapper<eu.x_road.us_folk_v3.producer.PersonMedium, PersonMedium> {

	@Override
	protected PersonMedium doMap(eu.x_road.us_folk_v3.producer.PersonMedium value) {
		return new PersonMedium(
				Mapper.privateId(value),
				Mapper.publicId(value),
				Mapper.ptal(value),
				Mapper.name(value),
				Mapper.dateOfBirth(value.getDateOfBirth()),
				Mapper.gender(value),
				Mapper.address(value),
				value.getPlaceOfBirth(),
				Mapper.specialMarks(value),
				Mapper.incapacity(value),
				Mapper.civilStatus(value),
				Mapper.dateOfDeath(value.getDateOfDeath())
				);
	}
	
}
