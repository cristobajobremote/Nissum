package cl.nisum.bffuser.domain.usecase;

import cl.nisum.bffuser.api.mapper.CreateUserApiMapper;
import cl.nisum.bffuser.api.swagger.model.CreateUserResponse;
import cl.nisum.bffuser.api.swagger.model.UserRequest;
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
public class CreateUserUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final UserRepository createUserRepository;
    private final UserRepository findUserByEmailRepository;
    private final CreateUserApiMapper userCreateApiMapper;
    private final ValidatorData validatorData;
    public CreateUserUseCase(@Qualifier("createUserRepository") UserRepository createUserRepository,
                             @Qualifier("findUserByEmailRepository") UserRepository findUserByEmailRepository,
                             CreateUserApiMapper userCreateApiMapper,
                             ValidatorData validatorData) {
        this.createUserRepository = createUserRepository;
        this.findUserByEmailRepository = findUserByEmailRepository;
        this.userCreateApiMapper = userCreateApiMapper;
        this.validatorData = validatorData;
    }

    public CreateUserResponse create(UserRequest userRequest, String token){
        CreateUserResponse userResponse = null;
        UserEntity userEntitySaved = null;
        try{
            UserEntity user = userCreateApiMapper.mapApiModelToDomainEntity(userRequest,token);
            validateUser(user);
            UserEntity userSearch = findUserByEmailRepository.findUserByEmail(user.getEmail());
            if(userSearch == null){
                 createUserRepository.create(user);
            }else{
                throw new UserExistException(ExceptionTextEnum.USER_EXIST_EXCEPTION.getValue());
            }
            userEntitySaved = findUserByEmailRepository.findUserByEmail(user.getEmail());
            userResponse = userCreateApiMapper.mapDomainEntityToApiModel(userEntitySaved);

        }catch(DataSourceException | GatewayException | MapperException |
                UserExistException | RepositoryException |
                EmailUserException | PasswordException exception){
            throw exception;
        }catch ( Exception exception){
            LOGGER.error("[TAG: " + LoggerConst.TAG_FAILURE_EXECUTE_USER_CREATE.getValue() + "] , " +
                    "[REQUEST: " + userRequest + " ] , " +
                    "[MESSAGE: " +  exception.getMessage() + "]",exception );
            throw new UseCaseException(exception.getMessage(),exception);
        }
        return userResponse;
    }

    private void validateUser(UserEntity userEntity) {


        if(!validatorData.isValidPassword(userEntity.getPassword())){
            throw new PasswordException("Password is not valid, Minimum eight characters, at least one letter and one number");
        }
        if(!validatorData.isValidEmail(userEntity.getEmail())){
            throw new EmailUserException("Email is not valid");
        }
    }


}
