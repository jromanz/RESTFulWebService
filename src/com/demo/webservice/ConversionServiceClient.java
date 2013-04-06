package com.demo.webservice;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ConversionServiceClient {
	
	static final String REST_URI = "http://localhost:9999/RESTfulWebserviceExample";
	static final String FAHRENHEIT_A_CELSIUS = "/ConversionService/FahrenheitACelsius/";
	static final String FAHRENHEIT_A_KELVIN = "/ConversionService/FahrenheitAKelvin/";
	
	
	public static void main(String[] args) {
		
		int fahrenheit = 60;

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(REST_URI);
		
		WebResource addService = service.path("rest").path(FAHRENHEIT_A_CELSIUS+fahrenheit);
		System.out.println(getResponse(addService));
		System.out.println(getOutputAsXML(addService));
		
		
		WebResource subService = service.path("rest").path(FAHRENHEIT_A_KELVIN+fahrenheit);
		System.out.println(getResponse(subService));
		System.out.println(getOutputAsXML(subService));		
	}


	private static String getOutputAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}


	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}

}
