package cl.nisum.bffuser.api.controller.advise;

import cl.nisum.bffuser.api.swagger.model.EmptyDataResponse;
import cl.nisum.bffuser.common.exception.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionHandlerControllerTest {
    @InjectMocks
    private ExceptionHandlerController exceptionHandlerController;

    private String message = "Error";
    @Test
    public void handleDelegateException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleDelegateException(new DelegateException(message));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());

    }

    @Test
    public void handleUseCaseException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleUseCaseException(new UseCaseException(message));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }

    @Test
    public void handleRepositoryException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleRepositoryException(new RepositoryException(message));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }

    @Test
    public void handleDataSourceException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleDataSourceException(new DataSourceException(message));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }

    @Test
    public void handleDataBadRequestException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleDataBadRequestException(new BadRequestException(message));
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }

    @Test
    public void handleDataMapperException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleDataMapperException(new MapperException(message));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }

    @Test
    public void handleDataEmailUserException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleDataEmailUserException(new EmailUserException(message));
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }

    @Test
    public void handleDataPasswordException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleDataPasswordException(new PasswordException(message));
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }

    @Test
    public void handleDataNotFoundException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleDataNotFoundException(new NotFoundException(message));
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }

    @Test
    public void handleDataNotImplementedException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleDataNotImplementedException(new NotImplementedException(message));
        assertEquals(HttpStatus.NOT_IMPLEMENTED, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }

    @Test
    public void handleDataNullPointerException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleDataNullPointerException(new NullPointerException(message));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }

    @Test
    public void handleDataException() {
        ResponseEntity<EmptyDataResponse> result = exceptionHandlerController.handleDataException(new Exception(message));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertNotNull(result.getBody());
        assertNotNull(result.getBody().getNotifications());
    }
}