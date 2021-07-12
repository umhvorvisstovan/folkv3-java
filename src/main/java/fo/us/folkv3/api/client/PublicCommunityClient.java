package fo.us.folkv3.api.client;

import java.time.LocalDateTime;
import java.util.List;

import eu.x_road.us_folk_v3.producer.GetPublicChanges;
import fo.us.folkv3.api.client.mapper.PublicChangesMapper;
import fo.us.folkv3.api.model.Changes;
import fo.us.folkv3.api.model.PublicId;

public class PublicCommunityClient extends PrivilegesMediumClient {

	private final PublicChangesMapper changesMapper;

	public PublicCommunityClient(HeldinConfig config) {
		super(config);
		changesMapper = new PublicChangesMapper();
		checkCanGetPublicChanges();
	}

	@Override
	protected List<Class<?>> listOfOperationClasses(List<Class<?>> operationClasses) {
		super.listOfOperationClasses(operationClasses).add(GetPublicChanges.class);
		return operationClasses;
	}

	public Changes<PublicId> getChanges(LocalDateTime from) {
		return getChanges(from, LocalDateTime.now());
	}

	public Changes<PublicId> getChanges(LocalDateTime from, LocalDateTime to) {
		requireNonNull(from, "from");
		requireNonNull(to, "to");
		return changesMapper.map(
				call((sh, mh, rh) ->
						webService.getPublicChanges(
								changesParam(from, to),
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPublicChanges.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

}
