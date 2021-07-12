package fo.us.folkv3.api.client;

import java.time.LocalDate;
import java.util.List;

import eu.x_road.us_folk_v3.producer.GetPersonMediumByNameAndAddress;
import eu.x_road.us_folk_v3.producer.GetPersonMediumByNameAndDateOfBirth;
import eu.x_road.us_folk_v3.producer.GetPersonMediumByPrivateId;
import eu.x_road.us_folk_v3.producer.GetPersonMediumByPtal;
import eu.x_road.us_folk_v3.producer.GetPersonMediumByPublicId;
import fo.us.folkv3.api.client.mapper.PersonMediumMapper;
import fo.us.folkv3.api.model.PersonMedium;
import fo.us.folkv3.api.model.PrivateId;
import fo.us.folkv3.api.model.Ptal;
import fo.us.folkv3.api.model.PublicId;
import fo.us.folkv3.api.model.param.AddressParam;
import fo.us.folkv3.api.model.param.NameParam;

public class PersonMediumClient extends PrivilegesMediumClient {

	private final PersonMediumMapper personMapper;

	public PersonMediumClient(HeldinConfig config) {
		super(config);
		personMapper = new PersonMediumMapper();
	}

	@Override
	protected List<Class<?>> listOfOperationClasses(List<Class<?>> operationClasses) {
		super.listOfOperationClasses(operationClasses).addAll(
				List.of(
						GetPersonMediumByPrivateId.class,
						GetPersonMediumByPublicId.class,
						GetPersonMediumByPtal.class,
						GetPersonMediumByNameAndAddress.class,
						GetPersonMediumByNameAndDateOfBirth.class
						)
				);
		return operationClasses;
	}

	public PersonMedium getPerson(PrivateId id) {
		checkCanUsePrivateId();
		requireNonNull(id, "id");
		return personMapper.map(
				call((sh, mh, rh) ->
						webService.getPersonMediumByPrivateId(
								privateId(id),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPersonMediumByPrivateId.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

	public PersonMedium getPerson(PublicId id) {
		checkCanUsePublicId();
		requireNonNull(id, "id");
		return personMapper.map(
				call((sh, mh, rh) ->
						webService.getPersonMediumByPublicId(
								publicId(id),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPersonMediumByPublicId.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

	public PersonMedium getPerson(Ptal ptal) {
		requireNonNull(ptal, "ptal");
		return personMapper.map(
				call((sh, mh, rh) ->
						webService.getPersonMediumByPtal(
								ptal.getValue(),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPersonMediumByPtal.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

	public PersonMedium getPerson(NameParam name, AddressParam address) {
		requireNonNull(name, "name");
		requireNonNull(address, "address");
		return personMapper.map(
				call((sh, mh, rh) ->
						webService.getPersonMediumByNameAndAddress(
								nameAndAddressParam(name, address),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPersonMediumByNameAndAddress.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

	public PersonMedium getPerson(NameParam name, LocalDate dateOfBirth) {
		requireNonNull(name, "name");
		requireNonNull(dateOfBirth, "dateOfBirth");
		return personMapper.map(
				call((sh, mh, rh) ->
						webService.getPersonMediumByNameAndDateOfBirth(
								nameAndDateOfBirthParam(name, dateOfBirth),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPersonMediumByNameAndDateOfBirth.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

}
