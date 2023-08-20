package org.mycompany;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

	public void configure() throws Exception {

		restConfiguration().component("servlet").host("localhost");

		rest("/myapi").get().consumes("application/json").route().setBody(constant("OK")).marshal().json(JsonLibrary.Jackson);	
	}
}