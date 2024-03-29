package cl.nisum.bffuser.domain.usecase;

import cl.nisum.bffuser.api.mapper.FindUserApiMapper;
import cl.nisum.bffuser.api.swagger.model.FindUserRequest;
import cl.nisum.bffuser.api.swagger.model.FindUserResponse;
import cl.nisum.bffuser.api.validator.ValidatorData;
import cl.nisum.bffuser.common.enumeration.ExceptionTextEnum;
import cl.nisum.bffuser.common.enumeration.LoggerConst;
import cl.nisum.bffuser.common.exception.*;
import cl.nisum.bffuser.domain.entity.UserEntity;
import cl.nisum.bffuser.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class FindUserUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final UserRepository userRepository;
    private final FindUserApiMapper findUserApiMapper;
    private final ValidatorData validatorData;
    public FindUserUseCase(@Qualifier("findUserByEmailRepository") UserRepository userRepository,
                           FindUserApiMapper findUserApiMapper,
                           ValidatorData validatorData) {
        this.userRepository = userRepository;
        this.findUserApiMapper = findUserApiMapper;
        this.validatorData = validatorData;
    }

    public FindUserResponse findUser(FindUserRequest findUserRequest){
        FindUserResponse userResponse = null;
        UserEntity userEntity = null;
        try{

            validateFindUser(findUserRequest.getEmail());
            userEntity = userRepository.findUserByEmail(findUserRequest.getEmail());
            if(userEntity==null){
                throw new UserNotExistException(ExceptionTextEnum.USER_NOT_EXIST_EXCEPTION.getValue());
            }
            userResponse = findUserApiMapper.mapDomainEntityToApiModel(userEntity);

        }catch(DataSourceException | GatewayException | MapperException |
            UserExistException | RepositoryException |
                EmailUserException | PasswordException  exception){
            throw exception;
        }catch ( Exception exception) {
            LOGGER.error("[TAG: " + LoggerConst.TAG_FAILURE_EXECUTE_USER_FIND.getValue() + "] , " +
                    "[REQUEST: " + findUserRequest + " ] , " +
                    "[MESSAGE: " + exception.getMessage() + "]", exception);
            throw new UseCaseException(exception.getMessage(), exception);
        }
        return userResponse;
    }
    private void validateFindUser(String email) {

        if(!validatorData.isValidEmail(email)){
            throw new EmailUserException("Email is not valid");
        }
    }
}
