package fo.us.folkv3.api.client;

import java.net.URL;
import java.util.Objects;

import javax.xml.ws.BindingProvider;

import eu.x_road.us_folk_v3.producer.UsFolkPortType;

public class FolkClient {

	private static final String WSDL_PATH = '/' + FolkClient.class.getPackageName().replace('.', '/')
			+ "/us-folk-v3.wsdl";

	private FolkClient() {
		throw new AssertionError();
	}
	
	static UsFolkPortType webService(String host, boolean secure) {
		Objects.requireNonNull(host, "host must not be null");
		try {
			var webService = UsFolkService.port(wsdlUrl());
			var context = ((BindingProvider) webService).getRequestContext();
			context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress(host, secure));
			return webService;
		} catch (Exception e) {
			throw new FolkApiException("Could not create instance", e);
		}
	}
	
	public static PersonSmallClient personSmall(HeldinConfig config) {
		return new PersonSmallClient(config);
	}
	
	public static PersonMediumClient personMedium(HeldinConfig config) {
		return new PersonMediumClient(config);
	}
	
	public static PrivateCommunityClient privateCommunity(HeldinConfig config) {
		return new PrivateCommunityClient(config);
	}
	
	public static PublicCommunityClient publicCommunity(HeldinConfig config) {
		return new PublicCommunityClient(config);
	}
	
	private static URL wsdlUrl() {
		var url = FolkClient.class.getResource(WSDL_PATH);
		if (url == null) {
			throw new IllegalStateException("No wsdl found at " + WSDL_PATH);
		}
		return url;
	}
	
	private static String endpointAddress(String host, boolean secure) {
		return String.format("http%s://%s", (secure ? "s" : ""), host);
	}

}
