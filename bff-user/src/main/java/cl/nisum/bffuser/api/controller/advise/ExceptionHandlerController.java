package cl.nisum.bffuser.api.controller.advise;

import cl.nisum.bffuser.api.swagger.model.EmptyDataResponse;
import cl.nisum.bffuser.common.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(DelegateException.class)
    public ResponseEntity<EmptyDataResponse> handleDelegateException(DelegateException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception);

    }
    @ExceptionHandler(UseCaseException.class)
    public ResponseEntity<EmptyDataResponse> handleUseCaseException(UseCaseException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception);

    }

    @ExceptionHandler(RepositoryException.class)
    public ResponseEntity<EmptyDataResponse> handleRepositoryException(RepositoryException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception);

    }

    @ExceptionHandler(DataSourceException.class)
    public ResponseEntity<EmptyDataResponse> handleDataSourceException(DataSourceException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<EmptyDataResponse> handleDataBadRequestException(BadRequestException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception);

    }

    @ExceptionHandler(MapperException.class)
    public ResponseEntity<EmptyDataResponse> handleDataMapperException(MapperException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception);

    }
    @ExceptionHandler(EmailUserException.class)
    public ResponseEntity<EmptyDataResponse> handleDataEmailUserException(EmailUserException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception);

    }
    @ExceptionHandler(PasswordException.class)
    public ResponseEntity<EmptyDataResponse> handleDataPasswordException(PasswordException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception);

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<EmptyDataResponse> handleDataNotFoundException(NotFoundException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.NOT_FOUND,
                exception);

    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<EmptyDataResponse> handleDataUserNotExistException(UserNotExistException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.NOT_FOUND,
                exception);

    }
    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<EmptyDataResponse> handleDataNotImplementedException(NotImplementedException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.NOT_IMPLEMENTED,
                exception);

    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<EmptyDataResponse> handleDataNullPointerException(NullPointerException exception){
        return getEmptyDataResponseEntity(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EmptyDataResponse> handleDataException(Exception exception){
        return getEmptyDataResponseEntity(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception);

    }
    private ResponseEntity<EmptyDataResponse> getEmptyDataResponseEntity(HttpStatus httpStatus,
                                                                          Exception exception){

        return new ResponseEntity<>(getEmptyDataResponse(httpStatus.value(),exception.getMessage()),httpStatus);
    }

    private EmptyDataResponse getEmptyDataResponse(int code, String message){
        EmptyDataResponse emptyDataResponse = new EmptyDataResponse();
        emptyDataResponse.setData(String.valueOf(code));
        emptyDataResponse.setNotifications(message);
        return emptyDataResponse;
    }

}
