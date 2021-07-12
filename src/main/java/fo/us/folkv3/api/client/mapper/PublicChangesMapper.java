package fo.us.folkv3.api.client.mapper;

import java.time.LocalDateTime;

import eu.x_road.us_folk_v3.producer.PublicChanges;
import fo.us.folkv3.api.model.Changes;
import fo.us.folkv3.api.model.PublicId;

public class PublicChangesMapper extends ChangesMapper<eu.x_road.us_folk_v3.producer.PublicChanges, PublicId> {

	@Override
	protected Changes<PublicId> doMap(PublicChanges value) {
		return new Changes<>(
				LocalDateTime.parse(value.getFrom()),
				LocalDateTime.parse(value.getTo()),
				Mapper.publicIds(value.getIds())
				);
	}

}
