package fo.us.folkv3.api.client;

import java.time.LocalDate;
import java.util.List;

import eu.x_road.us_folk_v3.producer.GetPersonSmallByNameAndAddress;
import eu.x_road.us_folk_v3.producer.GetPersonSmallByNameAndDateOfBirth;
import eu.x_road.us_folk_v3.producer.GetPersonSmallByPrivateId;
import eu.x_road.us_folk_v3.producer.GetPersonSmallByPtal;
import eu.x_road.us_folk_v3.producer.GetPrivateChanges;
import fo.us.folkv3.api.client.mapper.PersonSmallMapper;
import fo.us.folkv3.api.model.PersonSmall;
import fo.us.folkv3.api.model.PrivateId;
import fo.us.folkv3.api.model.Ptal;
import fo.us.folkv3.api.model.param.AddressParam;
import fo.us.folkv3.api.model.param.NameParam;

public class PersonSmallClient extends PrivilegesSmallClient {

	private final PersonSmallMapper personMapper;

	public PersonSmallClient(HeldinConfig config) {
		super(config);
		personMapper = new PersonSmallMapper();
	}

	@Override
	protected List<Class<?>> listOfOperationClasses(List<Class<?>> operationClasses) {
		super.listOfOperationClasses(operationClasses).addAll(
				List.of(
						GetPersonSmallByPrivateId.class,
						GetPersonSmallByPtal.class,
						GetPersonSmallByNameAndAddress.class,
						GetPersonSmallByNameAndDateOfBirth.class,
						GetPrivateChanges.class
						)
				);
		return operationClasses;
	}

	public PersonSmall getPerson(PrivateId id) {
		requireNonNull(id, "id");
		return personMapper.map(
				call((sh, mh, rh) ->
						webService.getPersonSmallByPrivateId(
								privateId(id),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPersonSmallByPrivateId.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

	public PersonSmall getPerson(Ptal ptal) {
		requireNonNull(ptal, "ptal");
		return personMapper.map(
				call((sh, mh, rh) ->
						webService.getPersonSmallByPtal(
								ptal.getValue(),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPersonSmallByPtal.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

	public PersonSmall getPerson(NameParam name, AddressParam address) {
		requireNonNull(name, "name");
		requireNonNull(address, "address");
		return personMapper.map(
				call((sh, mh, rh) ->
						webService.getPersonSmallByNameAndAddress(
								nameAndAddressParam(name, address),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPersonSmallByNameAndAddress.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

	public PersonSmall getPerson(NameParam name, LocalDate dateOfBirth) {
		requireNonNull(name, "name");
		requireNonNull(dateOfBirth, "dateOfBirth");
		return personMapper.map(
				call((sh, mh, rh) ->
						webService.getPersonSmallByNameAndDateOfBirth(
								nameAndDateOfBirthParam(name, dateOfBirth),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPersonSmallByNameAndDateOfBirth.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

}
