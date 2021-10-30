package cl.nisum.bffuser.data.repository;

import cl.nisum.bffuser.common.enumeration.LoggerConst;
import cl.nisum.bffuser.common.exception.DataSourceException;
import cl.nisum.bffuser.common.exception.GatewayException;
import cl.nisum.bffuser.common.exception.MapperException;
import cl.nisum.bffuser.common.exception.RepositoryException;
import cl.nisum.bffuser.data.datasource.UserDataSource;
import cl.nisum.bffuser.data.datasource.impl.database.mapper.UserFindDataSourceMapper;
import cl.nisum.bffuser.data.datasource.impl.database.model.UserDataBaseModel;
import cl.nisum.bffuser.domain.entity.UserEntity;
import cl.nisum.bffuser.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

@Component
@Qualifier("findUserByEmailRepository")
public class FindUserByEmailRepository implements UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final UserDataSource userDataSource;
    private final UserFindDataSourceMapper userFindDataSourceMapper;

    public FindUserByEmailRepository(@Qualifier("findUserByEmailDataSource") UserDataSource userDataSource,
                                    UserFindDataSourceMapper userFindDataSourceMapper) {
        this.userDataSource = userDataSource;
        this.userFindDataSourceMapper  =userFindDataSourceMapper;
    }

    @Override
    public UserEntity findUserByEmail(String email){

        UserEntity userEntity = null;
        Optional<UserDataBaseModel> userDataBaseModel;
        try {
            userDataBaseModel  = userDataSource.findUserByEmail(email);
            if(userDataBaseModel.isPresent()){
                userEntity  = userFindDataSourceMapper.mapDataSourceModelToDomainEntity(userDataBaseModel.get());
            }

        }catch (DataSourceException | GatewayException | MapperException
                 exception){
            throw exception;
        }catch (Exception exception){
            LOGGER.error("[TAG: " + LoggerConst.TAG_FAILURE_EXECUTE_USER_CREATE.getValue() + "] , " +
                    "[REQUEST: " + email + " ] , " +
                    "[MESSAGE: " +  exception.getMessage() + "]",exception );
            throw new RepositoryException(exception.getMessage(),exception);
        }
        return userEntity;
    }

}
