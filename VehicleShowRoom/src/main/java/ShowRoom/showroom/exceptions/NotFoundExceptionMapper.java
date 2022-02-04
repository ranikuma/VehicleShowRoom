package ShowRoom.showroom.exceptions;


import ShowRoom.showroom.model.ErrorPayload;
import javassist.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<javax.ws.rs.NotFoundException> {

	@Override
	public Response toResponse(javax.ws.rs.NotFoundException exception) {
		ErrorPayload error = new ErrorPayload(404, "Internal Server Error");
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}
	
}