package cl.nissum.register.api.delegate;

import cl.nissum.register.api.mapper.FindUserApiMapper;
import cl.nissum.register.api.swagger.model.FindUserRequest;
import cl.nissum.register.api.swagger.model.FindUserResponse;
import cl.nissum.register.common.enumeration.LoggerConst;

import cl.nissum.register.common.exception.*;
import cl.nissum.register.domain.usecase.FindUserUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
public class FindUserDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final FindUserUseCase userUseCase;
    private final FindUserApiMapper findUserApiMapper;

    public FindUserDelegate(FindUserUseCase userUseCase,
                            FindUserApiMapper findUserApiMapper) {
        this.userUseCase = userUseCase;
        this.findUserApiMapper = findUserApiMapper;
    }

    public ResponseEntity<FindUserResponse> findUserResponse(FindUserRequest findUserRequest){
        FindUserResponse userResponse;

        try{
            userResponse = userUseCase.findUser(findUserRequest);
        }catch(DataSourceException | GatewayException | MapperException |
                UserExistException | RepositoryException | UseCaseException |
                EmailUserException | PasswordException exception){
            throw exception;

        }catch(Exception exception){
            LOGGER.error("[TAG: " + LoggerConst.TAG_FAILURE_EXECUTE_USER_CREATE.getValue() + "] , " +
                    "[REQUEST: " + findUserRequest + " ] , " +
                    "[MESSAGE: " +  exception.getMessage() + "]",exception );
            throw new DelegateException(exception.getMessage(),exception);
        }
        return ResponseEntity.ok(userResponse);
    }
}
