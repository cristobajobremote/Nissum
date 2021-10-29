package cl.nissum.register.data.repository;

import cl.nissum.register.common.enumeration.LoggerConst;
import cl.nissum.register.common.exception.*;
import cl.nissum.register.data.datasource.UserDataSource;
import cl.nissum.register.data.datasource.impl.database.mapper.UserCreateDataSourceMapper;
import cl.nissum.register.domain.entity.UserEntity;
import cl.nissum.register.domain.repository.UserRepository;
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
    private final UserCreateDataSourceMapper userCreateDataSourceMapper;

    public CreateUserRepository(@Qualifier("createUserDataSource") UserDataSource userDataSource,
                                UserCreateDataSourceMapper userCreateDataSourceMapper) {
        this.userDataSource = userDataSource;
        this.userCreateDataSourceMapper = userCreateDataSourceMapper;

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
