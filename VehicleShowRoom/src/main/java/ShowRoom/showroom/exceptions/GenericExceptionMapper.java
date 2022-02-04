package ShowRoom.showroom.exceptions;

import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream.ExceptionMarker;
import org.glassfish.jersey.internal.ExceptionMapperFactory;

import ShowRoom.showroom.model.ErrorPayload;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		System.out.println("Error not dound exception");
		ErrorPayload error = new ErrorPayload(500, "Internal Server Error");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
	}
	
}
