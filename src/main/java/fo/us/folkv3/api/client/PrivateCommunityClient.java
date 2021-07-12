package fo.us.folkv3.api.client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import eu.x_road.us_folk_v3.producer.AddPersonToCommunityByNameAndAddress;
import eu.x_road.us_folk_v3.producer.AddPersonToCommunityByNameAndDateOfBirth;
import eu.x_road.us_folk_v3.producer.GetPrivateChanges;
import eu.x_road.us_folk_v3.producer.RemovePersonsFromCommunity;
import fo.us.folkv3.api.client.mapper.CommunityPersonMapper;
import fo.us.folkv3.api.client.mapper.PrivateChangesMapper;
import fo.us.folkv3.api.model.Changes;
import fo.us.folkv3.api.model.CommunityPerson;
import fo.us.folkv3.api.model.PrivateId;
import fo.us.folkv3.api.model.param.AddressParam;
import fo.us.folkv3.api.model.param.NameParam;

public class PrivateCommunityClient extends PrivilegesSmallClient {

	private final CommunityPersonMapper commmunityMapper;
	private final PrivateChangesMapper changesMapper;

	public PrivateCommunityClient(HeldinConfig config) {
		super(config);
		commmunityMapper = new CommunityPersonMapper();
		changesMapper = new PrivateChangesMapper();
		checkCanUseCommunityMethods();
	}

	@Override
	protected List<Class<?>> listOfOperationClasses(List<Class<?>> operationClasses) {
		super.listOfOperationClasses(operationClasses).addAll(
				List.of(
						AddPersonToCommunityByNameAndAddress.class,
						AddPersonToCommunityByNameAndDateOfBirth.class,
						RemovePersonsFromCommunity.class,
						GetPrivateChanges.class
						)
				);
		return operationClasses;
	}

	public CommunityPerson addPersonToCommunity(NameParam name, AddressParam address) {
		requireNonNull(name, "name");
		requireNonNull(address, "address");
		return commmunityMapper.map(
				call((sh, mh, rh) ->
						webService.addPersonToCommunityByNameAndAddress(
								nameAndAddressParam(name, address),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(AddPersonToCommunityByNameAndAddress.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

	public CommunityPerson addPersonToCommunity(NameParam name, LocalDate dateOfBirth) {
		requireNonNull(name, "name");
		requireNonNull(dateOfBirth, "dateOfBirth");
		return commmunityMapper.map(
				call((sh, mh, rh) ->
						webService.addPersonToCommunityByNameAndDateOfBirth(
								nameAndDateOfBirthParam(name, dateOfBirth),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(AddPersonToCommunityByNameAndDateOfBirth.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

	public PrivateId removePersonFromCommunity(PrivateId id) {
		var removedIds = removePersonsFromCommunity(List.of(id));
		return removedIds.isEmpty() ? null : removedIds.get(0);
	}
	
	public List<PrivateId> removePersonsFromCommunity(List<PrivateId> ids) {
		requireNonNull(ids, "ids");
		return changesMapper.privateIds(
				call((sh, mh, rh) ->
						webService.removePersonsFromCommunity(
								privateIdList(ids),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(RemovePersonsFromCommunity.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}
	
	public Changes<PrivateId> getChanges(LocalDateTime from) {
		return getChanges(from, LocalDateTime.now());
	}

	public Changes<PrivateId> getChanges(LocalDateTime from, LocalDateTime to) {
		requireNonNull(from, "from");
		requireNonNull(to, "to");
		return changesMapper.map(
				call((sh, mh, rh) ->
						webService.getPrivateChanges(
								changesParam(from, to),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPrivateChanges.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

}
