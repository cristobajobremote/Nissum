package cl.nissum.register.data.datasource.impl.database;

import cl.nissum.register.common.enumeration.LoggerConst;
import cl.nissum.register.common.exception.DataSourceException;
import cl.nissum.register.common.exception.GatewayException;
import cl.nissum.register.common.exception.MapperException;
import cl.nissum.register.common.exception.UserExistException;
import cl.nissum.register.data.datasource.UserDataSource;
import cl.nissum.register.data.datasource.impl.database.gateway.UserDataSourceGateway;
import cl.nissum.register.data.datasource.impl.database.model.UserDataBaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.Optional;
@Component
@Qualifier("findUserByEmailDataSource")
public class FindUserByEmailDataSource implements UserDataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final UserDataSourceGateway userDataSourceGateway;

    public FindUserByEmailDataSource(UserDataSourceGateway userDataSourceGateway) {
        this.userDataSourceGateway = userDataSourceGateway;
    }
    @Override
    public Optional<UserDataBaseModel> findUserByEmail(String email){
        Optional<UserDataBaseModel> searchUserByEmail;
        try{
            searchUserByEmail =  userDataSourceGateway.findByEmail(email);

        }catch(GatewayException | MapperException | UserExistException exception){
            throw exception;
        }catch(Exception exception){
            LOGGER.error("[TAG: " + LoggerConst.TAG_FAILURE_EXECUTE_USER_CREATE.getValue() + "] , " +
                    "[REQUEST: " + email + " ] , " +
                    "[MESSAGE: " +  exception.getMessage() + "]",exception );
            throw new DataSourceException(exception.getMessage(),exception);
        }
        return searchUserByEmail;

    }
}
