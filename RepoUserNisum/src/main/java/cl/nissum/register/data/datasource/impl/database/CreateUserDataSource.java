package cl.nissum.register.data.datasource.impl.database;


import cl.nissum.register.common.enumeration.LoggerConst;
import cl.nissum.register.common.exception.DataSourceException;
import cl.nissum.register.common.exception.GatewayException;
import cl.nissum.register.common.exception.MapperException;
import cl.nissum.register.common.exception.UserExistException;
import cl.nissum.register.data.datasource.UserDataSource;
import cl.nissum.register.data.datasource.impl.database.gateway.UserDataSourceGateway;
import cl.nissum.register.data.datasource.impl.database.mapper.UserCreateDataSourceMapper;
import cl.nissum.register.data.datasource.impl.database.mapper.UserFindDataSourceMapper;
import cl.nissum.register.data.datasource.impl.database.model.UserDataBaseModel;
import cl.nissum.register.domain.entity.UserEntity;
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
