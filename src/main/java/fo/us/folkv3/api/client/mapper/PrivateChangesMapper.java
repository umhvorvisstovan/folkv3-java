package fo.us.folkv3.api.client.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import eu.x_road.us_folk_v3.producer.PrivateChanges;
import fo.us.folkv3.api.model.Changes;
import fo.us.folkv3.api.model.PrivateId;

public class PrivateChangesMapper extends ChangesMapper<eu.x_road.us_folk_v3.producer.PrivateChanges, PrivateId> {

	@Override
	protected Changes<PrivateId> doMap(PrivateChanges value) {
		return new Changes<>(
				LocalDateTime.parse(value.getFrom()),
				LocalDateTime.parse(value.getTo()),
				privateIds(value.getIds())
				);
	}

	public List<PrivateId> privateIds(eu.x_road.us_folk_v3.producer.PrivateIdList idList) {
		return idList == null
				? List.of()
				: idList.getId().stream()
						.map(id -> PrivateId.of(id.getValue()))
						.collect(Collectors.toList());
	}
	
}
