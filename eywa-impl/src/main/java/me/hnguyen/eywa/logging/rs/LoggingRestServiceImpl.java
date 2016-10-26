package me.hnguyen.eywa.logging.rs;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import me.hnguyen.eywa.logging.dto.LoggingDto;
import me.hnguyen.eywa.logging.service.LoggingService;
import org.springframework.stereotype.Service;

/**
 *
 * @author hnguyen
 */
@Service("loggingRestService")
public class LoggingRestServiceImpl implements LoggingRestService {

    @Inject
    private LoggingService loggingService;

    @Override
    public Response getAllLogs(int pageNumber, int pageSize) {
        List<LoggingDto> loggingDtos = loggingService.getAllLogs(pageNumber, pageSize);
        return Response.status(Response.Status.OK).entity(loggingDtos).build();
    }

    @Override
    public Response getAllLogs(LoggingDto template, int pageNumber, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response addLogs(LoggingDto logDto) {
        LoggingDto logginDto = loggingService.saveLogging(logDto);
        return Response.status(Response.Status.CREATED).entity(logginDto).build();
    }

}
