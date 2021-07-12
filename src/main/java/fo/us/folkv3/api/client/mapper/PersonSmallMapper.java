package fo.us.folkv3.api.client.mapper;

import fo.us.folkv3.api.model.PersonSmall;

public class PersonSmallMapper extends PersonBaseMapper<eu.x_road.us_folk_v3.producer.PersonSmall, PersonSmall> {

	@Override
	protected PersonSmall doMap(eu.x_road.us_folk_v3.producer.PersonSmall value) {
		return new PersonSmall(
				Mapper.privateId(value),
				Mapper.name(value),
				Mapper.gender(value),
				Mapper.address(value),
				value.getPlaceOfBirth(),
				Mapper.incapacity(value),
				Mapper.specialMarks(value),
				Mapper.dateOfDeath(value.getDateOfDeath())
				);
	}

}
