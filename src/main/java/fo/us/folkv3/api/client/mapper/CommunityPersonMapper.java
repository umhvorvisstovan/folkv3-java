package fo.us.folkv3.api.client.mapper;

import fo.us.folkv3.api.model.CommunityPerson;

public class CommunityPersonMapper extends ClientMapper<eu.x_road.us_folk_v3.producer.CommunityPerson, CommunityPerson> {

	private final PersonSmallMapper personMapper;
	
	public CommunityPersonMapper() {
		personMapper = new PersonSmallMapper();
	}
	
	@Override
	protected CommunityPerson doMap(eu.x_road.us_folk_v3.producer.CommunityPerson value) {
		return new CommunityPerson(
				personMapper.map(value.getPerson()),
				Mapper.privateId(value.getExistingId()),
				status(value)
				);
	}

	private static CommunityPerson.Status status(eu.x_road.us_folk_v3.producer.CommunityPerson person) {
		return CommunityPerson.Status.valueOf(person.getStatus());
	}
	
}
