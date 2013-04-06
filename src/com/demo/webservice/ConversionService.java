package com.demo.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ConversionService")
public class ConversionService {
	
	@GET
	@Path("/FahrenheitACelsius/{f}")
	@Produces(MediaType.TEXT_XML)
	public String convertFahrenheitACelsius(@PathParam("f") int f){
		
		double celsius = 0;
		int fahrenheit = f;
		celsius = (double)((fahrenheit - 32)/1.8);
		
		return "<FahrenheitACelsiusService>"+
				"<Fahrenheit>"+fahrenheit+"</Fahrenheit>"+
				"<Celsius>"+celsius+"</Celsius>"+
				"</FahrenheitACelsiusService>";
	}
	
	@Path("/FahrenheitAKelvin/{f}")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String convertFahrenheitAKelvin(@PathParam("f") int f){
		
		double kelvin = 0;
		int fahrenheit = f;
		kelvin = (double)((fahrenheit + 459.67)/1.8);
		
		return "<FahrenheitAKelvinService>"+
		"<Fahrenheit>"+fahrenheit+"</Fahrenheit>"+
		"<Kelvin>"+kelvin+"</Kelvin>"+
		"</FahrenheitAKelvinService>";
	}
	
}
