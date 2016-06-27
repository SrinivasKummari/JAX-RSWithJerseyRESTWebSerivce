/**
 * 
 */
package org.srinivas.jaxrsjerseyrestwebservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;


/**
 * @author Srinivas Kummari
 *
 */
@Path("/service")
public class RESTService {

	//final static Logger logger=Logger.getLogger(RESTService.class);
	@POST
	@Path("/postService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postService(InputStream inputData){
		StringBuilder sb=new StringBuilder();
		BufferedReader br=new BufferedReader(new InputStreamReader(inputData));
		String line=null;
		try {
			while((line=br.readLine()) != null){
			sb.append(line);	
			}
		} catch (IOException e) {
			System.out.println("Parsing error");	
			
		}
		System.out.println("Final string: "+sb);
		//logger.info("Final string: "+sb);
		return Response.status(200).entity(sb.toString()).build();
	}
	
	@GET
	@Path("/getService")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getService(){
		String response="Get Service working successfully";
		//200 status represents HTTP success message
		return Response.status(200).entity(response).build();
	}
	
}
