package cl.nisum.bffuser.api.delegate;

import cl.nisum.bffuser.api.mapper.CreateUserApiMapper;
import cl.nisum.bffuser.api.passport.JWTToken;
import cl.nisum.bffuser.api.swagger.model.CreateUserResponse;
import cl.nisum.bffuser.api.swagger.model.UserRequest;
import cl.nisum.bffuser.common.enumeration.LoggerConst;
import cl.nisum.bffuser.common.exception.*;
import cl.nisum.bffuser.domain.usecase.CreateUserUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.invoke.MethodHandles;

@Component
public class RegisterUserDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final CreateUserUseCase userUseCase;
    private final CreateUserApiMapper userCreateApiMapper;
    public RegisterUserDelegate(CreateUserUseCase userUseCase,
                                CreateUserApiMapper userCreateApiMapper) {
        this.userUseCase = userUseCase;
        this.userCreateApiMapper = userCreateApiMapper;
    }

    public ResponseEntity<CreateUserResponse> registerUser(UserRequest userRequest, HttpServletRequest request){
        CreateUserResponse userResponse = null;

        try{

            JWTToken jwtToken = new JWTToken();
            userResponse = userUseCase.create(userRequest,jwtToken.getTokenValue(request));

        }catch(DataSourceException | GatewayException | MapperException |
                UserExistException | RepositoryException | UseCaseException |
                EmailUserException | PasswordException exception){
            throw exception;

        }catch(Exception exception){
            LOGGER.error("[TAG: " + LoggerConst.TAG_FAILURE_EXECUTE_USER_CREATE.getValue() + "] , " +
                    "[REQUEST: " + request + " ] , " +
                    "[MESSAGE: " +  exception.getMessage() + "]",exception );
            throw new DelegateException(exception.getMessage(),exception);
        }
        return ResponseEntity.ok(userResponse);
    }
}
