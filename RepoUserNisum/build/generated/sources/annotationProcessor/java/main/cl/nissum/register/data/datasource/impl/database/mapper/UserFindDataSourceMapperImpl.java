package cl.nissum.register.data.datasource.impl.database.mapper;

import cl.nissum.register.data.datasource.impl.database.model.PhoneDataBaseModel;
import cl.nissum.register.data.datasource.impl.database.model.UserDataBaseModel;
import cl.nissum.register.domain.entity.ImmutablePhoneEntity;
import cl.nissum.register.domain.entity.ImmutableUserEntity;
import cl.nissum.register.domain.entity.ImmutableUserEntity.Builder;
import cl.nissum.register.domain.entity.PhoneEntity;
import cl.nissum.register.domain.entity.UserEntity;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-29T16:08:55-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class UserFindDataSourceMapperImpl implements UserFindDataSourceMapper {

    @Override
    public UserEntity mapDataSourceModelToDomainEntity(UserDataBaseModel userDataBaseModel) {
        if ( userDataBaseModel == null ) {
            return null;
        }

        Builder userEntity = ImmutableUserEntity.builder();

        userEntity.setIsUserActive( userDataBaseModel.isActive() );
        userEntity.setPassword( userDataBaseModel.getPassword() );
        userEntity.setName( userDataBaseModel.getName() );
        userEntity.setPhones( phoneDataBaseModelListToPhoneEntityIterable( userDataBaseModel.getPhones() ) );
        userEntity.setEmail( userDataBaseModel.getEmail() );
        userEntity.setToken( userDataBaseModel.getToken() );

        userEntity.setLastLogin( userDataBaseModel.getLastLogin()!=null ? OffsetDateTime.ofInstant(Instant.ofEpochMilli(userDataBaseModel.getLastLogin().getTime()), ZoneId.systemDefault()): null );
        userEntity.setCreated( userDataBaseModel.getCreated()!=null ? OffsetDateTime.ofInstant(Instant.ofEpochMilli(userDataBaseModel.getCreated().getTime()), ZoneId.systemDefault()): null );
        userEntity.setModified( userDataBaseModel.getModified()!=null ? OffsetDateTime.ofInstant(Instant.ofEpochMilli(userDataBaseModel.getModified().getTime()), ZoneId.systemDefault()): null );
        userEntity.setId( UUID.fromString(userDataBaseModel.getId()) );

        return userEntity.build();
    }

    @Override
    public PhoneEntity mapDomainEntityToDataSourceModel(PhoneDataBaseModel phone) {
        if ( phone == null ) {
            return null;
        }

        cl.nissum.register.domain.entity.ImmutablePhoneEntity.Builder phoneEntity = ImmutablePhoneEntity.builder();

        phoneEntity.setNumber( phone.getNumber() );
        if ( phone.getCityCode() != null ) {
            phoneEntity.setCityCode( phone.getCityCode().intValue() );
        }
        if ( phone.getCountryCode() != null ) {
            phoneEntity.setCountryCode( phone.getCountryCode().intValue() );
        }

        phoneEntity.setId( UUID.fromString(phone.getId()) );

        return phoneEntity.build();
    }

    protected Iterable<PhoneEntity> phoneDataBaseModelListToPhoneEntityIterable(List<PhoneDataBaseModel> list) {
        if ( list == null ) {
            return null;
        }

        ArrayList<PhoneEntity> iterable = new ArrayList<PhoneEntity>( list.size() );
        for ( PhoneDataBaseModel phoneDataBaseModel : list ) {
            iterable.add( mapDomainEntityToDataSourceModel( phoneDataBaseModel ) );
        }

        return iterable;
    }
}
