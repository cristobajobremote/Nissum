package cl.nissum.register.data.datasource.impl.database.mapper;

import cl.nissum.register.data.datasource.impl.database.model.PhoneDataBaseModel;
import cl.nissum.register.data.datasource.impl.database.model.UserDataBaseModel;
import cl.nissum.register.domain.entity.PhoneEntity;
import cl.nissum.register.domain.entity.UserEntity;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-29T11:27:35-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class UserCreateDataSourceMapperImpl implements UserCreateDataSourceMapper {

    @Override
    public UserDataBaseModel mapDomainEntityToDataSourceModel(UserEntity userEntity, String id) {
        if ( userEntity == null && id == null ) {
            return null;
        }

        UserDataBaseModel userDataBaseModel = new UserDataBaseModel();

        if ( userEntity != null ) {
            userDataBaseModel.setPassword( userEntity.getPassword() );
            userDataBaseModel.setName( userEntity.getName() );
            if ( userEntity.getIsUserActive() != null ) {
                userDataBaseModel.setActive( userEntity.getIsUserActive() );
            }
            userDataBaseModel.setPhones( phoneEntityListToPhoneDataBaseModelList( userEntity.getPhones() ) );
            userDataBaseModel.setEmail( userEntity.getEmail() );
            userDataBaseModel.setToken( userEntity.getToken() );
        }
        if ( id != null ) {
            userDataBaseModel.setId( id );
        }
        userDataBaseModel.setLastLogin( new Timestamp(Instant.now().toEpochMilli()) );
        userDataBaseModel.setCreated( new Timestamp(Instant.now().toEpochMilli()) );

        return userDataBaseModel;
    }

    @Override
    public PhoneDataBaseModel mapDomainEntityToDataSourceModel(PhoneEntity phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDataBaseModel phoneDataBaseModel = new PhoneDataBaseModel();

        phoneDataBaseModel.setNumber( phone.getNumber() );
        phoneDataBaseModel.setCityCode( BigDecimal.valueOf( phone.getCityCode() ) );
        phoneDataBaseModel.setCountryCode( BigDecimal.valueOf( phone.getCountryCode() ) );

        phoneDataBaseModel.setId( phone.getId()!=null ? phone.getId().toString() : null );

        return phoneDataBaseModel;
    }

    @Override
    public UserDataBaseModel mapDomainEntityToDataSourceModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDataBaseModel userDataBaseModel = new UserDataBaseModel();

        userDataBaseModel.setPassword( userEntity.getPassword() );
        userDataBaseModel.setName( userEntity.getName() );
        if ( userEntity.getIsUserActive() != null ) {
            userDataBaseModel.setActive( userEntity.getIsUserActive() );
        }
        userDataBaseModel.setPhones( phoneEntityListToPhoneDataBaseModelList( userEntity.getPhones() ) );
        userDataBaseModel.setEmail( userEntity.getEmail() );
        userDataBaseModel.setToken( userEntity.getToken() );

        userDataBaseModel.setLastLogin( new Timestamp(Instant.now().toEpochMilli()) );
        userDataBaseModel.setCreated( new Timestamp(Instant.now().toEpochMilli()) );
        userDataBaseModel.setId( userEntity.getId().toString() );

        return userDataBaseModel;
    }

    protected List<PhoneDataBaseModel> phoneEntityListToPhoneDataBaseModelList(List<PhoneEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDataBaseModel> list1 = new ArrayList<PhoneDataBaseModel>( list.size() );
        for ( PhoneEntity phoneEntity : list ) {
            list1.add( mapDomainEntityToDataSourceModel( phoneEntity ) );
        }

        return list1;
    }
}
