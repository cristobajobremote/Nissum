package cl.nisum.bffuser.data.repository;

import cl.nisum.bffuser.common.enumeration.LoggerConst;
import cl.nisum.bffuser.common.exception.*;
import cl.nisum.bffuser.data.datasource.UserDataSource;
import cl.nisum.bffuser.data.datasource.impl.database.mapper.UserCreateDataSourceMapper;
import cl.nisum.bffuser.domain.entity.UserEntity;
import cl.nisum.bffuser.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;


@Component
@Qualifier("createUserRepository")
public class CreateUserRepository implements UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final UserDataSource userDataSource;

    public CreateUserRepository(@Qualifier("createUserDataSource") UserDataSource userDataSource ) {
        this.userDataSource = userDataSource;
    }

    public void create(UserEntity userEntity){

        try{
            userDataSource.create(userEntity);
        }catch (DataSourceException | GatewayException | MapperException |
                UserExistException exception){
            throw exception;
        }catch (Exception exception){
            LOGGER.error("[TAG: " + LoggerConst.TAG_FAILURE_EXECUTE_USER_CREATE.getValue() + "] , " +
                    "[REQUEST: " + userEntity + " ] , " +
                    "[MESSAGE: " +  exception.getMessage() + "]",exception );
            throw new RepositoryException(exception.getMessage(),exception);
        }


    }
}
