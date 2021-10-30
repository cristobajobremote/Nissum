package cl.nisum.bffuser.data.datasource.impl.database;


import cl.nisum.bffuser.common.enumeration.LoggerConst;
import cl.nisum.bffuser.common.exception.DataSourceException;
import cl.nisum.bffuser.common.exception.GatewayException;
import cl.nisum.bffuser.common.exception.MapperException;
import cl.nisum.bffuser.common.exception.UserExistException;
import cl.nisum.bffuser.data.datasource.UserDataSource;
import cl.nisum.bffuser.data.datasource.impl.database.gateway.UserDataSourceGateway;
import cl.nisum.bffuser.data.datasource.impl.database.mapper.UserCreateDataSourceMapper;
import cl.nisum.bffuser.data.datasource.impl.database.mapper.UserFindDataSourceMapper;
import cl.nisum.bffuser.data.datasource.impl.database.model.UserDataBaseModel;
import cl.nisum.bffuser.domain.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.UUID;


@Component
@Qualifier("createUserDataSource")
public class CreateUserDataSource implements UserDataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final UserDataSourceGateway userDataSourceGateway;
    private final UserCreateDataSourceMapper userCreateDataSourceMapper;
    private final UserFindDataSourceMapper userFindDataSourceMapper;

    public CreateUserDataSource(UserDataSourceGateway userDataSourceGateway,
                                UserCreateDataSourceMapper userCreateDataSourceMapper,
                                UserFindDataSourceMapper userFindDataSourceMapper) {
        this.userDataSourceGateway = userDataSourceGateway;
        this.userCreateDataSourceMapper = userCreateDataSourceMapper;
        this.userFindDataSourceMapper = userFindDataSourceMapper;
    }
    @Override
    public void create(UserEntity userEntity ){

        UserDataBaseModel userDataBaseModel = null;

        try {
            userDataBaseModel = userCreateDataSourceMapper.mapDomainEntityToDataSourceModel(userEntity, UUID.randomUUID().toString());
            userDataBaseModel.getPhones().forEach(k -> k.setId(UUID.randomUUID().toString()));
            userDataSourceGateway.save(userDataBaseModel);

        }catch(GatewayException | MapperException | UserExistException exception){
            throw exception;
        }catch(Exception exception){
            LOGGER.error("[TAG: " + LoggerConst.TAG_FAILURE_EXECUTE_USER_CREATE.getValue() + "] , " +
                    "[REQUEST: " + userDataBaseModel + " ] , " +
                    "[MESSAGE: " +  exception.getMessage() + "]",exception );
            throw new DataSourceException(exception.getMessage(),exception);
        }

    }



}
