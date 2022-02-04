package ShowRoom.showroom.resources;

import java.net.http.HttpHeaders;

import javax.servlet.ServletContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.message.internal.HttpHeaderReader;

import ShowRoom.showroom.model.ErrorPayload;

@Path("/")

public class Demo {
	@Context
	private UriInfo uriInfo;
	
	@Context
	private ServletContext servletContext; 
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String usefullAnnotations(@HeaderParam("HeaderValue") String headerAttribute
						,@CookieParam("_xref") String _xref) {
		
		return "Hello"+"Header Vlaue = "+headerAttribute;
	}
	
	@GET
	@Path("demo")
	@Produces(MediaType.TEXT_PLAIN)
	public String contextDemo(@Context javax.ws.rs.core.HttpHeaders header) {
	
		return header.getRequestHeaders().keySet().toString();
//		return "absolute path = "+uriInfo.getAbsolutePath().toString(); 
	}
	
	@GET
	@Path("demo1")
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	public String contextDemo1(@HeaderParam("header") String header) throws Exception{
//		ErrorPayload error = new ErrorPayload(404, "The value of custom header not found");
//		Response response = Response.status(404).entity(error).build();
		if(header == null)
			throw new NotFoundException();
//			throw new WebApplicationException(response);
		
		return "The value of custom header is = "+header;	 
	}
	
}
 