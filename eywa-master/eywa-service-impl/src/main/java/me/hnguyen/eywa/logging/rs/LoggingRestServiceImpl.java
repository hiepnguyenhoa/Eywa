package me.hnguyen.eywa.logging.rs;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import me.hnguyen.eywa.logging.dto.LoggingDto;
import me.hnguyen.eywa.logging.service.LoggingService;

/**
 * Created by hnguyen on 9/14/16.
 */
@Service
public class LoggingRestServiceImpl implements LoggingRestService{

    @Inject
    private LoggingService<LoggingDto> dtoLoggingService;

    @Override
    public Response getAllLogs(@QueryParam("page") @DefaultValue("0") int pageNumber, @QueryParam("size") @DefaultValue("50") int pageSize) {
        List<LoggingDto> loggingDtoList = dtoLoggingService.getAllLogs(pageNumber, pageSize);
        return Response.ok().entity(loggingDtoList).build();
    }

    @Override
    public Response getAllLogs(@BeanParam LoggingDto template, @QueryParam("page") @DefaultValue("0") int pageNumber,
                               @QueryParam("size") @DefaultValue("50") int pageSize) {
        List<LoggingDto> loggingDtoList = dtoLoggingService.getAllLogs(pageNumber, pageSize);
        return Response.ok().entity(loggingDtoList).build();
    }

    @Override
    public Response addLogs(@BeanParam LoggingDto logDto) {
        LoggingDto loggingDtoResult = dtoLoggingService.saveLogging(logDto);
        return Response.ok().entity(loggingDtoResult).build();
    }
}
