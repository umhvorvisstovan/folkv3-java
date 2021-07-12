package fo.us.folkv3.api.client.mapper;

import fo.us.folkv3.api.model.PersonSmall;

abstract class PersonBaseMapper<PI extends eu.x_road.us_folk_v3.producer.PersonSmall, PO extends PersonSmall>
		extends ClientMapper<PI, PO> {

	protected PersonBaseMapper() {
	}

}
