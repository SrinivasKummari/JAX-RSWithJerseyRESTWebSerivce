/**
 * 
 */
package org.srinivas.jaxrsjerseyrestwebservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Srinivas Kummari
 *
 */

@Path("/user")
public class User {

	@GET
	@Path("/getUserNameService")
	@Produces(MediaType.TEXT_XML)
	public String getUserName(){
		String response="<?xml version='1.0'?>"+
				"<hello>Hell</hello>";
		return response;
	}
	
	@GET
	@Path("/sayHelloFromHTML")
	@Produces(MediaType.TEXT_HTML)
	public String sayHello(){
		String response="<h1>Hello REST</h1>";
		return response;
	}
	
	@GET
	@Path("/sayHelloService")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloFromJSON(){
		String response=null;
		return response;
	}
}
