package fo.us.folkv3.api.client;

import java.util.List;
import java.util.Set;

import eu.x_road.us_folk_v3.producer.GetPrivilegesSmall;

abstract class PrivilegesSmallClient extends BaseClient {

	protected PrivilegesSmallClient(HeldinConfig  config) {
		super(config);
	}

	@Override
	protected List<Class<?>> listOfOperationClasses(List<Class<?>> operationClasses) {
		operationClasses.add(GetPrivilegesSmall.class);
		return operationClasses;
	}

	@Override
	public Set<String> getRequiredPrivileges() throws FolkApiException {
		return privileges(
				call((sh, mh, rh) ->
						webService.getPrivilegesSmall(
								null,
								sh,
								mh,
								rh,
								clientHeader,
								serviceHeader(GetPrivilegesSmall.class),
								idHeader(),
								userIdHeader,
								issueHeader,
								protocolVersionHeader
								)
						)				
				);
	}

}
