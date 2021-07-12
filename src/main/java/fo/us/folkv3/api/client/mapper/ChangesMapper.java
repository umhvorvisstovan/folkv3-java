package fo.us.folkv3.api.client.mapper;

import fo.us.folkv3.api.model.Changes;
import fo.us.folkv3.api.model.Id;

abstract class ChangesMapper<C extends eu.x_road.us_folk_v3.producer.ChangesBase, I extends Id>
		extends ClientMapper<C, Changes<I>> {

}
