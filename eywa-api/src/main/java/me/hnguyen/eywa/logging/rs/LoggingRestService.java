package me.hnguyen.eywa.logging.rs;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import me.hnguyen.eywa.logging.dto.LoggingDto;

/**
 * @author hnguyen
 */
@Path("/logging/logs")
@Consumes({"application/json"})
@Produces({"application/json"})
public interface LoggingRestService {

    @GET
    public Response getAllLogs(@QueryParam("page") @DefaultValue("0") int pageNumber,
                               @QueryParam("size") @DefaultValue("50") int pageSize);

    @GET
    public Response getAllLogs(@BeanParam LoggingDto template,
                               @QueryParam("page") @DefaultValue("0") int pageNumber,
                               @QueryParam("size") @DefaultValue("50") int pageSize);

    @POST
    public Response addLogs(@BeanParam LoggingDto logDto);
}
