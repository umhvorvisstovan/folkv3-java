package fo.us.folkv3.api.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import eu.x_road.us_folk_v3.producer.UsFolkPortType;

class UsFolkService extends Service {

    private final static QName USFOLKSERVICE_QNAME = new QName("http://us-folk-v3.x-road.eu/producer", "UsFolkService");

	UsFolkService(URL wsdlDocumentLocation) {
		super(wsdlDocumentLocation, USFOLKSERVICE_QNAME);
	}

	static UsFolkPortType port(URL wsdlDocumentLocation) {
		return new UsFolkService(wsdlDocumentLocation).getPort(UsFolkPortType.class);
	}

}
